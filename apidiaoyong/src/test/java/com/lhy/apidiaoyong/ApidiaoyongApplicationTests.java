package com.lhy.apidiaoyong;


import com.lhy.yuapiclientsdk.YuapiClientConfig;
import com.lhy.yuapiclientsdk.client.ApiClient;
import com.lhy.yuapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApidiaoyongApplicationTests {

	@Resource
	private ApiClient apiClient;


	@Test
	void contextLoads() {

		String result = apiClient.getNameByGet("lhy");
		User user=new User();
		user.setName("lhy");
		String nameByUser = apiClient.getNameByUser(user);
		System.out.println(result);
		System.out.println(nameByUser);

	}

}
