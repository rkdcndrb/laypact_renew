package com.laypact.renew.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laypact.renew.dto.LoginDto;
import com.laypact.renew.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	@Autowired
	public LoginService loginService;
	
	@GetMapping(value = "admin/login")
	public String admin(@RequestParam Map<String, Object> param, HttpServletRequest req, Model model) {
		
		return "admin/login";
	}
	
	@PostMapping(value = "admin/login")
	public String login(@ModelAttribute("loginForm") LoginDto loginDto,
			            BindingResult bindingResult,
			            @RequestParam(defaultValue = "admin/login") String redirectURL,
			            HttpServletRequest request,
						Model model) throws Exception {

		if (bindingResult.hasErrors()) {
	        return redirectURL;
	    }
		
		boolean isLogin = loginService.selectLogin(loginDto, request);
		
		if(isLogin) {
			redirectURL = "redirect:/admin/project";
		} else {
			
		}
		
		return redirectURL;
	}
}
