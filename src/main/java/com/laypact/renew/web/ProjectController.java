package com.laypact.renew.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laypact.renew.service.ProjectService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProjectController {
	@Autowired
	public ProjectService projectService;
	
	@GetMapping(value = "admin/project")
	public String adminProject(@RequestParam Map<String, Object> param, HttpServletRequest req, Model model) throws Exception {
		model.addAttribute("projectList", projectService.selectProjectList(param));
		
		return "admin/project";
	}
	
	@GetMapping(value = "admin/project-write")
	public String projectWrite(@RequestParam Map<String, Object> param, HttpServletRequest req, Model model) throws Exception {
		//model.addAttribute("projectList", projectService.selectProjectList(param));
		
		return "admin/project-write";
	}
}
