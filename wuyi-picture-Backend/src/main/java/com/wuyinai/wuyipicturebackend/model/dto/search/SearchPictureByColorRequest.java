package com.wuyinai.wuyipicturebackend.model.dto.search;

import lombok.Data;

import java.io.Serializable;

/**
 * 图片搜索请求
 */
@Data
public class SearchPictureByColorRequest implements Serializable {

    /**
     * 图片主色调
     */
    private String picColor;

    /**
     * 空间 id
     */
    private Long spaceId;

    private static final long serialVersionUID = 1L;
}
