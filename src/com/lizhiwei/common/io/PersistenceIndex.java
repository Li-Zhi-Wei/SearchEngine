package com.lizhiwei.common.io;

import java.io.IOException;

/**
 *
 * @Author LiZhiWei
 * @Date 2020/7/25
 */
public interface PersistenceIndex {

    /**
     * 写入 返回值为文件的offset
     *
     * @return
     * @throws IOException
     */
    public long write(byte[] bytes);

    /**
     * 根据起止位置返回
     *
     * @param s
     * @param e
     * @return
     */
    public byte[] read(long s, long e);

}
