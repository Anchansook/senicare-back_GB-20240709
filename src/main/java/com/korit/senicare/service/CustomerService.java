package com.korit.senicare.service;

import org.springframework.http.ResponseEntity;

import com.korit.senicare.dto.request.customer.PostCustomerRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.customer.GetCustomerListResponseDto;
import com.korit.senicare.dto.response.customer.GetCustomerResponseDto;

public interface CustomerService {

    // 고객 등록
    ResponseEntity<ResponseDto> postCustomer(PostCustomerRequestDto dto);
    // 고객 리스트 보기
    ResponseEntity<? super GetCustomerListResponseDto> getCustomerList();
    // 고객 정보 보기
    ResponseEntity<? super GetCustomerResponseDto> getCustomer(Integer customerNumber);
}
