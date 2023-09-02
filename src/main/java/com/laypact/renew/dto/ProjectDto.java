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
	private boolean useYn = false;
	private String sortOption;
	
	public void setUseYnTrue () {
		this.useYn = true;
	}
	
}