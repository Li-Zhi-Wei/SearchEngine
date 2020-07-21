package com.lizhiwei.webcrawler.env;

/**
 * @Author LiZhiWei
 * @Date 2020/7/21
 */
public class MonitorThreadForFIleQueue {
    private long thresholdAnalyse;// 分析队列阈值
    private SearchEngineFileQueue queueAnalyse;
    private SearchEngineFileQueue queueLinks;
    private TempIndexMap<Long, Long> tempIndexMap;

    public MonitorThreadForFIleQueue(long thresholdAnalyse, SearchEngineFileQueue queueAnalyse,
                                     SearchEngineFileQueue queueLinks, TempIndexMap<Long, Long> tempIndexMap) {
        super();
        this.thresholdAnalyse = thresholdAnalyse;
        this.queueAnalyse = queueAnalyse;
        this.queueLinks = queueLinks;
        this.tempIndexMap = tempIndexMap;
    }

    public void run() {
        firstCheck();
        while (true) {
            try {
                // 每次等待实际
                Thread.sleep(GlobelConfig.THREAD_CHECK_LOOP_PER_MS);
                boolean analyseFull = queueAnalyse.getQueue().getQueueSize() > thresholdAnalyse;
                if (analyseFull) {
                    // 分析队列满
                    ProcessGlobelContext.setStatus(ProcessRunStatus.persistence);
                }
                if (ProcessGlobelContext.getStatus() == ProcessRunStatus.persistence) {
                    // 开启持久化后就不再输出监控信息
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
