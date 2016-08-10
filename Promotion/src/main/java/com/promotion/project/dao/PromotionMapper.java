package com.promotion.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import com.promotion.project.domain.Promotion;

@Mapper
public interface PromotionMapper {
	@Select("SELECT * FROM promotion WHERE promotionid = #{promotionid}")
	Promotion findOne(@Param("promotionid") int promotionid);
	@Select("SELECT * FROM promotion")
	List<Promotion> findAll();
}
