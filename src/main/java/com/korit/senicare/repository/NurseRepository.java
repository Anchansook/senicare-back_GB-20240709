package com.korit.senicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korit.senicare.entity.NurseEntity;

@Repository
public interface NurseRepository extends JpaRepository<NurseEntity, String> {

    // 쿼리 작성 후 사용
    boolean existsByUserId(String userId);
    boolean existsByTelNumber(String telNumber);
    
}
