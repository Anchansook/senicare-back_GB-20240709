package com.korit.senicare.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    // MultipartFile : 파일 업로드 시 사용하는 파일 타입
    String upload(MultipartFile file);

    // Resource : 파일을 반환할 때 사용하는 반환 타입
    Resource getFile(String fileName);
    
}
