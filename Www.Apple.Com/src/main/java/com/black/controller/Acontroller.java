package com.black.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Acontroller {

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/apple") String abc() { return "apple"; }
	 */
	@RequestMapping("/apple")
	String apple() {
		return "apple";
	}
	@RequestMapping("/watch")
	String watch() {
		return "watch";
	}
	
	
}