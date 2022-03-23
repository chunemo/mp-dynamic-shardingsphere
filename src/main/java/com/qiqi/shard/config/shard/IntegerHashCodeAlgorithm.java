package com.qiqi.shard.config.shard;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**:
 * <p>整形分表键hashcode算法</p>
 * <p>table-strategy.standard.precise-algorithm-class-name: com.qiqi.shard.config.shard.IntegerHashCodeAlgorithm</p>
 *
 * @author zhongqichun
 * @version 1.0
 * @since 2022/3/23 17:15
 */
@Component
public class IntegerHashCodeAlgorithm implements PreciseShardingAlgorithm<Integer> {

    @Override
    public String doSharding(Collection<String> tableNames, PreciseShardingValue<Integer> preciseShardingValue) {
        int index = preciseShardingValue.getValue() % tableNames.size() + 1;
        for (String t : tableNames) {
            if (t.endsWith("_".concat(String.valueOf(index)))) {
                return t;
            }
        }
        return null;
    }

}
