package com.yinghuaicc.stars.common.utils.excel;

 
import java.util.HashMap;
import java.util.Map;

/**
 * Excel数据导入导出格式化<br>
 * 举例:<br>
 * 数据导出， {lock,{0:正常，1:锁定}}<br>
 * 数据导入,{lock,{正常:0，锁定:1}}
 * @author Goofy <a href="http://www.xdemo.org">http://www.xdemo.org</a>
 */
public class ExcelDataFormatter {
     
    private Map<String,Map<Object,String>> formatter=new HashMap<String, Map<Object,String>>();
 
    public void set(String key,Map<Object,String> map){
        formatter.put(key, map);
    }
     
    public Map<Object,String> get(String key){
        return formatter.get(key);
    }
     
}