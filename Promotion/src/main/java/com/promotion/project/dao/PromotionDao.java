package com.promotion.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.promotion.project.domain.Promotion;

@Repository
public interface PromotionDao extends JpaRepository<Promotion, Integer>, JpaSpecificationExecutor<Promotion> {
}
