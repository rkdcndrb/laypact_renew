package com.laypact.renew.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laypact.renew.dto.ProjectDto;
import com.laypact.renew.service.ProjectService;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("admin/")
@Controller
public class AdminProjectController {
	@Autowired
	public ProjectService projectService;
	
	@GetMapping(value = "project")
	public String adminProject(Model model) throws Exception {
		ProjectDto dto = new ProjectDto();
		model.addAttribute("projectList",projectService.selectProjectList(dto));
		return "admin/project";
	}
	
	@GetMapping(value = "project-write")
	public String projectWrite() throws Exception {
		
		return "admin/project-write";
	}
	
}
