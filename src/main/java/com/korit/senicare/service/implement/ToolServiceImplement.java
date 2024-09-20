package com.korit.senicare.service.implement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.senicare.dto.request.tool.PostToolRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.tool.GetToolListResponseDto;
import com.korit.senicare.dto.response.tool.GetToolResponseDto;
import com.korit.senicare.entity.ToolEntity;
import com.korit.senicare.repository.ToolRepository;
import com.korit.senicare.service.ToolService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ToolServiceImplement implements ToolService {

    private final ToolRepository toolRepository;

    // 용품 등록
    @Override
    public ResponseEntity<ResponseDto> postTool(PostToolRequestDto dto) {

        try {

            ToolEntity toolEntity = new ToolEntity(dto); // 엔터티에서 생성자 생성
            toolRepository.save(toolEntity);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();

    }

    // 용품 리스트 보기
    @Override
    public ResponseEntity<? super GetToolListResponseDto> getToolList() {

        List<ToolEntity> toolEntities = new ArrayList<>();
        // 단일 타입에서는 null을 쓰지만, 리스트, 컬렉션 타입은 빈 리스트

        try {

            // 리포지토리에서 쿼리문 작성
            toolEntities = toolRepository.findByOrderByToolNumberDesc();

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetToolListResponseDto.success(toolEntities);

    }

    @Override
    public ResponseEntity<? super GetToolResponseDto> getTool(Integer toolNumber) {

        ToolEntity toolEntity = null;

        try {

            toolEntity = toolRepository.findByToolNumber(toolNumber);
            if (toolEntity == null) return ResponseDto.noExistTool();

        } catch(Exception exception) {  
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetToolResponseDto.success(toolEntity);

    }
    // 리스트로 조회 : 없어도 빈 값으로 반환
    // 단일로 조회 : 없을 때 에러 응답 반환
    
}
