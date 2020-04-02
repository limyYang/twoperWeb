package com.tpsoft.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tpsoft.platform.common.interceptor.TestInterceptor;
/**
 * 
 * Copyright: Copyright (c) 2020 LanRu-Caifu
 * 
 * @ClassName: WebMvcConfig.java
 * @Description: 
 *
 * @version: v1.0.0
 * @author: limy
 * @date: 2020年2月6日 下午6:28:43 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2020年2月6日     limy           v1.0.0               创建
 */
@Configuration
//导入配置文件
//@ImportResource(locations = "classpath:beans.xml")
public class WebMvcConfig implements WebMvcConfigurer{

	//	//普通的json 不提供对应的converter则用系统自带的，如果提供了那么用提供的
	//下面是两种方式
	//	@Bean
	//	MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	//		ObjectMapper om = new ObjectMapper();
	//		om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	//		converter.setObjectMapper(om);
	//		return converter;
	//	}
	//	@Bean
	//	ObjectMapper mapper() {
	//		ObjectMapper om = new ObjectMapper();
	//		om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	//		return om;
	//	}

	//	//fastjson 必须提供FastJsonHttpMessageConverter
	//	@Bean
	//	FastJsonHttpMessageConverter converter() {
	//		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
	//		FastJsonConfig config= new FastJsonConfig();
	//		config.setDateFormat("yyyy-MM-dd HH:mm:ss");
	//		return converter;
	//	}

	//自定义静态资源路径（也可以在配置文件中配置）
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}

	//跨域配置用来替代注解@corssorigin
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//允许的是8081所有请求所有方法，有效期为30秒
		registry.addMapping("/**").allowedOrigins("http://localhost:8081")
		.allowedHeaders("*")
		.allowedMethods("*")
		.maxAge(30*1000);
	}

	//可配置直接跳转的动态页面
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("").setViewName("");
	}



	//注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myTestInterceptor()).addPathPatterns("/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	@Bean
	TestInterceptor myTestInterceptor() {
		return new TestInterceptor();
	}
}
