package com.korit.senicare.entity;

import com.korit.senicare.dto.request.customer.PatchCustomerRequestDto;
import com.korit.senicare.dto.request.customer.PostCustomerRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Entity(name="customers")
@Table(name="customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer customerNumber;
    private String profileImage;
    private String name;
    private String birth;
    private String charger;
    private String address;
    private String location;

    // 생성자
    public CustomerEntity(PostCustomerRequestDto dto) {
        this.profileImage = dto.getProfileImage();
        this.name = dto.getName();
        this.birth = dto.getBirth();
        this.charger = dto.getCharger();
        this.address = dto.getAddress();
        this.location = dto.getLocation();
    }

    // 생성되어 있는 것을 바꾸기 위한 용도 (고객 수정)
    public void patch(PatchCustomerRequestDto dto) {
        this.profileImage = dto.getProfileImage();
        this.name = dto.getName();
        this.birth = dto.getBirth();
        this.charger = dto.getCharger();
        this.address = dto.getAddress();
        this.location = dto.getLocation();
    }
    
}
