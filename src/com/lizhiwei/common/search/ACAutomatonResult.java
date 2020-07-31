package com.lizhiwei.common.search;

/**
 * AC自动机结果
 * @Author LiZhiWei
 * @Date 2020/7/31
 */
public class ACAutomatonResult {

    private int pos;    //单词起点下标
    private int len;    //单词长度
    private String str; //单词字符串
    private long wordId;
    protected ACAutomatonResult(int pos, int len, String str,long wordId) {
        this.pos = pos;
        this.len = len;
        this.str = str;
        this.wordId=wordId;
    }
    protected ACAutomatonResult(int pos, int len, String str) {
        this.pos = pos;
        this.len = len;
        this.str = str;
    }

    public long getWordId() {
        return wordId;
    }
    /**
     * 偏移量
     *
     * @return
     */
    public int getPos() {
        return pos;
    }

    /**
     * 长度
     *
     * @return
     */
    public int getLen() {
        return len;
    }

    /**
     * 匹配的字符串
     *
     * @return
     */
    public String getStr() {
        return str;
    }

    @Override
    public String toString() {
        //return "ACAutomatonResult [pos=" + pos + ", len=" + len + ", str=" + str + "]";
        return getJson();
    }

    public String getJson() {
        return "{\"pos\":\"" + pos + "\", \"len\":\"" + len + "\", \"str\":\"" + str + "\"}";
    }

}
