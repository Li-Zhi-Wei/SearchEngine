package com.lizhiwei.analyse.tempindex;

import java.util.Collection;
import java.util.Map;

/**
 * 倒排索引
 * @Author LiZhiWei
 * @Date 2020/7/29
 * @param <k>
 * @param <v>
 */
public interface TempIndexMap<k,v> {
    /**
     * 放入
     * @param key
     * @param value
     */
    void put(k key, v value);
    /**
     * 放入
     * @param key
     * @param values
     */
    void put(k key, v[] values);
    /**
     * 放入
     * @param key
     * @param values
     */
    void put(k key, Collection<v> values);
    /**
     * 获取全部
     */
    Map<k, Collection<v>> getAll();
    /**
     * key的大小
     */
    int getKeySize();
    /**
     * value的大小
     */
    int getValueSize();
}
