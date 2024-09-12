package com.korit.senicare.entity;

import com.korit.senicare.dto.request.auth.SignUpRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="nurses")
@Table(name="nurses")
public class NurseEntity {

    @Id
    private String userId;
    private String password;
    private String name;
    private String telNumber;
    private String joinPath;
    private String snsId;

    // 데이터베이스에 데이터를 삽입하기 위한 생성자
    public NurseEntity(SignUpRequestDto dto) {
        this.userId = dto.getUserId();
        this.password = dto.getPassword();
        this.name = dto.getName();
        this.telNumber = dto.getTelNumber();
        this.joinPath = dto.getJoinPath();
        this.snsId = dto.getSnsId();
    }

}
