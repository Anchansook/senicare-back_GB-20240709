package com.korit.senicare.dto.response.tool;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.senicare.common.object.Tool;
import com.korit.senicare.dto.response.ResponseCode;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.ResponseMessage;
import com.korit.senicare.entity.ToolEntity;

import lombok.Getter;

@Getter
public class GetToolListResponseDto extends ResponseDto {

    // 직접 작성한 common에 있는 Tool을 import
    private List<Tool> tools;

    // 생성자
    private GetToolListResponseDto(List<ToolEntity> toolEntities) {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.tools = Tool.getList(toolEntities);

    }

    public static ResponseEntity<GetToolListResponseDto> success(List<ToolEntity> toolEntities) {

        GetToolListResponseDto responseBody = new GetToolListResponseDto(toolEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);

        // This method must return a result of type ResponseEntity<GetToolListResponseDto>
        // : return이 있는지 확인!

    }
    
}