package com.lhy.apidiaoyong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhy.apidiaoyong.mapper.UserMapper;
import com.yupi.yuapicommon.model.entity.User;
import com.yupi.yuapicommon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
@DubboService
public class InnerUserServiceImpl implements InnerUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokerUser(String userId) {

        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",Long.parseLong(userId));
        User user =userMapper.selectOne(queryWrapper);
        return user;
    }
}
