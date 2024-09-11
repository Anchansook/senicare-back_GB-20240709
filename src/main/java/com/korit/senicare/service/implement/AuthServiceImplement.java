package com.korit.senicare.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.senicare.common.util.AuthNumberCreator;
import com.korit.senicare.dto.request.auth.IdCheckRequestDto;
import com.korit.senicare.dto.request.auth.TelAuthRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.entity.TelAuthNumberEntity;
import com.korit.senicare.provider.SmsProvider;
import com.korit.senicare.repository.NurseRepository;
import com.korit.senicare.repository.TelAuthNumberRepository;
import com.korit.senicare.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final SmsProvider smsProvider;

    private final NurseRepository nurseRepository;
    private final TelAuthNumberRepository telAuthNumberRepository;

    @Override
    public ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto) {

        String userId = dto.getUserId();

        try {

            // 해당 리포지토리에서 사용할 쿼리 작성해야 함
            boolean isExistedId = nurseRepository.existsByUserId(userId); 
            if (isExistedId) return ResponseDto.duplicatedUserId();

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
        
    }

    @Override
    public ResponseEntity<ResponseDto> telAuth(TelAuthRequestDto dto) {

        String telNumber = dto.getTelNumber();

        try {

            boolean isExistedTelNumber = nurseRepository.existsByTelNumber(telNumber);
            if (isExistedTelNumber) return ResponseDto.duplicatedaTelNumber(); 

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        String authNumber = AuthNumberCreator.number4();

        // telNumber에 생성한 4자리의 인증 번호를 전송
        smsProvider.sendMessage(telNumber, authNumber);

        try {
            // 데이터베이스의 tel_auth_number 테이블에 telNumber와 생성한 4자리의 인증 번호를 저장
            TelAuthNumberEntity telAuthNumberEntity = new TelAuthNumberEntity(telNumber, authNumber);
            telAuthNumberRepository.save(telAuthNumberEntity);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();

    }
    
}
