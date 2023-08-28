package com.laypact.renew.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class LoginDto {

	private Long seq;
	private String name;
	private String auth;
	private String emailAddr;
	private String password;
	private String id;
	
}