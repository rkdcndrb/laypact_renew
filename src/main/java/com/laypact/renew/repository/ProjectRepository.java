package com.laypact.renew.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.laypact.renew.domain.Project;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	List<Project> findByNameLike(String name);
	
	/*
	 * JPQL
	 */
	@Query("select p from Project p where p.name like :name")
	List<Project> findByNameLikeQuery(@Param("name") String name);
	
	
}
