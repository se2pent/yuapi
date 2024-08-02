package com.lhy.apidiaoyong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.lhy.apidiaoyong.mapper")
public class ApidiaoyongApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApidiaoyongApplication.class, args);
	}

}
