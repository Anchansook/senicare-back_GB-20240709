package com.korit.senicare.dto.response.customer;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.senicare.common.object.CareRecord;
import com.korit.senicare.dto.response.ResponseCode;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.ResponseMessage;
import com.korit.senicare.entity.CareRecordEntity;

import lombok.Getter;

//# 관리 기록 작성에 전달하기 위한 데이터 객체

@Getter
public class GetCareRecordListReponseDto extends ResponseDto {

    private List<CareRecord> careRecords;

    private GetCareRecordListReponseDto(List<CareRecordEntity> careRecordEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.careRecords = CareRecord.getList(careRecordEntities);
    }

    public static ResponseEntity<GetCareRecordListReponseDto> success(List<CareRecordEntity> careRecordEntities) {
        GetCareRecordListReponseDto responseBody = new GetCareRecordListReponseDto(careRecordEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
