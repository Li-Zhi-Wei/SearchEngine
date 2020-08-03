package com.lizhiwei.analyse.tag;

import java.util.ArrayList;
import java.util.List;

/**
 * 结尾标签
 * @Author LiZhiWei
 * @Date 2020/8/3
 */
public enum HtmlTagEndEnum {
    oneTagEnd("/>"),
    tagEnd(">"),
    oneTagEndFuzzy("*/>"),
    tagEndFuzzy("*>");
    private String end;

    HtmlTagEndEnum(String end) {
        this.end = end;
    }

    public String getEnd() {
        return end;
    }

    public static List<String> getEndList() {

        List<String> getList = new ArrayList<>(values().length);

        for (HtmlTagEndEnum tagSection : values()) {
            getList.add(tagSection.getEnd());
        }

        return getList;
    }
}
