package com.promotion.project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.promotion.project.dao.PromotionDao;
import com.promotion.project.domain.Promotion;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PromotionService {
	@Autowired
	private PromotionDao dao;
	
	public Promotion requestOne(int promotionid) {
    	return dao.findOne(promotionid);
	}
	public List<Promotion> requestList(){
		return dao.findAll();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public PromotionService createOne(Promotion promotion){
		dao.save(promotion);
		return this;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public PromotionService updateOne(int promotionid, Promotion promotion){
		promotion.setPromotionid(promotionid);
		dao.save(promotion);
		return this;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteOne(int promotionid){
		if(dao.exists(promotionid)){
			dao.delete(promotionid);
		}
	}
	
	public List<Promotion> requestByTitleAndId(HashMap<String, String> map){
		Specification<Promotion> spec =(root, query, cb)->{
			return cb.and(
					cb.lessThan(root.get("promotionid"), map.get("promotionid"))
					);
			
		};

		return dao.findAll(spec);
	} 
	
}
