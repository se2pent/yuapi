package com.yupi.yuapicommon.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yuapicommon.model.entity.User;


/**
 * 用户服务
 *
 * @author yupi
 */
public interface InnerUserService{
    /**
     * 数据库中查询是否已分配给用户密钥
     * @param accessKey
     * @return
     */
    User getInvokerUser(String accessKey);
}
