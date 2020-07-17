package com.lizhiwei.common.config;

import java.io.File;

/**
 * 管理全局配置
 *
 * @author lizhiwei
 *
 */
public class GlobelConfig {
    /**
     * 设置文件路径
     *
     * @param path 文件夹路径
     */
    public static void setFilePath(String path) {
        if(path==null||"".equals(path)){
            throw new  RuntimeException("文件路径错误");
        }
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdirs();
        }
        FILE_PATH = path;
    }

    /**
     * 获取文件路径
     *
     */
    public static String getFilePath() {
        return FILE_PATH;
    }

    /**
     * 获取持久化偏移量文件路径
     *
     */
    public static String getPersistenceOffsetFilePath() {
        return FILE_PATH + PERSISTENCE_FILE_OFFSET_FILE_NAME;
    }

    /**
     * 获取持久化的索引文件路径
     *
     */
    public static String getPersistenceIdxFilePath() {
        return FILE_PATH + PERSISTENCE_FILE_INDEX_FILE_NAME;
    }

    /**
     * 获取日志文件路径
     *
     */
    public static String getLogFilePath() {
        return FILE_PATH + DEFAULT_LOG_PATH_FILE_NAME;
    }

    /**
     * 默认的路径
     */
    private static String FILE_PATH = "temp";// "D:\\temp";
    /**
     * 默认的日志文件
     */
    private static final String DEFAULT_LOG_PATH_FILE_NAME = "\\log\\demo_search_engine.log";
    /**
     * 持久化 偏移量文件名
     */
    private static final String PERSISTENCE_FILE_OFFSET_FILE_NAME = "\\PERSISTENCE_OFF.bin";
    /**
     * 持久化 索引文件名
     */
    private static final String PERSISTENCE_FILE_INDEX_FILE_NAME = "\\PERSISTENCE_IDX.bin";

}