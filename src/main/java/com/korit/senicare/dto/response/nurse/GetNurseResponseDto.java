package com.korit.senicare.dto.response.nurse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.senicare.dto.response.ResponseCode;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.ResponseMessage;
import com.korit.senicare.entity.NurseEntity;

import lombok.Getter;

//# 요양사 정보 확인 시 주고 받을 데이터 전달 객체

@Getter
public class GetNurseResponseDto extends ResponseDto {
    private String userId;
    private String name;
    private String telNumber;

    // 생성자
    private GetNurseResponseDto(NurseEntity nurseEntity) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userId = nurseEntity.getUserId();
        this.name = nurseEntity.getName();
        this.telNumber = nurseEntity.getTelNumber();
    }

    public static ResponseEntity<GetNurseResponseDto> success(NurseEntity nurseEntity) {
        GetNurseResponseDto responseBody = new GetNurseResponseDto(nurseEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
