package com.lizhiwei.webcrawler.env;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author LiZhiWei
 * @Date 2020/7/21
 */
public class ProcessChainContext {

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
     * 上下文参数
     */
    private ConcurrentHashMap<String, Object> context = new ConcurrentHashMap<String, Object>();// 上下文参数

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
     * URL
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * ID
     * @return
     */
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


    /**
     * 获取上下文参数
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return context.get(key);
    }

    /**
     * 设置上下文参数
     *
     * @param key
     * @param val
     */
    public void set(String key, Object val) {
        context.put(key, val);
    }



    @Override
    public String toString() {
        return "ProcessChainContext [url=" + url + ", doc=" + doc + ", context=" + context + "]";
    }



}
