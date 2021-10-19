package com.qiqi.shard.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.shard.mapper.UserLogMapper;
import com.qiqi.shard.model.dto.UserLogGroupDTO;
import com.qiqi.shard.model.entity.UserLogDO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户记录
 *
 * @author zhongqichun
 * @since 2021/10/18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserLogService extends ServiceImpl<UserLogMapper, UserLogDO> implements IUserLogService {

    /**
     * 按年龄关联查询记录
     *
     * @param age 年龄
     * @return 记录
     */
    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<UserLogDO> byAge(int age) {
        return baseMapper.byAge(age);
    }

    /**
     * 按年龄左连接查询记录
     *
     * @param age 年龄
     * @return 记录
     */
    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<UserLogDO> joinAge(int age) {
        return baseMapper.joinAge(age);
    }

    /**
     * 按年龄子查询记录
     *
     * @param age 年龄
     * @return 记录
     */
    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<UserLogDO> subAge(int age) {
        return baseMapper.subAge(age);
    }

    /**
     * 年龄分组
     *
     * @return 用户记录分组DTO
     */
    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<UserLogGroupDTO> groupByAge() {
        return baseMapper.groupByAge();
    }
}
