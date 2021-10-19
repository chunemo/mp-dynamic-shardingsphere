## 参考
    https://blog.csdn.net/dls_123/article/details/114653348
    https://shardingsphere.apache.org/document/legacy/3.x/document/cn/manual/sharding-jdbc/configuration/config-yaml/
    https://mp.baomidou.com/guide/dynamic-datasource.html

## hashCode()可能为负值
    Math.abs(id.hashCode())

## 子查询不支持分表
    示例:
    SELECT t.* FROM user_log t WHERE t.user_id IN (SELECT u.id FROM user u WHERE u.age = #{age})

## 分库情况下, 关联表的分表键须一致
    比如user拆分键为id
    user_log.user_id表关联user.id
    若user_log拆分键为id, 存在情况user存到ds1, 而user_log存到ds2; shardingsphere不会跨存关联查询, 比如不会关联查询ds1.user_1、ds2.user_log_1

## algorithm-expression为groovy表达式
    groovy的除法结果为浮点数
    eg: 3 / 2 = 1.5