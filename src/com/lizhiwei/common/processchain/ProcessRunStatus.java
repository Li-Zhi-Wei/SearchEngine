package com.lizhiwei.common.processchain;

import com.lizhiwei.common.config.GlobelConfig;

/**
 * 进程状态说明
 * @Author LiZhiWei
 * @Date 2020/7/20
 */
public enum ProcessRunStatus {
    /**
     * 停止
     */
    stop(0),
    /**
     * 开始运行分析和爬虫线程 停止持久化线程
     */
    start(1),

    /**
     * 停止运行分析和爬虫线程 开始持久化线程
     */
    persistence(3);
    private int state;

    ProcessRunStatus(int state) {
        this.state = state;
    }

    /**
     * 获取状态
     *
     * @return
     */
    public int getState() {
        return state;
    }

    /**
     * 循环检测
     */
    public static void loopCheck(ProcessRunStatus... statusRuns) {
        while (true) {
            // 有匹配的直接跳出
            for (ProcessRunStatus statusRun : statusRuns) {
                if (ProcessGlobelContext.getStatus() == statusRun) {
                    // break out;//跳出外层循环
                    return;
                }
            }
            // 睡
            try {
                Thread.sleep(GlobelConfig.THREAD_CHECK_LOOP_PER_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
