package com.korit.senicare.dto.response;

//# 응답 코드 무결성을 위한 상수 정의 LIKE 약속
// ResponseDTO의 code 상수 

public interface ResponseCode {

    String SUCCESS = "SU";

    String VALIDATION_FAIL = "VF";
    String DUPLICATED_USER_ID = "DI";
    String DUPLICATED_TEL_NUMBER = "DT";

    String TEL_AUTH_FAIL = "TAF";

    String MESSAGE_SEND_FAIL = "TF";
    String DATABASE_ERROR = "DBE";
    
}
