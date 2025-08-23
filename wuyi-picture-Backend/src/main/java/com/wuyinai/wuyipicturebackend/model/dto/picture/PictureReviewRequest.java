package com.wuyinai.wuyipicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 图片审核请求
 * @Author: wuyinai
 * @Date: 2022/5/27 16:05
 */

@Data
public class PictureReviewRequest implements Serializable {
  
    /**  
     * id  
     */  
    private Long id;  
  
    /**  
     * 状态：0-待审核, 1-通过, 2-拒绝  
     */  
    private Integer reviewStatus;  
  
    /**  
     * 审核信息  
     */  
    private String reviewMessage;

    /**
     * 审核时间
     */
    private Date reviewTime;

    private static final long serialVersionUID = 1L;  
}
