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
	
	public void deleteQna(Long seq) {
		qnaRepositoty.deleteById(seq);
	}
	
	public void saveQna(QnaDto dto) {
	    Qna qna = null;
	    if(dto.getSeq()!=null) {
	    	qna = Qna.builder()
	    		.seq(dto.getSeq())
	    		.question(dto.getQuestion())
	    		.ansMain(dto.getAnsMain())
	    		.ansSub(dto.getAnsSub())
	    		.useYn(dto.getUseYn()).build();
	    }else {
	    	qna = Qna.builder()
		    		.question(dto.getQuestion())
		    		.ansMain(dto.getAnsMain())
		    		.ansSub(dto.getAnsSub())
		    		.useYn(dto.getUseYn()).build();
	    }
	    		
		qnaRepositoty.save(qna);
	}
	
}
