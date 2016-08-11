package com.promotion.project.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PromotionWebController {
	@GetMapping("/crud")
	public String welcome(Map<String, Object> model) {
		return "crud";
	}

}
