package com.lizhiwei.common.queue;

import java.util.List;

/**
 * @Author LiZhiWei
 * @Date 2020/7/22
 */
public interface SearchEngineQueue {
    /**
     * 往消息队列存放 URL
     * @param url
     */
    public void send(String msg);
    /**
     * 从消息队列获取
     * @param s
     * @return
     */
    public List<String> get();
}
