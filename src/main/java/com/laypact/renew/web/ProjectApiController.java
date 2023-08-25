package com.laypact.renew.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laypact.renew.domain.Project;
import com.laypact.renew.service.ProjectService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/project")
@ApiOperation(value="프로젝트 조회", notes="세부사항..")
public class ProjectApiController {
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping()
	public List<Project> selectAll() {
		return projectService.queryTest("name");
	}
	
}
