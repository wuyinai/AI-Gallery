package com.wuyinai.wuyipicturebackend.model.vo.picture;

import cn.hutool.json.JSONUtil;
import com.wuyinai.wuyipicturebackend.model.entity.Picture;
import com.wuyinai.wuyipicturebackend.model.vo.user.UserVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class PictureVO implements Serializable {

    private Long id;

    private String url;

    private String name;

    private String introduction;

    private List<String> tags;

    private String category;

    private Long picSize;

    private Integer picWidth;

    private Integer picHeight;

    private Double picScale;

    private String picFormat;
    /**
     * 缩略图 url
     */
    private String thumbnailUrl;


    private Long userId;

    private Date createTime;

    private Date editTime;

    private Date updateTime;


    private UserVO user;
    /**
     * 空间 id
     */
    private Long spaceId;


    private static final long serialVersionUID = 1L;

    /**
     * 封装类转对象
     */
    public static Picture voToObj(PictureVO pictureVO){
        if (pictureVO == null){
            return null;
        }
        Picture picture = new Picture();
        BeanUtils.copyProperties(pictureVO,picture);
        //类型不同，需要转换
        picture.setTags(JSONUtil.toJsonStr(pictureVO.getTags()));
        return picture;
    }

    /**
     * 对象转封装类
     */
    public static PictureVO objToVo(Picture picture){
        if (picture == null){
            return null;
        }
        PictureVO pictureVO = new PictureVO();
        BeanUtils.copyProperties(picture,pictureVO);
        //类型不同，需要转换
        pictureVO.setTags(JSONUtil.toList(picture.getTags(),String.class));
        return pictureVO;
    }

}
