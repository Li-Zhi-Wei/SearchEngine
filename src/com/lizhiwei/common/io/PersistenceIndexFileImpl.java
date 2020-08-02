package com.lizhiwei.common.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 储存倒排索引文件实现类
 * @Author LiZhiWei
 * @Date 2020/8/2
 */
public class PersistenceIndexFileImpl implements PersistenceIndex{
    String fileName;
    RandomAccessFile rdFile;
    FileChannel channel;

    public PersistenceIndexFileImpl(String fileName) {
        try {
            this.fileName = fileName;
            File file = new File(fileName);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            rdFile = new RandomAccessFile(file, "rw");
            channel = rdFile.getChannel();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 写入 返回值为文件的offset
     *
     * @return
     * @throws IOException
     */
    public long write(byte[] bytes) {
        long r = -1;
        try {
            MappedByteBuffer bbf = channel.map(FileChannel.MapMode.READ_WRITE, rdFile.length(), bytes.length);
            bbf.put(bytes);
            r = rdFile.length();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return r;
    }

    @Override
    public byte[] read(long s, long e) {
        byte[] bytes = null;
        try {
            bytes = new byte[(int) (e - s)];
            MappedByteBuffer bbf = channel.map(FileChannel.MapMode.READ_ONLY, s, bytes.length);
            bbf.get(bytes);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return bytes;
    }
}
