package com.qiqi.shard.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户记录
 *
 * @author zhongqichun
 * @since 2021/10/18
 */
@Data
@TableName("user_log")
@Accessors(chain = true)
public class UserLogDO implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = -5958951055549502141L;

    /**
     * 主键
     */
    private String id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 创建时间
     */
    private Date createTime;
}
