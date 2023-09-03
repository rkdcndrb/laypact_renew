package com.laypact.renew.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

	private Long seq;
	private String subject;
	private String company;
	private String year;
	private String link;
	private String type;
	private String keyword;
	private String image;
	private String thumbnailImage;
	private String shortDesc;
	private String contentsKr;
	private String contentsEn;
	private Boolean mainYn;
	private Boolean useYn = false;
	private String sortOption;
	
	public void setUseYnTrue () {
		this.useYn = true;
	}
	
}