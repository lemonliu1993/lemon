package com.lemon.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 * Created by lemoon on 20/2/6 上午9:39
 */
public final class StringUtil {

    /**
     * 字符串分隔符
     */
    public static final String SEPARATOR = String.valueOf((char)29);

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }


    public static String[] splitString(String body, String s) {
        return body.split(s);
    }
}
