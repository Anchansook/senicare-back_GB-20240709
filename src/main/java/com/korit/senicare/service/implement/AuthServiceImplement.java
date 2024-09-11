package com.korit.senicare.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.senicare.dto.request.auth.IdCheckRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.repository.NurseRepository;
import com.korit.senicare.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final NurseRepository nurseRepository;

    @Override
    public ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto) {

        String userId = dto.getUserId();

        try {

            // 해당 리포지토리에서 사용할 쿼리 작성해야 함
            boolean isExistedId = nurseRepository.existsByUserId(userId); 

        } catch(Exception exception) {
            exception.printStackTrace();
        }
        
    }
    
}