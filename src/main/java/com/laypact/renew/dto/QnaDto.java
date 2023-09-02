package com.laypact.renew.dto;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QnaDto {

	private Long seq;
	private String question;
	private String ansMain;
	private String ansSub;
	private Boolean useYn = false;
	
	public void setUseYnTrue () {
		this.useYn = true;
	}
	
}