package com.qiqi.shard.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 姓名VO
 *
 * @author zhongqichun
 * @since 2021/10/15
 */
@Data
@Accessors(chain = true)
public class UserVO implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 4361393599062656859L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;
}
