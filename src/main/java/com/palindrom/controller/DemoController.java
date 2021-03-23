package com.palindrom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.palindrom.service.DemoService;

@RestController
public class DemoController {
	@Autowired
	private DemoService testService;
	
	@PostMapping("/insertLongestPalindrom")
	public String insertLongestPalindrom(@RequestBody String s) {
		return testService.insertLongestPalindrom(s);
	}
	
	@GetMapping("/getLongestPalindrom/{s}")
	public String getLongestPalindrom(@PathVariable("s") String s) {
		return testService.getLongestPalindrom(s);
	}

}
