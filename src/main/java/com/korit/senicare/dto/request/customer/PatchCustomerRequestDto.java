package com.korit.senicare.dto.request.customer;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//# 고객 수정 데이터를 전달하기 위한 객체

@Getter
@Setter
@NoArgsConstructor
public class PatchCustomerRequestDto {

    @NotBlank
    private String profileImage;

    @NotBlank
    private String name;

    @NotBlank
    private String birth;

    @NotBlank
    private String charger;

    @NotBlank
    private String address;
    
    @NotBlank
    private String location;
    
}
