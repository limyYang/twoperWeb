package com.tpsoft.define;

import java.util.ArrayList;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.tpsoft.project.test.ServiceTest;
import com.tpsoft.project.test.User;

import cn.hutool.core.date.DateUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
	@Autowired
	ServiceTest tt;
	
	@org.junit.Test
	public void test() {
		//hutool工具类的配置
		System.out.println(DateUtil.today());
		//用PageInfo对结果进行包装
		PageInfo<Object> obj=new PageInfo<>(new ArrayList<>());
		User user = new User();
		user.setId(3);
		user.setName("limy");;
		tt.addUser(user);
	}
}
