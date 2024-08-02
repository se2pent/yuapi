//package com.lhy.apidiaoyong.service.impl;
//
//import cn.hutool.core.util.RandomUtil;
//import cn.hutool.crypto.digest.DigestUtil;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.yupi.project.common.ErrorCode;
//import com.yupi.project.constant.UserConstant;
//import com.yupi.project.exception.BusinessException;
//import com.yupi.project.mapper.UserMapper;
//import com.yupi.project.service.UserService;
//import com.yupi.yuapicommon.model.entity.User;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.stereotype.Service;
//import org.springframework.util.DigestUtils;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//
///**
// * 用户服务实现类
// *
// * @author yupi
// */
//@Service
//@Slf4j
//public class UserServiceImpl extends ServiceImpl<UserMapper, User>
//        implements UserService {
//
//    @Resource
//    private UserMapper userMapper;
//
//    /**
//     * 盐值，混淆密码
//     */
//    private static final String SALT = "yupi";
//
//
//
//
//
//    /**
//     * 获取当前登录用户
//     *
//     * @param request
//     * @return
//     */
//    @Override
//    public User getLoginUser(HttpServletRequest request) {
//        // 先判断是否已登录
//        Object userObj = request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);
//        User currentUser = (User) userObj;
//        if (currentUser == null || currentUser.getId() == null) {
//            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
//        }
//        // 从数据库查询（追求性能的话可以注释，直接走缓存）
//        long userId = currentUser.getId();
//        currentUser = this.getById(userId);
//        if (currentUser == null) {
//            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
//        }
//        return currentUser;
//    }
//
//    /**
//     * 是否为管理员
//     *
//     * @param request
//     * @return
//     */
//    @Override
//    public boolean isAdmin(HttpServletRequest request) {
//        // 仅管理员可查询
//        Object userObj = request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);
//        User user = (User) userObj;
//        return user != null && UserConstant.ADMIN_ROLE.equals(user.getUserRole());
//    }
//
//    /**
//     * 用户注销
//     *
//     * @param request
//     */
//    @Override
//    public boolean userLogout(HttpServletRequest request) {
//        if (request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE) == null) {
//            throw new BusinessException(ErrorCode.OPERATION_ERROR, "未登录");
//        }
//        // 移除登录态
//        request.getSession().removeAttribute(UserConstant.USER_LOGIN_STATE);
//        return true;
//    }
//
//}
//
//
//
//
