package com.wuyinai.wuyipicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wuyinai.wuyipicturebackend.model.dto.user.UserQueryRequest;
import com.wuyinai.wuyipicturebackend.model.entity.User;
import com.wuyinai.wuyipicturebackend.model.vo.user.LoginUserVO;
import com.wuyinai.wuyipicturebackend.model.vo.user.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
* @author AS
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-08-21 11:30:02
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @return
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     * @param userAccount
     * @param userPassword
     * @return
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取当前登录用户
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 用户注销
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 获取脱敏后的用户
     * @param user
     */
    UserVO getUserVO(User user);

    /**
     * 获取脱敏后的用户列表
     * @param userList
     * @return
     */
    List<UserVO> getUserVOList(List<User> userList);
    /**
     * 获取查询条件
     * @param userQueryRequest
     * @return
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

    /**
     * 是否为管理员
     *
     * @param user
     * @return
     */
    boolean isAdmin(User user);


    /**
     * 加密
     * @param userPassword
     * @return
     */
    String getEncryptPassword(String userPassword);

    /**
     * 用户脱敏
     * @return
     */
    LoginUserVO getLoginUserVO(User user);



}
