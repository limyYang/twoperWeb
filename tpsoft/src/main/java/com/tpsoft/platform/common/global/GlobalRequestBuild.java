package com.tpsoft.platform.common.global;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
* Copyright: Copyright (c) 2020 LanRu-Caifu
* 
* @ClassName: GlobalRequestBuild.java
* @Description: 请求预处理
*
* @version: v1.0.0
* @author: limy
* @date: 2020年2月9日 下午1:19:09 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年2月9日     limy           v1.0.0               修改原因
 */
@ControllerAdvice
public class GlobalRequestBuild {
//	@InitBinder("a")
//	public void globalData(WebDataBinder binder){
//		//区分对象对应的属性参数
//		//主要应对传入多个对象参数但是对象中有名字相同的，多个对象可以用a.  b.等区分
//		binder.setFieldDefaultPrefix("a.");
//	}
}
