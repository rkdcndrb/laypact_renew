package com.laypact.renew.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class QnaDto {

	private Long seq;
	private String question;
	private String ansMain;
	private String ansSub;
	private Boolean useYn;
	
}