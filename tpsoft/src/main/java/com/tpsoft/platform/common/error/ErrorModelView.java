package com.tpsoft.platform.common.error;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ErrorModelView extends DefaultErrorViewResolver {

	public ErrorModelView(ApplicationContext applicationContext, ResourceProperties resourceProperties) {
		super(applicationContext, resourceProperties);
	}

	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
		ModelAndView newmodel = new ModelAndView();
		newmodel.addAllObjects(model);
		newmodel.setViewName("/error/errorPage");
		return newmodel;
	}
	
}
