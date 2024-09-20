package com.korit.senicare.service;

import org.springframework.http.ResponseEntity;

import com.korit.senicare.dto.request.tool.PostToolRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.tool.GetToolListResponseDto;

public interface ToolService {

    // 용품 등록
    ResponseEntity<ResponseDto> postTool(PostToolRequestDto dto);
    // 용품 리스트 보기
    ResponseEntity<? super GetToolListResponseDto> getToolList();
    
}
