package com.lizhiwei.webcrawler.duplicationfilter;

/**
 * 调用Java自带的hash函数
 * @Author LiZhiWei
 * @Date 2020/7/30
 */
public class JavaHash implements BloomHash{

    @Override
    public int hash(String s) {
        return s.hashCode() & (Integer.MAX_VALUE);
    }


}
