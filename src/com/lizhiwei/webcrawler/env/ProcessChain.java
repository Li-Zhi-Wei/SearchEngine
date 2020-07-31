package com.lizhiwei.webcrawler.env;

/**
 * @Author LiZhiWei
 * @Date 2020/7/31
 */
public interface ProcessChain {

    /**
     * 调用链
     * @return 返回false代表结束调用链
     */
    boolean exec(ProcessChainContext ctx);

}
