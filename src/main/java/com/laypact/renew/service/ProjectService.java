package com.laypact.renew.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laypact.renew.domain.Project;
import com.laypact.renew.repository.ProjectQueryRepository;
import com.laypact.renew.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired 
	ProjectRepository projectRepositoty;
	@Autowired 
	ProjectQueryRepository projectQueryRepositoty;
	
	public Optional<Project> findById(Long seq){
		return projectRepositoty.findById(seq);
	}
	
	public List<Project> findByNameLike(String subject){
		return projectRepositoty.findBySubjectLike(subject);
	}
	
	public List<Project> queryTest(String subject) {
		return projectQueryRepositoty.queryTest(subject);
	}
	
	public List<Project> selectProjectList(Map<String, Object> map) throws Exception {
		return projectRepositoty.findAll();
	}
}
