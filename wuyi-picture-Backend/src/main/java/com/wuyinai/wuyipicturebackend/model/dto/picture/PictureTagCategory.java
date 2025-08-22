package com.wuyinai.wuyipicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PictureTagCategory implements Serializable {

    private List<String> tagList;

    private List<String> categoryList;


}
