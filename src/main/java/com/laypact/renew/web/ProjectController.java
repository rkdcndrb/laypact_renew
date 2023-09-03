package com.laypact.renew.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laypact.renew.dto.ProjectDto;
import com.laypact.renew.service.ProjectService;

import lombok.extern.slf4j.Slf4j;


@RequestMapping("web/")
@Controller
@Slf4j
public class ProjectController {
	@Autowired
	public ProjectService projectService;
	
	@GetMapping(value = "project")
	public String webProject(Model model) throws Exception {
		ProjectDto dto = new ProjectDto();
		dto.setUseYnTrue();
		model.addAttribute("projectList",projectService.selectProjectList(dto));
		log.info("{}", model.getAttribute("projectList"));

		return "web/project";
	}
	
	@GetMapping(value = "project-detail")
	public String webProjectDetail(@RequestParam long seq, Model model) throws Exception {
		ProjectDto dto = new ProjectDto();
		dto.setSeq(seq);
		model.addAttribute("detail", projectService.selectProject(dto).get());
		return "web/project-detail";
	}
}
