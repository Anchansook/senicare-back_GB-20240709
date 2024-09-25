package com.korit.senicare.dto.response.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.senicare.dto.response.ResponseCode;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.ResponseMessage;
import com.korit.senicare.repository.resultSet.GetCustomerResultSet;

import lombok.Getter;

//# 고객 정보 보기를 했을 때 데이터를 전달하기 위한 객체

@Getter
public class GetCustomerResponseDto extends ResponseDto {
    private Integer customerNumber;
    private String profileImage;
    private String name;
    private String birth;
    private String chargerName;
    private String chargerId;
    private String address;

    // 생성자
    private GetCustomerResponseDto(GetCustomerResultSet resultSet) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.customerNumber = resultSet.getCustomerNumber();
        this.profileImage = resultSet.getProfileImage();
        this.name = resultSet.getName();
        this.birth = resultSet.getBirth();
        this.chargerName = resultSet.getChargerName();
        this.chargerId = resultSet.getChargerId();
        this.address = resultSet.getAddress();
    }

    public static ResponseEntity<GetCustomerResponseDto> success(GetCustomerResultSet resultSet) {
        GetCustomerResponseDto responseBody = new GetCustomerResponseDto(resultSet);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
