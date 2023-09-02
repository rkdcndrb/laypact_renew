package com.laypact.renew.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laypact.renew.dto.QnaDto;
import com.laypact.renew.service.QnaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/qna")
@ApiOperation(value="Q&A 조회", notes="세부사항..")
public class QnaApiController {
	
	@Autowired
	QnaService qnaService;
	
	@GetMapping(value="")
	public String qnaList(QnaDto qna, Model model) {
		model.addAttribute("qnaList", qnaService.findAll());
		return "admin/qna::#qnaArea";
	}
}
