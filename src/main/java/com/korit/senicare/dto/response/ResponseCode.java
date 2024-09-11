package com.korit.senicare.dto.response;

//# 응답 코드 무결성을 위한 상수 정의 LIKE 약속
// ResponseDTO의 code 상수 

public interface ResponseCode {

    String SUCCESS = "SU";

    String DUPLICATED_USER_ID = "DI";

    String DATABASE_ERROR = "DBE";
    
}
