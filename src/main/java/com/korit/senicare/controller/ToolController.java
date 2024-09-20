package com.korit.senicare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korit.senicare.dto.request.tool.PatchToolRequestDto;
import com.korit.senicare.dto.request.tool.PostToolRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.tool.GetToolListResponseDto;
import com.korit.senicare.dto.response.tool.GetToolResponseDto;
import com.korit.senicare.service.ToolService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/tool")
@RequiredArgsConstructor
public class ToolController {

    private final ToolService toolService;

    // 용품 등록
    // "빈, /" URL 사용하기 위해선 value 사용
    @PostMapping(value={"", "/"}) 
    public ResponseEntity<ResponseDto> postTool(
        @RequestBody @Valid PostToolRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = toolService.postTool(requestBody);
        return response;
    }

    // 용품 리스트 보기
    @GetMapping(value={"", "/"})
    public ResponseEntity<? super GetToolListResponseDto> getToolList() {
        ResponseEntity<? super GetToolListResponseDto> response = toolService.getToolList();
        return response;
    }

    // 해당 번호 용품 정보 보기
    @GetMapping("/{toolNumber}")
    public ResponseEntity<? super GetToolResponseDto> getTool(
        @PathVariable("toolNumber") Integer toolNumber
    ) {
        ResponseEntity<? super GetToolResponseDto> response = toolService.getTool(toolNumber);
        return response;
    }

    // 용품 수정
    @PatchMapping("/{toolNumber}")
    public ResponseEntity<ResponseDto> patchTool(
        @PathVariable("toolNumber") Integer toolNumber,
        @RequestBody @Valid PatchToolRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = toolService.patchTool(toolNumber, requestBody);
        return response;
    }

    // 용품 삭제
    @DeleteMapping("/{toolNumber}")
    public ResponseEntity<ResponseDto> deleteTool(
        @PathVariable("toolNumber") Integer toolNumber
    ) {
        ResponseEntity<ResponseDto> response = toolService.deleteTool(toolNumber);
        return response;
    }
    
}
