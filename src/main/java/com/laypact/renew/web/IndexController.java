package com.laypact.renew.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
	@GetMapping(value = "index")
	public String admin(@RequestParam Map<String, Object> param, HttpServletRequest req, Model model) {
		
		return "web/index";
	}
}
