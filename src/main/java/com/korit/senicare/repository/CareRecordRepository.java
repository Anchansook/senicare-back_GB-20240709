package com.korit.senicare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korit.senicare.entity.CareRecordEntity;

import jakarta.transaction.Transactional;

@Repository
public interface CareRecordRepository extends JpaRepository<CareRecordEntity, Integer> {

    // 관리 기록 리스트 보기에서 사용할 쿼리
    List<CareRecordEntity> findByCustomerNumberOrderByRecordNumberDesc(Integer customerNumber);

    // 테이블 수정(삽입, 수정, 삭제)을 저장(적용)하는 어노테이션
    @Transactional
    void deleteByCustomerNumber(Integer customerNumber);
    
}
