package com.lizhiwei.common.io;

import java.io.IOException;

/**
 * 储存 单词编号 和 单词编号在倒排索引文件中偏移量 对应关系
 * @Author LiZhiWei
 * @Date 2020/8/2
 */
public interface PersistenceOffset {

    /**
     * 写入 返回值为文件的offset
     *
     * @return
     * @throws IOException
     */
    public void write(Long s) ;
    /**
     * 根据索引值获取偏移量
     * 返回值为 long[2],0代表开始位置 1代表结束位置
     * @param idx
     * @return
     */
    public long[] readOffsetByIdx(long idx);
    /**
     * 获取索引大小
     * @return
     */
    public int getSize();

}
