package com.laypact.renew.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProjectController {
	@GetMapping(value = "admin/project")
	public String adminProject(@RequestParam Map<String, Object> param, HttpServletRequest req, Model model) {
		
		return "admin/project";
	}
}
