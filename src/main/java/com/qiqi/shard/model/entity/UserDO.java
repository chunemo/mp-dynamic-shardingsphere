package com.qiqi.shard.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户
 *
 * @author zhongqichun
 * @since 2021/10/15
 */
@Data
@TableName("user")
@Accessors(chain = true)
public class UserDO implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 3460169356810580720L;

    /**
     * 主键
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 版本号
     */
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
    /**
     * 逻辑删除
     */
    //@TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Boolean disable;
}
