package com.wuyinai.wuyipicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wuyinai.wuyipicturebackend.model.dto.picture.PictureQueryRequest;
import com.wuyinai.wuyipicturebackend.model.dto.picture.PictureUploadRequest;
import com.wuyinai.wuyipicturebackend.model.entity.Picture;
import com.wuyinai.wuyipicturebackend.model.entity.User;
import com.wuyinai.wuyipicturebackend.model.vo.picture.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
* @author AS
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-08-22 09:38:02
*/
public interface PictureService extends IService<Picture> {

    /**
     * 上传图片
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(MultipartFile multipartFile, PictureUploadRequest pictureUploadRequest, User loginUser);

    /**
     * 获取查询条件,分页查询
     * @param pictureQueryRequest
     * @return
     */
    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    /**
     * 获取单条数据
     * @param picture
     * @param request
     * @return
     */
    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    /**
     * 分页查询
     * @param picturePage
     * @param request
     * @return
     */
    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    /**
     * 校验数据
     * @param picture
     */
    void validPicture(Picture picture);
}
