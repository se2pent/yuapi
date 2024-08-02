package com.yupi.yuapicommon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yuapicommon.model.entity.InterfaceInfo;

/**
* @author ser_chsh
* @description 针对表【interface_info】的数据库操作Service
* @createDate 2024-07-28 15:10:28
*/
public interface InnerInterfaceInfoService{
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    /**
     * 查询是否有这个接口
     * @param path
     * @param method
     * @return
     */
    InterfaceInfo getInterfaceInfo(String path,String method);
}
