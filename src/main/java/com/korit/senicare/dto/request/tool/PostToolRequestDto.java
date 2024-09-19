package com.korit.senicare.dto.request.tool;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostToolRequestDto {

    @NotBlank
    private String name;
    @NotBlank
    private String purpose;
    @NotNull
    private Integer count;
    // 추가적으로 0개 이하로 값이 못 들어가도록 설정 가능
    
}
