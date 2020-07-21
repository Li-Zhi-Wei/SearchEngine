package com.lizhiwei.webcrawler.env;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author LiZhiWei
 * @Date 2020/7/21
 */
public class ProcessChainContext {

    public ProcessChainContext(String url, String doc,Long id ) {
        this.url = url;
        this.doc = doc;
        this.id=id;
    }
    public ProcessChainContext(String url, String doc ) {
        this.url = url;
        this.doc = doc;
    }
    /**
     * url
     */
    private String url;
    /**
     * 文档内容
     */
    private String doc;// 文档内容
    /**
     * id
     */
    private Long id;

    /**
     * URL
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    public Long getId() {
        return id;
    }

    /**
     * 文档
     *
     * @return
     */
    public String getDoc() {
        return doc;
    }

    @Override
    public String toString() {
        return "ProcessChainContext";
    }


}
