package com.laypact.renew.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.laypact.renew.domain.Qna;
import com.laypact.renew.dto.QnaDto;

import jakarta.transaction.Transactional;

@Transactional
public interface QnaRepository extends Repository<Qna, Long> {

	List<Qna> findByUseYn(boolean useYn);
	
	List<Qna> findAll();
	
	void save(Qna ana);
	
    Optional<Qna> deleteById(Long id);
	
}