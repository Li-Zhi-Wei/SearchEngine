package com.lizhiwei.common.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * 对同步队列进一步封装
 * @Author LiZhiWei
 * @Date 2020/7/23
 */
public class SearchEngineFileQueue implements SearchEngineQueue{

    ConcurrentFileQueue queue;
    int perMax; // 每次获取的数量

    public SearchEngineFileQueue(String dir, String name, int perMax) {
        this.queue = new ConcurrentFileQueue(dir, name);
        this.perMax = perMax;
    }
    /**
     * 获取队列
     * @return
     */
    public ConcurrentFileQueue getQueue() {
        return queue;
    }

    @Override
    public void send(String url) {
        try {
            queue.write(url.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> get() {
        LinkedList<String> r = new LinkedList<String>();
        try {
            int i = 0;
            //最大读取perMax个数据
            while (i++ < perMax) {
                byte[] get = queue.seqGet();
                if (get == null || get.length == 0) {
                    break;
                }
                r.add(new String(get));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

}
