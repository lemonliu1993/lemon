package com.lemon.framework.bean;

import com.lemon.framework.util.CastUtil;
import com.lemon.framework.util.CollectionUtil;

import java.util.Map;

/**
 * 请求参数对象
 * Created by lemoon on 2020/3/16 3:54 PM
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取long型参数值
     */
    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * 获取所有字段信息
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }

    /**
     * 验证参数是否为空
     */
    public boolean isEmpty() {
        return CollectionUtil.isEmpty(paramMap);
    }
}
