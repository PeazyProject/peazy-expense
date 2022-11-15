package com.peazy.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peazy.expense.model.entity.SupplierUserEntity;

@Repository
public interface SupplierUserRepository extends JpaRepository<SupplierUserEntity, Long> {
    
}