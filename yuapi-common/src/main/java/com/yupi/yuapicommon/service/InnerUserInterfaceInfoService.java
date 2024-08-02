package com.yupi.yuapicommon.service;


import com.yupi.yuapicommon.model.entity.InterfaceInfo;
import com.yupi.yuapicommon.model.entity.User;
import com.yupi.yuapicommon.model.entity.UserInterfaceInfo;

/**
* @author ser_chsh
* @description 针对表【user_interface_info】的数据库操作Service
* @createDate 2024-07-30 16:51:57
*/
public interface InnerUserInterfaceInfoService {


    boolean invokeCount(Long interfaceInfoId, Long userId);
}
