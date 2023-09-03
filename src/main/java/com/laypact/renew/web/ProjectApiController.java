package com.laypact.renew.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.laypact.renew.domain.Project;
import com.laypact.renew.dto.ProjectDto;
import com.laypact.renew.service.ProjectService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/project")
@ApiOperation(value="프로젝트 조회", notes="세부사항..")
@Slf4j
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
	
	@PutMapping(value = "/{seq}/{mainYn}")
	public void projectMainUpdate(@PathVariable long seq, @PathVariable Boolean mainYn){
		projectService.updateMainYn(seq, mainYn);
	}
	
	@ResponseBody
	@PostMapping(value = "")
	public void projectInsert(MultipartHttpServletRequest req) {
		projectService.saveProject(req);
	}
	
	@ResponseBody
	@PutMapping(value = "")
	public void projectUpdate(MultipartHttpServletRequest req) {
		projectService.saveProject(req);
	}
	
	@DeleteMapping(value = "{seq}")
	public void projectDelete(@PathVariable long seq){
		projectService.deleteProject(seq);
	}
}
