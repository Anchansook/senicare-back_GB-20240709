package com.korit.senicare.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.senicare.dto.request.customer.PostCustomerRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.entity.CustomerEntity;
import com.korit.senicare.repository.CustomerRepository;
import com.korit.senicare.repository.NurseRepository;
import com.korit.senicare.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImplement implements CustomerService {

    private final NurseRepository nurseRepository;
    private final CustomerRepository customerRepository;

    @Override
    public ResponseEntity<ResponseDto> postCustomer(PostCustomerRequestDto dto) {

        try {

            // 담당자만 고객 등록을 할 수 있기 때문에 아래 작업 ▼
            String charger = dto.getCharger();
            boolean isExistedNurse = nurseRepository.existsByUserId(charger);
            if (!isExistedNurse) return ResponseDto.noExistUserId();

            // CustomerEntity가서 생성자 생성
            CustomerEntity customerEntity = new CustomerEntity(dto);
            customerRepository.save(customerEntity);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();

    }
    
}
