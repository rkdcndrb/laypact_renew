package com.laypact.renew.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laypact.renew.service.ProjectService;
import com.laypact.renew.service.QnaService;

@RequestMapping("admin/")
@Controller
public class AdminQnaController {
	@Autowired
	public QnaService qnaService;
	
	@GetMapping(value = "qna")
	public String adminQna(Model model) throws Exception {
		model.addAttribute("qnaList", qnaService.findAll());
		return "admin/qna";
	}
}
