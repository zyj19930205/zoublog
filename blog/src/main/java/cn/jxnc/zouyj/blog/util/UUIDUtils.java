package cn.jxnc.zouyj.blog.util;

import java.util.UUID;

/**
 * UUID生成工具类
 */
public class UUIDUtils {
    public static String getUUID(){

        return UUID.randomUUID().toString().replace("-", "");
    }
}
