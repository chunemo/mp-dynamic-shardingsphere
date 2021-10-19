package com.qiqi.shard.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiqi.shard.model.dto.UserLogGroupDTO;
import com.qiqi.shard.model.entity.UserLogDO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户记录
 *
 * @author zhongqichun
 * @since 2021/10/18
 */
public interface UserLogMapper extends BaseMapper<UserLogDO> {
    /**
     * 按用户查询记录
     *
     * @param userId 用户id
     * @return 记录
     */
    @Select("SELECT * FROM user_log t WHERE t.user_id = #{userId}")
    UserLogDO byUserId(String userId);

    /**
     * 按年龄关联查询记录
     *
     * @param age 年龄
     * @return 记录
     */
    @Select("SELECT t.* FROM user_log t, user u WHERE t.user_id=u.id AND u.age = #{age} ORDER BY t.create_time DESC")
    List<UserLogDO> byAge(int age);

    /**
     * 按年龄左连接查询记录
     *
     * @param age 年龄
     * @return 记录
     */
    @Select("SELECT t.* FROM user_log t LEFT JOIN user u ON t.user_id=u.id WHERE u.age = #{age} ORDER BY t.create_time DESC")
    List<UserLogDO> joinAge(int age);

    /**
     * <p>按年龄子查询记录</p>
     * <p>测试不支持分表子查询</p>
     *
     * @param age 年龄
     * @return 记录
     */
    @Select("SELECT t.* FROM user_log t WHERE t.user_id IN (SELECT u.id FROM user u WHERE u.age = #{age}) ORDER BY t.create_time DESC")
    List<UserLogDO> subAge(int age);

    /**
     * 年龄分组
     *
     * @return 用户记录分组DTO
     */
    @Select("SELECT u.age, count(t.id) count FROM user_log t, user u WHERE t.user_id=u.id GROUP BY u.age DESC")
    List<UserLogGroupDTO> groupByAge();
}
