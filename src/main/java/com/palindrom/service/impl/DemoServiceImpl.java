package com.palindrom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palindrom.model.Demo;
import com.palindrom.repository.DemoRepository;
import com.palindrom.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService{

	@Autowired
	private DemoRepository repository;
	
	@Override
	public String insertLongestPalindrom(String s) {
		if (s == null) return null;
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length() - 1; i++) {
			String palindrome = intermediatePalindrome(s, i, i);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
			palindrome = intermediatePalindrome(s, i, i + 1);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
		}
		saveDetails(s,longest);
		return longest;
	}
	static public String intermediatePalindrome(String s, int left, int right) {
		if (left > right) return null;
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

	private void saveDetails(String s , String longest) {
		Demo t = new Demo();
		t.setName(s);
		t.setLongestPalindrom(longest);
		repository.save(t);
	}

	@Override
	public String getLongestPalindrom(String s) {
		Demo t = repository.findByName(s);
		return t !=null ? t.getLongestPalindrom():"Not Available. Please try with different input";
	}

}
