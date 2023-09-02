package com.laypact.renew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laypact.renew.domain.Qna;
import com.laypact.renew.repository.QnaRepository;

@Service
public class QnaService {
	
	@Autowired 
	QnaRepository qnaRepositoty;
	
	public List<Qna> findAll(){
		return qnaRepositoty.findAll();
	}
	
}
