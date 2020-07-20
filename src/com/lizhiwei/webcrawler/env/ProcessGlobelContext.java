package com.lizhiwei.webcrawler.env;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 进程配置
 * @Author LiZhiWei
 * @Date 2020/7/20
 */
public class ProcessGlobelContext {
    private static AtomicInteger status = new AtomicInteger(0);

    // map
    private static ConcurrentHashMap<String, Object> ctx = new ConcurrentHashMap<String, Object>();

    public static void put(String k, Object v) {
        ctx.put(k, v);
    }

    public static Object get(String k) {
        return ctx.get(k);
    }

    /**
     * 获取状态
     *
     * @return
     */
    public static ProcessRunStatus getStatus() {
        ProcessRunStatus[] values = ProcessRunStatus.values();
        for (ProcessRunStatus s : values) {
            if (s.getState() == status.get())
                return s;
        }
        return null;
    }

    /**
     * 设置状态
     *
     * @param s
     */
    public static void setStatus(ProcessRunStatus s) {
        status.set(s.getState());
    }

}
