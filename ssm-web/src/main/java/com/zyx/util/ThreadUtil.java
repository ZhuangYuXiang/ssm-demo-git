package com.zyx.util;

import javax.servlet.http.HttpServletRequest;

/**
 *  线程工具类
 */
public class ThreadUtil {
    /**
     * 本地线程
     */
    public static ThreadLocal<HttpServletRequest> threadLocal = new ThreadLocal<>();

    public static void setRequest(HttpServletRequest request) {
        threadLocal.set(request);
    }

    public static HttpServletRequest getRequest(){
        return threadLocal.get();
    }
}
