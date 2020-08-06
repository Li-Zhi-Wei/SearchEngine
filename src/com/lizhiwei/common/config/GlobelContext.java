package com.lizhiwei.common.config;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 全局上下文
 * @Author LiZhiWei
 * @Date 2020/8/6
 */
public class GlobelContext {

    // map 用来储存程序运行时用到的各个队列
    private static ConcurrentHashMap<String, Object> ctx = new ConcurrentHashMap<String, Object>();

    public static void put(String k, Object v) {
        ctx.put(k, v);
    }

    public static Object get(String k) {
        return ctx.get(k);
    }
}
