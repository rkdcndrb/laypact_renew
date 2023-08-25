package com.laypact.renew.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.laypact.renew.common.querydsl.QuerydslRepositorySupport;
import com.laypact.renew.domain.Project;
import static com.laypact.renew.domain.QProject.project;

import com.querydsl.core.types.dsl.BooleanExpression;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProjectQueryRepository extends QuerydslRepositorySupport {
	
	public ProjectQueryRepository() {
		super(Project.class);
	}

	public List<Project> queryTest(String name) {
		return getQueryFactory().select(project)
				.from(project)
				.where(likeName(name))
				.fetch();
		
	}
	
	private BooleanExpression likeName(String name) {
		if(StringUtils.hasText(name)) {
			return project.name.like("%" + name + "%");
		}
		return null;
	}
	
}
