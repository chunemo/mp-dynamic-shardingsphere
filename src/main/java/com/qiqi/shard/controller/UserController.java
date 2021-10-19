package com.qiqi.shard.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.qiqi.shard.constants.DbConst;
import com.qiqi.shard.model.entity.UserDO;
import com.qiqi.shard.model.vo.UserVO;
import com.qiqi.shard.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户
 *
 * @author zhongqichun
 * @since 2021/10/15
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @PostMapping("/add")
    @DS(DbConst.SHARDING)
    UserDO add(@RequestBody UserVO vo) throws Exception {
        return userService.add(vo.getName(), vo.getAge());
    }

    @DS(DbConst.SHARD2)
    @PostMapping("/add2")
    UserDO add2(@RequestBody UserVO vo) throws Exception {
        return userService.add(vo.getName(), vo.getAge());
    }

    @DS(DbConst.SHARDING)
    @GetMapping("/count")
    Integer count() {
        return userService.count();
    }

    @DS(DbConst.SHARD2)
    @GetMapping("/count2")
    Integer count2() {
        return userService.count();
    }

    @DS(DbConst.SHARDING)
    @PutMapping("/update")
    boolean update() {
        final List<UserDO> list = userService.list();
        final List<UserDO> list2 = list.stream().filter(u -> !u.getDisable()).collect(Collectors.toList());
        list2.forEach(u -> u.setDisable(true));
        return userService.updateBatchById(list2);
    }

    @DS(DbConst.SHARDING)
    @DeleteMapping("/remove")
    boolean remove() {
        final List<UserDO> list = userService.list();
        final List<String> ids = list.stream().map(UserDO::getId).collect(Collectors.toList());
        return userService.removeByIds(ids);
    }

    @DS(DbConst.SHARDING)
    @DeleteMapping("/removeAll")
    boolean removeAll() {
        return userService.remove(null);
    }

}
