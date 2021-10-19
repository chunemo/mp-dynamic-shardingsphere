package com.qiqi.shard.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.shard.model.dto.UserLogGroupDTO;
import com.qiqi.shard.model.entity.UserLogDO;

import java.util.List;

/**
 * 用户记录
 *
 * @author zhongqichun
 * @since 2021/10/18
 */
public interface IUserLogService extends IService<UserLogDO> {
    /**
     * 按年龄关联查询记录
     *
     * @param age 年龄
     * @return 记录
     */
    List<UserLogDO> byAge(int age);

    /**
     * 按年龄左连接查询记录
     *
     * @param age 年龄
     * @return 记录
     */
    List<UserLogDO> joinAge(int age);

    /**
     * 按年龄子查询记录
     *
     * @param age 年龄
     * @return 记录
     */
    List<UserLogDO> subAge(int age);

    /**
     * 年龄分组
     *
     * @return 用户记录分组DTO
     */
    List<UserLogGroupDTO> groupByAge();

}
