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

	public List<Project> queryTest(String subject) {
		return getQueryFactory().select(project)
				.from(project)
				.where(likeSubject(subject))
				.fetch();
		
	}
	
	private BooleanExpression likeSubject(String subject) {
		if(StringUtils.hasText(subject)) {
			return project.subject.like("%" + subject + "%");
		}
		return null;
	}
	
}
