package com.lizhiwei.main;

/**
 * @Author LiZhiWei
 * @Date 2020/8/8
 */
public class QueryMain {
    /**
     * 运行 checkAll() 方法会输出所有倒排索引内容，参数改为true可以同时输出html信息
     * 索引输出格式：序号->[单词编号在倒排索引文件中的偏移量]->[倒排索引内容]
     * 运行 queryAndPrint() 可以查词
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        com.lizhiwei.query.QueryMain.init();
//        com.lizhiwei.query.QueryMain.checkAll(false);
        com.lizhiwei.query.QueryMain.queryAndPrint("开放平台服务");
    }
}
