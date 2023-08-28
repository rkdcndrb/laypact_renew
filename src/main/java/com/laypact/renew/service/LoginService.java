package com.laypact.renew.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laypact.renew.component.SessionManager;
import com.laypact.renew.domain.User;
import com.laypact.renew.dto.LoginDto;
import com.laypact.renew.exception.UserNotFoundException;
import com.laypact.renew.repository.UserRepository;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class LoginService {
	
	@Resource
	private SessionManager sessionManager;
	
	@Autowired
	public UserRepository loginRepository;
	
	public boolean selectLogin(LoginDto loginDto) throws UserNotFoundException {
		
		boolean isLogin = false;
		
		Optional<User> login = loginRepository.findByIdAndPassword(loginDto.getId(), loginDto.getPassword());
		
		login.orElseThrow(()->new UserNotFoundException());
		
		sessionManager.builder()
			.id(login.get().getId())
			.name(login.get().getName())
			.loginTime(LocalDateTime.now());

		isLogin = true;
		
		return isLogin;
	}
}