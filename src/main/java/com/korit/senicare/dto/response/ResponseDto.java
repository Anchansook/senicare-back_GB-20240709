package com.korit.senicare.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

//# Response의 공통적 형태
// : 본래 싹 다 만들어 둠
// : 중복되는 코드들 (= 데이터를 전달하기 위한 객체) 
// : 재사용성 ↑, 유지보수성 ↑, 코드 Pretty 

@Getter
@AllArgsConstructor
public class ResponseDto {

    private String code;
    private String message;

    //% "static"
    public static ResponseEntity<ResponseDto> success() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> validationFail() {
        ResponseDto responsBody = new ResponseDto(ResponseCode.VALIDATION_FAIL, ResponseMessage.VALIDATION_FAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsBody);
    }

    public static ResponseEntity<ResponseDto> duplicatedUserId() {
        ResponseDto responsBody = new ResponseDto(ResponseCode.DUPLICATED_USER_ID, ResponseMessage.DUPLICATED_USER_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsBody);
    }

    public static ResponseEntity<ResponseDto> duplicatedaTelNumber() {
        ResponseDto responsBody = new ResponseDto(ResponseCode.DUPLICATED_TEL_NUMBER, ResponseMessage.DUPLICATED_TEL_NUMBER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsBody);
    }

    public static ResponseEntity<ResponseDto> telAuthFail() {
        ResponseDto responsBody = new ResponseDto(ResponseCode.TEL_AUTH_FAIL, ResponseMessage.TEL_AUTH_FAIL);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responsBody);
    }

    public static ResponseEntity<ResponseDto> messageSendFail() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.MESSAGE_SEND_FAIL, ResponseMessage.MESSAGE_SEND_FAIL);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> databaseError() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
    
}
