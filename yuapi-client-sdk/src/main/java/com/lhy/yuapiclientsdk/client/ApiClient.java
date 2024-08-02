package com.lhy.yuapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;

import com.lhy.yuapiclientsdk.model.User;
import com.lhy.yuapiclientsdk.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;

public class ApiClient {

    private static final String GATEWAY_HOST="http://localhost:8090";

    private String accessKey;
    private String secretKey;

    private Long userId;

    public ApiClient(){}

    public ApiClient(String accessKey,String secretKey,Long userId){
        this.accessKey=accessKey;
        this.secretKey=secretKey;
        this.userId=userId;
    }

    public String getNameByGet(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result1= HttpUtil.get(GATEWAY_HOST+"/api/name/", paramMap);
        return result1;
    }

    public String getNameByPost(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result2= HttpUtil.get(GATEWAY_HOST+"/api/name/", paramMap);
        return result2;
    }

    public Map<String,String> getHeaderMap(String body){
        Map<String,String> hashMap=new HashMap<>();
        hashMap.put("accessKey",accessKey);
//        hashMap.put("secretKey",secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body",body);
        hashMap.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
        hashMap.put("sign", SignUtils.getSign(body,secretKey));
        hashMap.put("userId",userId.toString());
        return hashMap;
    }



    public String getNameByUser(User user){
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST+"/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String body = httpResponse.body();
        System.out.println(body);
        return body;
    }

}
