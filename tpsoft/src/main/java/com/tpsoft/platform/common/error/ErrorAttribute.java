package com.tpsoft.platform.common.error;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
* Copyright: Copyright (c) 2020 LanRu-Caifu
* 
* @ClassName: ErrorAttribute.java
* @Description: 自定义错误描述信息
*
* @version: v1.0.0
* @author: limy
* @date: 2020年2月9日 下午3:22:38 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年2月9日     limy           v1.0.0               创建
 */
@Component
public class ErrorAttribute extends DefaultErrorAttributes{

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

		Map<String,Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
		map.put("myerror", "自己定义的错误信息");
		return super.getErrorAttributes(webRequest, includeStackTrace);
	}

	@Override
	public Throwable getError(WebRequest webRequest) {
		Throwable exception = super.getError(webRequest);
		if(exception instanceof MaxUploadSizeExceededException) {
			webRequest.setAttribute("javax.servlet.error.message", "上传文件超过限制的大小", RequestAttributes.SCOPE_REQUEST);
		}
		return exception;
	}

	
}
