package com.lizhiwei.common.util;

/**
 * 基本工具
 * @author lizhiwei
 */
public class BaseUtil {

    /**
     * 字符串超过指定长度就截取，后面变成...
     * @param str
     * @param length
     * @return
     */
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
