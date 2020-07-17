package com.lizhiwei.common.util;

/**
 * 基本工具
 * @author lizhiwei
 */
public class BaseUtil {

    public static String cutStr(String str, int length) {
        String finalStr ;
        if (null == str || str.length() <= length) {
            finalStr = (str == null ? "" : str);
        } else {
            finalStr = str.substring(0, length) + "...";
        }
        return finalStr;
    }

}
