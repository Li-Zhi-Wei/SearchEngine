package com.lizhiwei.webcrawler.duplicationfilter;

/**
 * @Author LiZhiWei
 * @Date 2020/7/30
 */
public interface URLFilter {

    /**
     * 返回过滤后的结果
     * @param url
     * @return true 代表过滤通过（可以执行后续代码） false代表过滤不通过（应执行拦截代码）
     */
    public boolean filter(String url);
}
