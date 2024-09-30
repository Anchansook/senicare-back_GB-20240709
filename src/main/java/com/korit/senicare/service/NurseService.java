package com.korit.senicare.service;

import org.springframework.http.ResponseEntity;

import com.korit.senicare.dto.request.nurse.PatchNurseRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.nurse.GetChargedCustomerResponseDto;
import com.korit.senicare.dto.response.nurse.GetNurseListResponseDto;
import com.korit.senicare.dto.response.nurse.GetNurseResponseDto;
import com.korit.senicare.dto.response.nurse.GetSignInResponseDto;

public interface NurseService {

    // 요양사 리스트 보기
    ResponseEntity<? super GetNurseListResponseDto> getNurseList();
    // 요양사 정보 확인
    ResponseEntity<? super GetNurseResponseDto> getNurse(String userId);
    // 로그인 유저 정보 확인
    ResponseEntity<? super GetSignInResponseDto> getSignIn(String userId);
    // 요양사 수정(이름만)
    ResponseEntity<ResponseDto> patchNurse(PatchNurseRequestDto dto, String userId);
    // 담당자의 담당 고객 리스트 불러오기
    ResponseEntity<? super GetChargedCustomerResponseDto> getCharedCustomer(String nurseId);
    
}
