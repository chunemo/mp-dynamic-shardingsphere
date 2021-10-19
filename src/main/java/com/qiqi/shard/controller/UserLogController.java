package com.qiqi.shard.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qiqi.shard.constants.DbConst;
import com.qiqi.shard.mapper.UserLogMapper;
import com.qiqi.shard.model.dto.UserLogGroupDTO;
import com.qiqi.shard.model.entity.UserLogDO;
import com.qiqi.shard.service.IUserLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户记录
 *
 * @author zhongqichun
 * @since 2021/10/18
 */
@RestController
@RequestMapping("/user/log")
public class UserLogController {
    @Resource
    private UserLogMapper userLogMapper;

    @Resource
    private IUserLogService userLogService;

    @DS(DbConst.SHARDING)
    @GetMapping("/userId")
    UserLogDO byUser(String userId) {
        final List<UserLogDO> list = userLogService.list(Wrappers.lambdaQuery(new UserLogDO().setUserId(userId)));
        return list.size() > 0 ? list.get(0) : null;
    }

    @DS(DbConst.SHARDING)
    @GetMapping("/userId2")
    UserLogDO byUser2(String userId) {
        return userLogMapper.byUserId(userId);
    }

    @DS(DbConst.SHARDING)
    @GetMapping("/age")
    List<UserLogDO> byAge(int age) {
        return userLogService.byAge(age);
    }

    @DS(DbConst.SHARDING)
    @GetMapping("/age/join")
    List<UserLogDO> joinAge(int age) {
        return userLogService.joinAge(age);
    }

    @DS(DbConst.SHARDING)
    @GetMapping("/age/sub")
    List<UserLogDO> subAge(int age) {
        return userLogService.subAge(age);
    }

    @DS(DbConst.SHARDING)
    @GetMapping("/age/group")
    List<UserLogGroupDTO> groupByAge() {
        return userLogService.groupByAge();
    }
}
