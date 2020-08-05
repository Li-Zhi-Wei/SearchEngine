package com.lizhiwei.query.wordfetch;

import com.lizhiwei.common.search.ACAutomatonResult;

import java.util.List;

/**
 * 根据文本获取分词
 * @Author LiZhiWei
 * @Date 2020/8/5
 */
public interface WordsSearcher {

    /**
     * 根据文本获取分词 返回分词的ID
     */
    public List<Long> queryId(String text);

    /**
     * 根据文本获取分词 返回分词结果
     */
    public List<ACAutomatonResult> query(String text);

    /**
     * 判断是否存在词
     */
    public boolean exist(String text);
}
