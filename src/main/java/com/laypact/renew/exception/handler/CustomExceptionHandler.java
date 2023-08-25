package com.laypact.renew.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.laypact.renew.exception.ErrorCode;
import com.laypact.renew.exception.ErrorResponse;
import com.laypact.renew.exception.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handlerUserNotFoundException(UserNotFoundException ex, WebRequest req) {
		return buildError(ErrorCode.USER_NOT_FOUND, req);
	}
	
	private ErrorResponse buildError (ErrorCode errorCode, WebRequest req) {
		
		return ErrorResponse.builder()
				.timestamp(LocalDateTime.now())
				.code(errorCode.getCode())
				.message(errorCode.getMsg())
				.httpStatus(errorCode.getStatus())
				.build();
	}
}
