package com.laypact.renew.domain;

import com.laypact.renew.common.audit.AuditBaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString(exclude = {})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "project")
@Builder
public class Project extends AuditBaseEntity<String> {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq", length = 5)
	private Long seq;

	@Column(name = "company", length = 50)
	private String company;
	@Column(name = "subject", length = 50)
	private String subject;
	@Column(name = "type", length = 50)
	private String type;
	@Column(name = "short_desc", length = 500)
	private String shortDesc;
	@Column(name = "contentsKr", length = 2000)
	private String contentsKr;
	@Column(name = "contentsEn", length = 2000)
	private String contentsEn;
	@Column(name = "link", length = 50)
	private String link;
	@Column(name = "year", length = 4)
	private String year;
	@Column(name = "keyword", length = 200)
	private String keyword;
	@Column(name = "image", length = 200)
	private String image;
	@Column(name = "thumbnail_image", length = 200)
	private String thumbnailImage;
	@Column(name = "main_yn", length = 1)
	private Boolean mainYn;
	@Column(name = "use_yn", length = 1)
	private Boolean useYn;
	/* 
	 * 메인 프로젝트 sorting 순서
	 * */
	@Column(name = "sort_order")
	private Integer sortOrder;
	
}
