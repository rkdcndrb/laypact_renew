package com.laypact.renew.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.laypact.renew.dto.LoginDto;
import com.laypact.renew.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	@Autowired
	public LoginService loginService;
	
	@GetMapping(value = "/admin/login")
	public String admin() {
		
		return "admin/login";
	}
	
	@PostMapping(value = "/admin/login")
	public String login(@ModelAttribute LoginDto loginDto) throws Exception {

		log.debug("loginDto : {}", loginDto.toString());
		boolean isLogin = loginService.selectLogin(loginDto);
		
		if(isLogin) {
			return "redirect:/admin/project";
		}
		
		return "";
	}
}
