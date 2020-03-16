package com.lemon.framework.bean;

/**
 * 返回数据对象
 * Created by lemoon on 2020/3/16 5:08 PM
 */
public class Data {
    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
