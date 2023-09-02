package com.laypact.renew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.laypact.renew.domain.Project;
import com.laypact.renew.domain.Qna;
import com.laypact.renew.dto.ProjectDto;
import com.laypact.renew.dto.QnaDto;
import com.laypact.renew.repository.QnaRepository;

@Service
public class QnaService {
	
	@Autowired 
	QnaRepository qnaRepositoty;
	
	public List<Qna> findQnaList(QnaDto dto) {
		if(dto.getUseYn()) {
			return qnaRepositoty.findByUseYn(dto.getUseYn());
		}else {
			return qnaRepositoty.findAll();
		}
	}
	
	public void deleteQna(QnaDto dto) {
		qnaRepositoty.deleteById(dto.getSeq());
	}
	
	public void saveQna(QnaDto dto) {
		qnaRepositoty.save(dto);
	}
	
}
