package com.tpsoft.platform.common.global;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: GlobalExceptionHandler.java
* @Description: 全局的错误处理（系统用另外一种方法以 error开头的类）
*
* @version: v1.0.0
* @author: limy
* @date: 2019年10月22日 下午5:40:16 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年10月22日     limy           v1.0.0               修改原因
 */
@ControllerAdvice
public class GlobalExceptionHandler {
//	@ExceptionHandler(value = Exception.class)
//	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        if(e instanceof MaxUploadSizeExceededException) {
//        	mav.addObject("newerror", "上传文件超过限制");
//        }
//        mav.setViewName("errorPage");
//        return mav;
//    }
}
