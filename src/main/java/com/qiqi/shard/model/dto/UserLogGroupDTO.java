package com.qiqi.shard.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户记录分组DTO
 *
 * @author zhongqichun
 * @since 2021/10/19
 */
@Data
@Accessors(chain = true)
public class UserLogGroupDTO implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = -7357331538231824625L;

    /**
     * 年龄
     */
    private Integer age;
    /**
     * 数量
     */
    private Integer count;
}
