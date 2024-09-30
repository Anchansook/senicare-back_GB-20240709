package com.korit.senicare.service.implement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.senicare.dto.request.nurse.PatchNurseRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.nurse.GetNurseListResponseDto;
import com.korit.senicare.dto.response.nurse.GetNurseResponseDto;
import com.korit.senicare.dto.response.nurse.GetSignInResponseDto;
import com.korit.senicare.entity.NurseEntity;
import com.korit.senicare.repository.NurseRepository;
import com.korit.senicare.service.NurseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NurseServiceImplement implements NurseService {

    private final NurseRepository nurseRepository;

    // 로그인 유저 정보 확인
    @Override
    public ResponseEntity<? super GetSignInResponseDto> getSignIn(String userId) {

        NurseEntity nurseEntity = null;

        try {

            nurseEntity = nurseRepository.findByUserId(userId);
            if (nurseEntity == null) return ResponseDto.noExistUserId();

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInResponseDto.success(nurseEntity);

    }

    // 요양사 리스트 보기
    @Override
    public ResponseEntity<? super GetNurseListResponseDto> getNurseList() {

        List<NurseEntity> nurseEntities = new ArrayList<>();

        try {

            nurseEntities = nurseRepository.findAll();

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        
        return GetNurseListResponseDto.success(nurseEntities);

    }

    // 요양사 정보 확인
    @Override
    public ResponseEntity<? super GetNurseResponseDto> getNurse(String userId) {

        NurseEntity nurseEntity = null;

        try {

            nurseEntity = nurseRepository.findByUserId(userId);
            if (nurseEntity == null) return ResponseDto.noExistUserId();

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetNurseResponseDto.success(nurseEntity);

    }
    // 로직 똑같아도 남 정보, 내 정보 불러오기 별개로 작성해야 함

    // 요양사 수정(이름만)
    @Override
    public ResponseEntity<ResponseDto> patchNurse(PatchNurseRequestDto dto, String userId) {

        try {

            String name = dto.getName();

            NurseEntity nurseEntity = nurseRepository.findByUserId(userId);
            if (nurseEntity == null) return ResponseDto.noExistUserId();
            nurseEntity.setName(name);

            nurseRepository.save(nurseEntity);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();

    }
    
}
