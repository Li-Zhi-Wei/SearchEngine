package com.lizhiwei.webcrawler.duplicationfilter;

/**
 * 自己实现的简单hash
 * @Author LiZhiWei
 * @Date 2020/7/30
 */
public class SimpleHash implements BloomHash{

    private int seed;

    public SimpleHash(int seed) {
        // this.cap = cap;
        this.seed = seed;
    }

    public int hash(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = seed * res + s.charAt(i);
        }
        // Integer.MAX_VALUE是掩码 屏蔽首位符号位 最终显示0或正数
        return Integer.MAX_VALUE & res;
    }
}
