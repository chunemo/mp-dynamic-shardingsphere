package com.qiqi.shard.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.shard.model.entity.UserDO;

/**
 * 用户
 *
 * @author zhongqichun
 * @since 2021/10/15
 */
public interface IUserService extends IService<UserDO> {
    /**
     * 保存
     *
     * @param name 姓名
     * @param age  年龄
     * @return 用户
     * @throws Exception 异常
     */
    UserDO add(String name, int age) throws Exception;

}
