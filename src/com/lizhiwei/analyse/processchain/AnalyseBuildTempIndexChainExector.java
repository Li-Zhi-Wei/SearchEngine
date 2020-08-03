package com.lizhiwei.analyse.processchain;

import com.lizhiwei.analyse.tempindex.TempIndexMap;
import com.lizhiwei.common.processchain.ProcessChainContext;
import com.lizhiwei.common.search.ACAutomaton;
import com.lizhiwei.common.search.ACAutomatonResult;
import com.lizhiwei.common.util.SelfLogger;

import java.util.LinkedList;
import java.util.List;

/**
 * 构建索引
 * @Author LiZhiWei
 * @Date 2020/8/3
 */
public class AnalyseBuildTempIndexChainExector implements AnalyseChainExector {

    ACAutomaton acAllWords;// 全部词库的ac自动机

    TempIndexMap<Long, Long> tempIndexMap;// 存放倒排索引的结果

    public AnalyseBuildTempIndexChainExector(ACAutomaton acAllWords, TempIndexMap<Long, Long> tempIndexMap) {
        super();
        this.acAllWords = acAllWords;
        this.tempIndexMap = tempIndexMap;
    }

    @Override
    public boolean exec(ProcessChainContext ctx) {
        List<ACAutomatonResult> match = acAllWords.match(ctx.getDoc());
        List<String> wids = new LinkedList<String>();
        List<Long> w = new LinkedList<Long>();
        Long docId = ctx.getId();
        // 构建索引
        for (ACAutomatonResult result : match) {
            wids.add(result.getStr());
            w.add(result.getWordId());
            tempIndexMap.put(result.getWordId(), docId);
        }
        SelfLogger.log("调用链分析结果:did:"+docId+",wids:"+w+",url:"+ctx.getUrl()+"词:"+wids);
        return true;
    }
}
