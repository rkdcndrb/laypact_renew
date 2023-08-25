package com.laypact.renew.service;

import java.util.List;
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
	
	public Optional<Project> findById(Long id){
		return projectRepositoty.findById(id);
	}
	
	public List<Project> findByNameLike(String name){
		return projectRepositoty.findByNameLike(name);
	}
	
	public List<Project> queryTest(String name) {
		return projectQueryRepositoty.queryTest(name);
	}
	
}
