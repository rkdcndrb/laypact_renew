package com.laypact.renew.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laypact.renew.domain.Qna;
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
	public List<Qna> qnaList(QnaDto qna) {
		return qnaService.findQnaList(qna);
	}
	
	@PostMapping(value="")
	public void insert (QnaDto qna) {
		qnaService.saveQna(qna);
	}
	
	@PutMapping(value="")
	public void update (QnaDto qna) {
		qnaService.saveQna(qna);
	}
	
	@DeleteMapping(value="")
	public void delete (QnaDto qna) {
		qnaService.deleteQna(qna);
	}
}
