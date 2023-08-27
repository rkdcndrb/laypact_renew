package com.laypact.renew;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.laypact.renew.interceptor.HandleInterceptor;

//import com.mobis.careers.interceptor.HandleInterceptor;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
//	@Value("${file.localPath}")
//	private String fileLocalPath;
//	
//	@Value("${upload.path}")
//	private String uploadPath;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(handleInterceptor())
        .excludePathPatterns("/favicon.ico", "/**/css/**", "/**/scss/**", "/**/fonts/**", "/**/images/**", "/**/js/**", "/**/vendors/**", "/admin/login", "/admin/logout");
	}
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler(uploadPath)
//				.addResourceLocations(fileLocalPath);
//	}
	
	@Bean
	public HandleInterceptor handleInterceptor() {
		
		return new HandleInterceptor();
	}
	
	@Bean
	public MappingJackson2JsonView jsonView() {
		
		return new MappingJackson2JsonView();
	}
}