package com.laypact.renew.common.querydsl;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.querydsl.SimpleEntityPathResolver;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;

@Repository
public abstract class QuerydslRepositorySupport {
	private Class domainClass;
	private Querydsl querydsl;
	private EntityManager entityManager;
	private JPAQueryFactory queryFactory;
	
	protected QuerydslRepositorySupport(Class<?> domainClass) {
		Assert.notNull(domainClass, "Domain class must not be null");
		this.domainClass = domainClass;
	}
	
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		Assert.notNull(entityManager, "Entity manager must not be null");
		JpaEntityInformation entityInfo = JpaEntityInformationSupport.getEntityInformation(domainClass, entityManager);
		SimpleEntityPathResolver entityResolver = SimpleEntityPathResolver.INSTANCE;
		
		EntityPath path = entityResolver.createPath(entityInfo.getJavaType());
		this.entityManager = entityManager;
		this.queryFactory = new JPAQueryFactory(entityManager);
		this.querydsl = new Querydsl(entityManager, new PathBuilder<>(path.getType(), path.getMetadata()));
	}
	
	@PostConstruct
	public void validate() {
		Assert.notNull(entityManager, "Entity manager must not be null");
		Assert.notNull(querydsl, "Querydsl must not be null");
		Assert.notNull(queryFactory, "QueryFactory must not be null");
	}

	protected Querydsl getQuerydsl() {
		return querydsl;
	}

	protected JPAQueryFactory getQueryFactory() {
		return queryFactory;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	protected<T> JPAQuery<T> select(Expression<T> expr) {
		return getQueryFactory().select(expr);
	}
	
	protected<T> JPAQuery<T> selectFrom(EntityPath<T> from) {
		return getQueryFactory().selectFrom(from);
	}
	
	protected <T> Page<T> applyPagination(Pageable pageable, Function<JPAQueryFactory, JPAQuery> contenctQuery,
			Function<JPAQueryFactory, JPAQuery> countQuery) {
		JPAQuery jpaContentQuery = contenctQuery.apply(getQueryFactory());
		List<T> content = getQuerydsl().applyPagination(pageable, jpaContentQuery).fetch();
		JPAQuery<Long> countResult = countQuery.apply(getQueryFactory());
		return PageableExecutionUtils.getPage(content, pageable, countResult::fetchOne);
	}

	
	
}
