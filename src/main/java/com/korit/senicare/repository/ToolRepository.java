package com.korit.senicare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korit.senicare.entity.ToolEntity;

@Repository
public interface ToolRepository extends JpaRepository<ToolEntity, Integer> {

    // 해당 번호 용품 조회 쿼리문
    ToolEntity findByToolNumber(Integer toolNumber);
    // 조회를 위한 쿼리문 작성
    List<ToolEntity> findByOrderByToolNumberDesc();
    
}
