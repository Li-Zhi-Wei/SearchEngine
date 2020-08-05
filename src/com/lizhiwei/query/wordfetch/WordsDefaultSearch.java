package com.lizhiwei.query.wordfetch;

import com.lizhiwei.common.search.ACAutomaton;
import com.lizhiwei.common.search.ACAutomatonResult;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author LiZhiWei
 * @Date 2020/8/5
 */
public class WordsDefaultSearch implements WordsSearcher{

    ACAutomaton acAllWords;// 带有全部词库的AC自动机

    public WordsDefaultSearch(ACAutomaton acAllWords) {
        super();
        this.acAllWords = acAllWords;
    }

    /**
     * 根据文本获取分词 返回分词的ID
     */
    public List<Long> queryId(String text) {
        List<ACAutomatonResult> match = acAllWords.match(text);
        List<Long> res = new LinkedList<Long>();
        for (ACAutomatonResult m : match) {
            res.add(m.getWordId());
        }
        return res;
    }
    /**
     * 根据文本获取分词 返回分词的ID
     */
    public List<ACAutomatonResult> query(String text) {
        List<ACAutomatonResult> match = acAllWords.match(text);
        return match;
    }
    /**
     * 判断是否存在
     */
    @Override
    public boolean exist(String text) {
        return acAllWords.exist(text);
    }
}
