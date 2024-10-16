package com.korit.senicare.common.object;

import java.util.ArrayList;
import java.util.List;

import com.korit.senicare.entity.CareRecordEntity;

import lombok.Getter;

//# 관리 기록 리스트 객체

@Getter
public class CareRecord {
    private Integer recordNumber;
    private String recordDate;
    private String contents;
    private String usedToolName;
    private Integer count;

    // 생성자
    private CareRecord(CareRecordEntity careRecordEntity) {
        this.recordNumber = careRecordEntity.getRecordNumber();
        this.recordDate = careRecordEntity.getRecordDate();
        this.contents = careRecordEntity.getContents();
        this.usedToolName = careRecordEntity.getUsedToolName();
        this.count = careRecordEntity.getCount();
    }

    // List<CareRecordEntity> -> List<CareRecord> 바꾸는 작업
    public static List<CareRecord> getList(List<CareRecordEntity> careRecordEntities) {

        List<CareRecord> careRecords = new ArrayList<>();

        for (CareRecordEntity careRecordEntity: careRecordEntities) {
            CareRecord careRecord = new CareRecord(careRecordEntity);
            careRecords.add(careRecord);
        }

        return careRecords;

    }
}
