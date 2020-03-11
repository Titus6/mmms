package com.kido.domain;

import com.kido.entity.HouseRoomImg;
import lombok.Data;

import java.util.List;

/**
 * @Auther:taoshuai
 * @Date: 2020/3/6 18:01
 * @Description: com.kido.domain
 * @version: 1.0
 */
@Data
public class HouseRoomImgVo {
    private String title;
    private List<HouseRoomImg> list;

}
