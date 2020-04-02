package com.tpsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//整合servlet filter 和 listener  @ServletComponentScan(basePackages = "com.tpsoft.platform.common.servlet")
//如果当前类换路径需要重写报扫描注解@ComponentScan(basePackages=".....")
public class TpsoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpsoftApplication.class, args);
	}
}
