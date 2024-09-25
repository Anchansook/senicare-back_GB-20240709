package com.korit.senicare.dto.response.nurse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.senicare.dto.response.ResponseCode;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.ResponseMessage;
import com.korit.senicare.entity.NurseEntity;

import lombok.Getter;

//# 로그인 유저 정보 확인

// 생성자 직접 만듦 Setter X
@Getter
public class GetSignInResponseDto extends ResponseDto {

    private String userId;
    private String name;
    private String telNumber;

    public GetSignInResponseDto(NurseEntity nurseEntity) {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userId = nurseEntity.getUserId();
        this.name = nurseEntity.getName();
        this.telNumber = nurseEntity.getTelNumber();

    }
    // 리포지토리 -> 엔터티에서 값을 분해해서 가져올 필요없이 엔터티 자체를 가져와서 값을 넣어줌


    // 클라이언트는 요청 헤더에 Bearer 인증 토큰을 포함하여 요청하고 성공적으로 이루어지면 
    // 성공에 대한 응답으로 토큰에 해당하는 요양사의 아이디와 이름, 전화번호를 응답 받습니다.
    public static ResponseEntity<GetSignInResponseDto> success(NurseEntity nurseEntity) {

        GetSignInResponseDto responseBody = new GetSignInResponseDto(nurseEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);

    }
    
}
