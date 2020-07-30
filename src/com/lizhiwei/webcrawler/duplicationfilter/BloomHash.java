package com.lizhiwei.webcrawler.duplicationfilter;

/**
 * 布隆过滤器使用的hash函数接口
 * @Author LiZhiWei
 * @Date 2020/7/30
 */
public interface BloomHash {

    /**
     * 给布隆过滤器用的 hash
     * 要求返回值在在0x00000000~0x7FFFFFFF之间(0~Integer.MAX_VALUE)
     * 返回值表示位图某一位的下标
     * @param s
     * @return
     */
    int hash(String s);
}
