package com.yinghuaicc.stars.common.utils.uuid;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/1 下午3:52
 * @Description: UUID工具类
 * @Modified:
 */
public class UuidUtil {

    /**
     *@Author:Fly Created in 2018/6/4 上午8:41
     *@Description: 随机生成UUID
     */
    public static String randomUUID(){

        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }

    /**
     *@Author:Fly Created in 2018/6/27 下午6:40
     *@Description: 配置生成特定的UUID
     */
    public static String randomUUID(String str){

        return str+UUID.randomUUID().toString().replace("-","").toLowerCase();
    }

    /**
     *@Author:Fly Created in 2018/6/4 上午8:42
     *@Description: 通过唯一标识生产UUID，比如数据库中ID，如果ID相同则生成的UUID也相同
     */
    public static String nameUUIDFromBytes(byte [] id){

        return UUID.nameUUIDFromBytes(id).toString().replace("-","").toLowerCase();
    }

    /**
     *@Author:kingboy--KingBoyWorld@163.com Created in 2018/6/27 下午4:33
     *@Description: 批量生成UUID
     */
    public static List<String> batchRandomUUID(Integer size){

        return Stream.iterate(1, item -> item + 1)
                .limit(size)
                .map(item -> randomUUID())
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
