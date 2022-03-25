package com.qiqi.shard.config.shard;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * <p>长整型分表键hashcode算法</p>
 * <p>table-strategy.standard.precise-algorithm-class-name: com.qiqi.shard.config.shard.LongHashCodeAlgorithm</p>
 *
 * @author zhongqichun
 * @version 1.0
 * @since 2022/3/23 17:15
 */
@Component
public class LongHashCodeAlgorithm implements PreciseShardingAlgorithm<Long> {
    /**
     * 分片
     *
     * @param tableNames           分表集合
     * @param preciseShardingValue 分键值
     * @return 分表
     */
    @Override
    public String doSharding(Collection<String> tableNames, PreciseShardingValue<Long> preciseShardingValue) {
        long index = preciseShardingValue.getValue().longValue() % tableNames.size() + 1;
        for (String t : tableNames) {
            if (t.endsWith("_".concat(String.valueOf(index)))) {
                return t;
            }
        }
        return null;
    }

}
