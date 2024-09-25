package com.korit.senicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korit.senicare.entity.CareRecordEntity;

import jakarta.transaction.Transactional;

@Repository
public interface CareRecordRepository extends JpaRepository<CareRecordEntity, Integer> {

    // 테이블 수정(삽입, 수정, 삭제)을 저장(적용)하는 어노테이션
    @Transactional
    void deleteByCustomerNumber(Integer customerNumber);
    
}
