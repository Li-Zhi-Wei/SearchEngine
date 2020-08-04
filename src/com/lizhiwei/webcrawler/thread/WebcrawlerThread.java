package com.lizhiwei.webcrawler.thread;

import com.lizhiwei.common.config.GlobelConfig;
import com.lizhiwei.common.processchain.ProcessChainContext;
import com.lizhiwei.common.processchain.ProcessRunStatus;
import com.lizhiwei.common.queue.SearchEngineQueue;
import com.lizhiwei.common.search.HTMLFetchUtil;
import com.lizhiwei.common.util.RequestUtil;
import com.lizhiwei.common.util.SelfLogger;
import com.lizhiwei.webcrawler.duplicationfilter.URLFilter;
import com.lizhiwei.webcrawler.processchain.WebcrawlerChainExector;

import java.util.List;

/**
 * 爬虫线程
 * @Author LiZhiWei
 * @Date 2020/8/4
 */
public class WebcrawlerThread extends Thread{

    SearchEngineQueue queueLinks;// 利用消费者功能
    List<WebcrawlerChainExector> chainsWebcrawler;// 执行链
    URLFilter filter;// 重复判断器

    public WebcrawlerThread(SearchEngineQueue queueLinks, List<WebcrawlerChainExector> chainsWebcrawler,
                            URLFilter filter) {
        super();
        this.queueLinks = queueLinks;
        this.chainsWebcrawler = chainsWebcrawler;
        this.filter = filter;
    }

    @Override
    public void run() {
        while (true) {
            ProcessRunStatus.loopCheck(ProcessRunStatus.start);// 检测状态
            List<String> res = queueLinks.get();
            for (String url : res) {
                try {
                    if (filter.filter(url)) {
                        SelfLogger.log("爬取URL:" + url);
                        ProcessRunStatus.loopCheck(ProcessRunStatus.start);// 检测状态
                        // 获取URL
                        byte[] bytes = RequestUtil.sendGetForBytes(url);
                        //无数据
                        if(bytes==null || bytes.length==0)
                            continue;
                        // 先用默认编码
                        String doc = new String(bytes, GlobelConfig.DEFAULT_HTML_CHARSET);
                        // 检测编码
                        String charset = HTMLFetchUtil.getHtmlCharset(doc);
                        // 转换成实际编码
                        if (charset != GlobelConfig.DEFAULT_HTML_CHARSET) {
                            doc = new String(bytes, charset);
                        }
                        // 创建调用链上下文
                        ProcessChainContext ctx = new ProcessChainContext(url, doc);
                        for (WebcrawlerChainExector exector : chainsWebcrawler) {
                            // 执行调用链
                            if (!exector.exec(ctx)) {
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                // sleep(10)保证能让出线程 避免过度抢占线程 导致cpu占用暴增
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
