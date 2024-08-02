package com.yupi.project.service.inner;

import com.yupi.project.service.UserInterfaceInfoService;
import com.yupi.yuapicommon.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;
    @Override
    public boolean invokeCount(Long interfaceInfoId, Long userId) {
       return userInterfaceInfoService.invokeCount(interfaceInfoId,userId);

    }
}
