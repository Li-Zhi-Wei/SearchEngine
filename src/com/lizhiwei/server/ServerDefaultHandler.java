package com.lizhiwei.server;

/**
 * 默认页面处理
 * @Author LiZhiWei
 * @Date 2020/8/7
 */
public class ServerDefaultHandler implements ServerHandler{

    // 重定向报文
    private static final String RESULT = "HTTP/1.1 302 Moved Temporarily\n" + //
            "Location: /index";

    @Override
    public String handler(String req,String path, ServerContext ctx) {
        return RESULT;
    }

}
