package com.qiqi.shard.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.shard.mapper.UserMapper;
import com.qiqi.shard.model.entity.UserDO;
import com.qiqi.shard.model.entity.UserLogDO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户
 *
 * @author zhongqichun
 * @since 2021/10/15
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService extends ServiceImpl<UserMapper, UserDO> implements IUserService {
    @Resource
    private IUserLogService userLogService;

    //private Random random = new Random();

    /**
     * 保存
     *
     * @param name 姓名
     * @param age  年龄
     * @return 用户
     * @throws Exception 异常
     */
    @Override
    public UserDO add(String name, int age) throws Exception {
        final UserDO user = new UserDO()
                .setName(name)
                .setAge(age);
        this.save(user);

        userLogService.save(new UserLogDO()
                .setUserId(user.getId())
                .setCreateTime(new Date()));
        return user;
    }

}
