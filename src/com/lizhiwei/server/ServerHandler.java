package com.lizhiwei.server;

/**
 * 服务器处理操作
 * @Author LiZhiWei
 * @Date 2020/8/6
 */
public interface ServerHandler {

    /**
     * 处理操作 返回内容为报文<br>
     * 返回null代表未处理
     */
    public String handler(String req,String path, ServerContext ctx);

}
