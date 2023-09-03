package com.laypact.renew.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.laypact.renew.domain.Project;
import com.laypact.renew.dto.ProjectDto;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<Project, Long> {
		
	/*
	 * JPQL
	 */
	@Query("select p from Project p where p.subject like :subject")
	List<Project> findBySubjectLikeQuery(@Param("subject") String subject);
	
	List<Project> findByUseYn(boolean useYn, Sort sortBySortOrderAndYear);

	@Modifying
	@Query("update Project p set p.mainYn = :mainYn where p.seq = :seq")
	void updateMainYn(@Param("seq") long seq,@Param("mainYn") Boolean mainYn);
	
	void save(ProjectDto dto);
}