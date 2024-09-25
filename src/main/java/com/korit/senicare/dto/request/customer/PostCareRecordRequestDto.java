package com.korit.senicare.dto.request.customer;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//# 기록 작성 시 전달할 데이터 객체

@Getter
@Setter
@NoArgsConstructor
public class PostCareRecordRequestDto {
    @NotBlank
    private String contents;
    private Integer usedToolNumber;
    private Integer count;
}
