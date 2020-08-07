package com.lizhiwei.server;

import com.lizhiwei.common.config.GlobelConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author LiZhiWei
 * @Date 2020/8/7
 */
public class ServerIndexHandler implements ServerHandler{

    /**
     * 首页URL
     */
    private final String indexPath = "/index";

    /**
     * 页面内容
     */
    private String content = "index";

    /**
     * 默认响应头 200
     */
    private static final String DEFAULT_HEADER = "HTTP/1.1 200 OK\n" + //
            "Server: Test\n" + //
            "Content-Type: text/html;charset=utf-8\n\n";

    public ServerIndexHandler(String filePath) {
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)), GlobelConfig.DEFAULT_HTML_CHARSET);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String handler(String req, String path, ServerContext ctx) {
        if (path.equalsIgnoreCase(indexPath)) {
            return DEFAULT_HEADER + content;// TODO
        }
        return null;
    }

}
