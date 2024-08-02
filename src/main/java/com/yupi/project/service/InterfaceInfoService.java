package com.yupi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yuapicommon.model.entity.InterfaceInfo;

/**
* @author ser_chsh
* @description 针对表【interface_info】的数据库操作Service
* @createDate 2024-07-28 15:10:28
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
