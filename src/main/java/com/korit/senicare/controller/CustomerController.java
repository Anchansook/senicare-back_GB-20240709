package com.korit.senicare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korit.senicare.dto.request.customer.PostCustomerRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.customer.GetCustomerListResponseDto;
import com.korit.senicare.service.CustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    // 고객 등록 
    @PostMapping(value={"", "/"})
    public ResponseEntity<ResponseDto> postCustomer(
        @RequestBody @Valid PostCustomerRequestDto requestDto
    ) {
        ResponseEntity<ResponseDto> response = customerService.postCustomer(requestDto);
        return response;
    }

    // 고객 리스트 보기
    @GetMapping(value={"", "/"})
    public ResponseEntity<? super GetCustomerListResponseDto> getCustomerList() {
        ResponseEntity<? super GetCustomerListResponseDto> response = customerService.getCustomerList();
        return response;
    }
    
}
