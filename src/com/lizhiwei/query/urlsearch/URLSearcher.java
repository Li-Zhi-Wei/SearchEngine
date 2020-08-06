package com.lizhiwei.query.urlsearch;

import com.lizhiwei.query.entity.ResultMapping;
import com.lizhiwei.query.entity.UrlInfo;

import java.util.List;

/**
 * 根据词ID获取URL
 * @Author LiZhiWei
 * @Date 2020/8/5
 */
public interface URLSearcher {

    /**
     * 根据词ID获取URL的ID
     */
    public List<ResultMapping> query(List<Long> ids);

    /**
     * 根据词ID获取URL的ID
     */
    public List<ResultMapping> query(Long[] ids);

    /**
     * 根据词匹配信息获取URL的信息
     */
    public List<UrlInfo> query(ResultMapping m);

}
