package com.laypact.renew.component;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@AllArgsConstructor
@Builder
@Getter
public class SessionManager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long seq;
	private String id;
	private String auth;
	private String name;
	private LocalDateTime loginTime;
}