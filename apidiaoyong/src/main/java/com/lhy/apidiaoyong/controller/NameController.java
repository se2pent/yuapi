package com.lhy.apidiaoyong.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhy.apidiaoyong.UserConstant;
import com.lhy.apidiaoyong.mapper.UserMapper;
import com.lhy.yuapiclientsdk.model.User;
import com.lhy.yuapiclientsdk.utils.SignUtils;
import com.yupi.yuapicommon.service.InnerUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.management.remote.JMXPrincipal;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/name")
public class NameController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/get")
    public String getNameByGet(String name){

        return "你的名字是"+name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name){
        return "你的名字是"+name;
    }

    @PostMapping("/user")
    public String getNameByUser(@RequestBody User user, HttpServletRequest request){
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        String userId = request.getHeader("userId");
        com.yupi.yuapicommon.model.entity.User invokeUser = userMapper.selectOne(new QueryWrapper<com.yupi.yuapicommon.model.entity.User>().eq("id",Long.parseLong(userId)).select("accessKey","secretKey"));
        //todo 获取当前用户
        if (!accessKey.equals(invokeUser.getAccessKey())){
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(nonce)>10000){
            throw new RuntimeException("无权限");
        }

        String serverSign = SignUtils.getSign(body, invokeUser.getSecretKey());
        if (!sign.equals(serverSign)){
            throw new RuntimeException("无权限");
        }
        return "Post 用户名字是"+user.getName();


    }





}
