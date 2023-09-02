package com.laypact.renew.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laypact.renew.domain.Qna;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface QnaRepository extends JpaRepository<Qna, Long> {
	
	List<Qna> findAll();

}