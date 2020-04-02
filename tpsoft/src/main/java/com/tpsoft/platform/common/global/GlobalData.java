package com.tpsoft.platform.common.global;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
* Copyright: Copyright (c) 2020 LanRu-Caifu
* 
* @ClassName: GlobalData.java
* @Description: 预设的全局变量，在任何controller中都可以访问（model.asMap）
* @version: v1.0.0
* @author: limy
* @date: 2020年2月9日 下午12:55:49 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年2月9日     limy           v1.0.0               修改原因
 */
@ControllerAdvice
public class GlobalData {
	@ModelAttribute(value = "globalInfo")
	public Map<String,Object> globalData(){
		Map<String,Object> map = new HashMap<>();
		map.put("projectName", "twoPersonSoft");
		return map;
	}
}
