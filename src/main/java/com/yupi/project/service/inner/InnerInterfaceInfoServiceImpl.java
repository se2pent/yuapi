package com.yupi.project.service.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.InterfaceInfoMapper;
import com.yupi.yuapicommon.model.entity.InterfaceInfo;
import com.yupi.yuapicommon.service.InnerInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {

    }

    @Override
    public InterfaceInfo getInterfaceInfo(String path, String method) {
        if (StringUtils.isAnyBlank(path,method)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("url",path);
        queryWrapper.eq("method",method);
        InterfaceInfo interfaceInfo = interfaceInfoMapper.selectOne(queryWrapper);
        return interfaceInfo;
    }
}
