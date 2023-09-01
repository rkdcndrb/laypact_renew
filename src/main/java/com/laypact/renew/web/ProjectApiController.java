package com.laypact.renew.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laypact.renew.domain.Project;
import com.laypact.renew.dto.ProjectDto;
import com.laypact.renew.service.ProjectService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/project")
@ApiOperation(value="프로젝트 조회", notes="세부사항..")
public class ProjectApiController {
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping(value = "")
	public List<Project> projectAll(ProjectDto dto){
		return projectService.selectProjectList(dto);
	}
	
	@GetMapping(value = "{seq}")
	public Optional<Project> projectBySeq(@RequestParam ProjectDto dto){
		return projectService.selectProject(dto);
	}
	
}
