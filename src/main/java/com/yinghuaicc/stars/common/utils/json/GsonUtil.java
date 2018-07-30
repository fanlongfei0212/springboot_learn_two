package com.yinghuaicc.stars.common.utils.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Collection;

/**
 * @Author:Fly
 * @Date:Create in 2018/5/29 下午4:50
 * @Description: Gson工具类
 * @Modified:
 */
@Component
public class GsonUtil {

    private Gson gson = null;

    /**
     *@Author:Fly Created in 2018/5/29 下午5:06
     *@Description: 配置Gson
     */
    private Gson Gson(){

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        return gson;
    }

    /**
     *@Author:Fly Created in 2018/5/29 下午5:43
     *@Description: Object -> Json
     */
    public String toJson(Object Modifiers){

        return this.Gson().toJson(Modifiers);
    }

    /**
     *@Author:Fly Created in 2018/5/29 下午7:32
     *@Description: Json -> Object 无泛型使用
     */
    public <T> T toBean(String json, Class<T> target){

        return this.Gson().fromJson(json,target);
    }

    /**
     *@Author:Fly Created in 2018/6/23 下午4:12
     *@Description: Json -> Object 重载，泛型使用，防止泛型擦除
     */
    public <T> T toBean(String json, Type target){

        return this.Gson().fromJson(json, target);
    }

    /**
     *@Author:Fly Created in 2018/5/29 下午7:41
     *@Description: Json -> Collections
     */
    public <E> E toCollection(String json, Class<?> target){

        Type type = new TypeToken<Collection<?>>(){}.getType();

        return this.Gson().fromJson(json,type);
    }
}
