package com.tpsoft.project.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	//跨域
	@CrossOrigin(origins = "http://locahost:8081")
	@GetMapping("/say")
	public List<User> name() {
		List<User> list=new ArrayList<>();
		for(int i=0;i<3;i++) {
			User u=new User();
			u.setId(i);
			u.setName("limingyang");
			list.add(u);
		}
		
		return list;
	}
}
