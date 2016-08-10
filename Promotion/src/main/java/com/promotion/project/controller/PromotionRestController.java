package com.promotion.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.promotion.project.dao.PromotionMapper;
import com.promotion.project.domain.Promotion;
import com.promotion.project.service.PromotionService;

@RestController
@RequestMapping("/promotion")
public class PromotionRestController {

	@Autowired
	private PromotionService service;
	@Autowired
	private PromotionMapper mapper;

	/*
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Promotion> requestPromotionList() {
        //return service.requestList();
    	return mapper.findAll();
    }
    */
	@RequestMapping(value = "", method = RequestMethod.GET)
    public List<Promotion> requestPromotionList(@RequestParam HashMap<String, String> map) {
    	return service.requestByTitleAndId(map);
    }
	
    @RequestMapping(value = "/{promotionid}", method = RequestMethod.GET)
    public Promotion requestPromotion(@PathVariable("promotionid") int promotionid) {
    	return service.requestOne(promotionid);
    }
    
    @RequestMapping(value = "/{promotionid}", method = RequestMethod.POST)
    public void updatePromotion(@PathVariable("promotionid") int promotionid, @RequestBody Promotion promotion) {
    	service.updateOne(promotionid,promotion);
    }
    
    @RequestMapping(value = "/{promotionid}", method = RequestMethod.DELETE)
    public void deletePromotion(@PathVariable("promotionid") int promotionid) {
    	service.deleteOne(promotionid);
    }
    
    @RequestMapping(value = "/{promotionid}", method = RequestMethod.PUT)
    public void checkPUT() {
    	System.out.println("put");
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPromotion(@RequestBody Promotion promotion) {
    	service.createOne(promotion);
    }
}
