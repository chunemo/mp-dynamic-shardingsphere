package com.qiqi.shard.config.shard;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * <p>字符串分表键hashcode算法</p>
 * <p>table-strategy.standard.precise-algorithm-class-name: com.qiqi.shard.config.shard.LongHashCodeAlgorithm</p>
 *
 * @author zhongqichun
 * @version 1.0
 * @since 2022/3/23 17:15
 */
@Component
public class StringHashCodeAlgorithm implements PreciseShardingAlgorithm<String> {
    /**
     * 分片
     *
     * @param tableNames           分表集合
     * @param preciseShardingValue 分键值
     * @return 分表
     */
    @Override
    public String doSharding(Collection<String> tableNames, PreciseShardingValue<String> preciseShardingValue) {
        int hashCode = this.hashCode(preciseShardingValue.getValue());
        int index = hashCode % tableNames.size() + 1;
        for (String t : tableNames) {
            if (t.endsWith("_".concat(String.valueOf(index)))) {
                return t;
            }
        }
        return null;
    }

    /**
     * hashcode
     *
     * @param s 字符串
     * @return hashcode
     */
    public int hashCode(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int b = (int) s.charAt(i);
            result += b;
        }
        return result;
    }
}
