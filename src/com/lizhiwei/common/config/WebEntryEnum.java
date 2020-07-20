package com.lizhiwei.common.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 爬虫种子网址
 * @Author LiZhiWei
 * @Date 2020/7/20
 */
public enum WebEntryEnum {
    SOHO("http://www.sohu.com/", "sohu"),

    QQ("https://www.qq.com/", "qq"),

    WY163("https://www.163.com/", "163"),

    SINA("https://www.sina.com.cn/", "sina"),

    CSDN("https://www.csdn.net/", "csdn"),

    CARHOME("https://www.autohome.com.cn", "autohome"),

    ZOL("http://www.zol.com.cn/", "zol"),

    XH("http://www.xinhuanet.com/", "xh"),

    RM("http://www.people.com.cn/", "rm"),

    CCTV("http://www.cctv.com/", "cctv"),

    FENG("https://www.ifeng.com/", "fh"),;

    /** 网站地址信息 */
    private String urlAddress;

    /** 标识信息 */
    private String flag;

    WebEntryEnum(String urlAddress, String flag) {
        this.urlAddress = urlAddress;
        this.flag = flag;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public String getFlag() {
        return flag;
    }

    /**
     * 获取网址集合
     *
     * @return 开始标签信合
     */
    public static List<String> getUrlList() {

        List<String> getList = new ArrayList<>(values().length);

        for (WebEntryEnum tagSection : values()) {
            getList.add(tagSection.getUrlAddress());
        }

        return getList;
    }
}
