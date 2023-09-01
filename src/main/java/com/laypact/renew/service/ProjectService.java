package com.laypact.renew.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laypact.renew.domain.Project;
import com.laypact.renew.dto.ProjectDto;
import com.laypact.renew.repository.ProjectQueryRepository;
import com.laypact.renew.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired 
	ProjectRepository projectRepositoty;
	@Autowired 
	ProjectQueryRepository projectQueryRepositoty;
	
	public Optional<Project> selectProject(ProjectDto dto){
		return projectRepositoty.findById(dto.getSeq());
	}
	
	public List<Project> selectProjectList(ProjectDto dto) {
		return projectRepositoty.findAll();
	}
}
