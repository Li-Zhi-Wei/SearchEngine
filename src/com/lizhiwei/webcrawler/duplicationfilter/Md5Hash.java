package com.lizhiwei.webcrawler.duplicationfilter;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author LiZhiWei
 * @Date 2020/7/30
 */
public class Md5Hash implements BloomHash{

    private String salt="";

    public Md5Hash() {
    }
    public Md5Hash(String salt) {
        this.salt = salt;
    }

    @Override
    public int hash(String s) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(s.getBytes());
            return new BigInteger(1, md.digest()).toString(16).hashCode() & Integer.MAX_VALUE;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
