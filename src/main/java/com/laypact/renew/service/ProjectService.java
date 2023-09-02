package com.laypact.renew.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
		if(dto.getUseYn()) {
			return projectRepositoty.findByUseYn(dto.getUseYn()
					, sortBySortOrder().and(sortByYear()));
		}else {
			return projectRepositoty.findAll(sortByYear());
		}
	}
	
	public void deleteProject(ProjectDto dto) {
		projectRepositoty.deleteById(dto.getSeq());
	}
	
	private Sort sortBySortOrder() {
        return Sort.by(Sort.Direction.ASC, "sortOrder");
    }
	
	private Sort sortByYear() {
        return Sort.by(Sort.Direction.ASC, "year");
    }
}
