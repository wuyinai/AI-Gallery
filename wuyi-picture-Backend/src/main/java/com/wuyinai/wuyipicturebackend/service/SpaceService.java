package com.wuyinai.wuyipicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wuyinai.wuyipicturebackend.model.dto.space.SpaceAddRequest;
import com.wuyinai.wuyipicturebackend.model.dto.space.SpaceQueryRequest;
import com.wuyinai.wuyipicturebackend.model.entity.Space;
import com.wuyinai.wuyipicturebackend.model.entity.User;
import com.wuyinai.wuyipicturebackend.model.vo.space.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author AS
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-08-28 21:10:28
*/
public interface SpaceService extends IService<Space> {
    /**
     * 校验空间数据方法
     * @param space
     * @param add
     */
    void validSpace(Space space, boolean add);
    /**
     * 获取查询条件,分页查询
     * @param spaceQueryRequest
     * @return
     */
    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    /**
     * 获取单条数据
     * @param space
     * @param request
     * @return
     */
    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    /**
     * 分页查询
     * @param spacePage
     * @param request
     * @return
     */
    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);




    /**
     * 根据空间等级填充空间信息
     * @param space
     */
    void fillSpaceBySpaceLevel(Space space);

    /**
     * 添加空间
     * @param spaceAddRequest
     * @param loginUser
     * @return
     */
    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);
}
