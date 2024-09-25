package com.korit.senicare.common.object;

import java.util.List;
import java.util.ArrayList;

import com.korit.senicare.entity.NurseEntity;

import lombok.Getter;

// 요양사 리스트 객체
@Getter
public class Nurse {
    private String nurseId;
    private String name;
    private String telNumber;
    
    // 생성자
    private Nurse(NurseEntity nurseEntity) {
        this.nurseId = nurseEntity.getUserId();
        this.name = nurseEntity.getName();
        this.telNumber = nurseEntity.getTelNumber();
    }

    // List<NurseEntity> => List<Nurse> 바꾸는 메서드
    public static List<Nurse> getList(List<NurseEntity> nurseEntities) {

        List<Nurse> nurses = new ArrayList<>();
        // forEach
        for (NurseEntity nurseEntity: nurseEntities) {
            Nurse nurse = new Nurse(nurseEntity);
            nurses.add(nurse);
        }

        return nurses;

    }
}
