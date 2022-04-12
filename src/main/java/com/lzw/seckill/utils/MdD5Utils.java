package com.lzw.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5工具类
 * @author : lzw
 * @date : 2022/4/11
 * @since : 1.0
 */
public class MdD5Utils {


    /**
     * 与前端的盐值保持一致
     */
    private static final String salt = "1r3kf4j6df4g6hi4";

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    /**
     * 第一次加码
     * 和前端第一次加密方式保持一致
     * @param inputPass
     * @return
     */
    public static String inputPassToFormPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(5) + inputPass + salt.charAt(2) + salt.charAt(7);
        return md5(str);
    }

    /**
     * 第二次加密
     * 从前端得到密文后进行第二次加密，生成的密码存入数据库
     * @param formPass
     * @param salt
     * @return
     */
    public static String formPassToDBPass(String formPass,String salt) {
        String str = salt.charAt(2) + salt.charAt(0) + formPass + salt.charAt(4) + salt.charAt(1);
        return md5(str);
    }

    /**
     * 两次加密
     * @param inputPass
     * @param salt
     * @return
     */
    public static String inputPassToDBPass(String inputPass, String salt) {
        return formPassToDBPass(inputPassToFormPass(inputPass), salt);
    }

    public static void main(String[] args) {
        // b6d75aa845b8366aa7b3d88f09e651a4
        System.out.println(inputPassToFormPass("123456"));
        System.out.println(formPassToDBPass("c8cb50d4531c06acd8efe12dafdeee7c","12k3j45l63j"));
        System.out.println(inputPassToDBPass("123456", "12k3j45l63j"));
    }

}
