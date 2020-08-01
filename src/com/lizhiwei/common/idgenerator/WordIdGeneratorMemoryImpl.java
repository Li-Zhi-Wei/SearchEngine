package com.lizhiwei.common.idgenerator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * ID生成器
 * @Author LiZhiWei
 * @Date 2020/8/1
 */
public class WordIdGeneratorMemoryImpl implements WordIdGenerator{

    private AtomicLong seed=new AtomicLong(0);

    public Long getId(){
        long res = seed.getAndIncrement();
        return res;
    }
}
