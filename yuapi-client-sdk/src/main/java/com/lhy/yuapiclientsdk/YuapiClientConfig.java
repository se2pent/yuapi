package com.lhy.yuapiclientsdk;

import com.lhy.yuapiclientsdk.client.ApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("yuapi.client")
@Data
@ComponentScan
public class YuapiClientConfig {

    private String accessKey;
    private String secretKey;

    private Long userId;

    @Bean
    public ApiClient apiClient(){
       return new ApiClient(accessKey,secretKey,userId);

    }

}
