package com.wuyinai.wuyipicturebackend.aop;

import com.wuyinai.wuyipicturebackend.annotation.AuthCheck;
import com.wuyinai.wuyipicturebackend.exception.BusinessException;
import com.wuyinai.wuyipicturebackend.exception.ErrorCode;
import com.wuyinai.wuyipicturebackend.model.entity.User;
import com.wuyinai.wuyipicturebackend.model.enums.UserRoleEnum;
import com.wuyinai.wuyipicturebackend.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * AOP切面权限校验
 */
@Aspect
@Component
public class AuthInterceptor {
    @Resource
    private UserService userService;


    @Around("@annotation(authCheck)")
    public Object doInterceptor(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        // 获取当前登录用户角色
        String mustRole = authCheck.mustRole();
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        //当前登录用户
        User user = userService.getLoginUser(request);
        UserRoleEnum enumByValue = UserRoleEnum.getEnumByValue(mustRole);
        // 不需要权限，放行
        if (enumByValue == null) {
            return joinPoint.proceed();
        }
        //以下，必须有权限才能通过
        //获取当前用户的权限
        UserRoleEnum userRoleEnum = UserRoleEnum.getEnumByValue(user.getUserRole());
        if (userRoleEnum == null) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        //要求必须要有管理员权限，但用户没有管理员权限，拒绝
        if (UserRoleEnum.ADMIN.equals(enumByValue) && !UserRoleEnum.ADMIN.equals(userRoleEnum)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        return joinPoint.proceed();
    }
}
