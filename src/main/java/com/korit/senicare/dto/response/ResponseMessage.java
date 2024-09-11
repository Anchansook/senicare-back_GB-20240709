package com.korit.senicare.dto.response;

//# 응답 코드 메시지 무결성을 위한 상수 정의 LIKE 약속
// ResponseDTO의 message 상수

public interface ResponseMessage {

    String SUCCESS = "Success.";

    String VALIDATION_FAIL = "Validation failed.";
    String DUPLICATED_USER_ID = "Duplicated user id.";

    String DATABASE_ERROR = "Database error.";
    
}
