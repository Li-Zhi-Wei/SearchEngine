package com.lizhiwei.main;

/**
 * @Author LiZhiWei
 * @Date 2020/8/8
 */
public class ServerMain {
    public static void main(String[] args) {
        com.lizhiwei.server.ServerMain.init(8080);
        com.lizhiwei.server.ServerMain.start();
    }
}
