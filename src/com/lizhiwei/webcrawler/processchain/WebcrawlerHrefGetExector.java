package com.lizhiwei.webcrawler.processchain;

import com.lizhiwei.common.processchain.ProcessChainContext;
import com.lizhiwei.common.queue.SearchEngineQueue;
import com.lizhiwei.common.search.HTMLFetchUtil;

import java.util.List;

/**
 * 提取url 再放入url队列进行
 * @Author LiZhiWei
 * @Date 2020/8/3
 */
public class WebcrawlerHrefGetExector implements WebcrawlerChainExector{

    public WebcrawlerHrefGetExector(SearchEngineQueue queueLinks) {
        super();
        this.queueLinks = queueLinks;
    }

    SearchEngineQueue queueLinks;//利用生产者功能

    @Override
    public boolean exec(ProcessChainContext ctx) {
        String doc = ctx.getDoc();
        List<String> urls = HTMLFetchUtil.getHtmlAllHref(doc);
        for (String url : urls) {
            try {
                queueLinks.send(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

}
