package com.wuyinai.wuyipicturebackend.model.vo.space;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * 展示给前端的空间等级
 */
@Data
@AllArgsConstructor
public class SpaceLevel {

    private int value;

    private String text;

    private long maxCount;

    private long maxSize;
}
