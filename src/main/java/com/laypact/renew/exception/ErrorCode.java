package com.laypact.renew.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum ErrorCode {
	
	USER_NOT_FOUND("F01", "등록된 사용자가 아닙니다.", HttpStatus.NOT_FOUND.value());

	private final int status;
	private final String code;
	private final String msg;

	ErrorCode(String code, String msg, int status) {
		this.code = code;
		this.msg = msg;
		this.status = status;
	}

}
