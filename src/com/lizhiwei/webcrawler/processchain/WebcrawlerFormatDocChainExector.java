package com.lizhiwei.webcrawler.processchain;

import com.lizhiwei.common.config.GlobelConfig;
import com.lizhiwei.common.processchain.ProcessChainContext;
import com.lizhiwei.common.search.HTMLFetchUtil;
import com.lizhiwei.common.search.HTMLFormatUtil;

/**
 * 格式化HTML，提取目标信息
 * @Author LiZhiWei
 * @Date 2020/8/3
 */
public class WebcrawlerFormatDocChainExector implements WebcrawlerChainExector{

    @Override
    public boolean exec(ProcessChainContext ctx) {
        String doc = ctx.getDoc();
        char[] html = doc.toCharArray();
        //获取标题关键字 描述
        String title = HTMLFetchUtil.getTitle(html);
        String keywords = HTMLFetchUtil.getKeywords(html);
        String desc = HTMLFetchUtil.getDescription(html);
        //格式化后的HTML
        String formatHtml = HTMLFormatUtil.formatHtml(doc);
        ctx.set(GlobelConfig.ANALYSE_FORMAT_HTML_KEY, title + GlobelConfig.CONTENT_FORMAT_SEPARATE + keywords
                + GlobelConfig.CONTENT_FORMAT_SEPARATE + desc + GlobelConfig.CONTENT_FORMAT_SEPARATE + formatHtml);
        return true;
    }

}
