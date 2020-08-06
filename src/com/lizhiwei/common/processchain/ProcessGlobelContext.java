package com.lizhiwei.common.processchain;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 爬虫、分析时全局上下文
 * @Author LiZhiWei
 * @Date 2020/7/20
 */
public class ProcessGlobelContext {

    // 当前进程运行状态
    private static AtomicInteger status = new AtomicInteger(0);

    // map 储存各种队列
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
