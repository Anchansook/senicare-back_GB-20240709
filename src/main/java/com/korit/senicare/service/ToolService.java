package com.korit.senicare.service;

import org.springframework.http.ResponseEntity;

import com.korit.senicare.dto.request.tool.PatchToolRequestDto;
import com.korit.senicare.dto.request.tool.PostToolRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.tool.GetToolListResponseDto;
import com.korit.senicare.dto.response.tool.GetToolResponseDto;

public interface ToolService {

    // 용품 등록
    ResponseEntity<ResponseDto> postTool(PostToolRequestDto dto);
    // 용품 리스트 보기
    ResponseEntity<? super GetToolListResponseDto> getToolList();
    // 해당 번호 용품 정보 보기 
    ResponseEntity<? super GetToolResponseDto> getTool(Integer toolNumber);
    // 용품 수정 (받아오는 형태 2가지)
    ResponseEntity<ResponseDto> patchTool(Integer toolNumber, PatchToolRequestDto dto);
    // 용품 삭제
    ResponseEntity<ResponseDto> deleteTool(Integer toolNumber);
    
}
