package com.korit.senicare.service;

import org.springframework.http.ResponseEntity;

import com.korit.senicare.dto.request.customer.PatchCustomerRequestDto;
import com.korit.senicare.dto.request.customer.PostCareRecordRequestDto;
import com.korit.senicare.dto.request.customer.PostCustomerRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.customer.GetCareRecordListReponseDto;
import com.korit.senicare.dto.response.customer.GetCustomerListResponseDto;
import com.korit.senicare.dto.response.customer.GetCustomerResponseDto;

public interface CustomerService {

    // 고객 등록
    ResponseEntity<ResponseDto> postCustomer(PostCustomerRequestDto dto);
    // 고객 리스트 보기
    ResponseEntity<? super GetCustomerListResponseDto> getCustomerList();
    // 고객 정보 보기
    ResponseEntity<? super GetCustomerResponseDto> getCustomer(Integer customerNumber);
    // 고객 수정
    ResponseEntity<ResponseDto> patchCustomer(PatchCustomerRequestDto dto, Integer customerNumber, String userId); 
                                                                                                   // 접근 주체 아이디
    // 고객 삭제
    ResponseEntity<ResponseDto> deleteCustomer(Integer customerNumber, String userId);
    // 기록 작성
    ResponseEntity<ResponseDto> postCareRecord(PostCareRecordRequestDto dto, Integer customerNumber, String userId);
    // 관리 기록 리스트 보기
    ResponseEntity<? super GetCareRecordListReponseDto> getCareRecordList(Integer customerNumber);
}
