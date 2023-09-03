package com.laypact.renew.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laypact.renew.dto.ProjectDto;
import com.laypact.renew.dto.QnaDto;
import com.laypact.renew.service.ProjectService;
import com.laypact.renew.service.QnaService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
	@Autowired
	public QnaService qnaService;
	
	@Autowired
	public ProjectService projectService;
	
	@GetMapping(value = "index")
	public String admin(@RequestParam Map<String, Object> param, HttpServletRequest req, Model model) {
		// 사용 중인 qna 리스트 조회
		QnaDto qna = new QnaDto();
		qna.setUseYnTrue();
		model.addAttribute("qnaList", qnaService.findQnaList(qna));
		
		// 사용 중인 프로젝트 리스트 조회 
		ProjectDto dto = new ProjectDto();
		dto.setUseYnTrue();
		model.addAttribute("projectList",projectService.selectProjectList(dto));
		
		return "web/index";
	}
}
