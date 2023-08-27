package com.laypact.renew.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class LoginDto {

	private long seq;
	private String name;
	private String auth;
	private String emailAddr;
	private String password;
	private String id;
	
}