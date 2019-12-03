package com.zyx.web.interceptor;

import com.zyx.util.ThreadUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestInterceptor implements HandlerInterceptor {
    private static final String LOGIN_URL = "/index.html";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
        //把请求对象与当前线程绑定在一起
        ThreadUtil.setRequest(request);
        System.out.print("*--------------------进入拦截器--------------------*");
        HttpSession session = request.getSession();
        // 从session 里面获取用户名的信息
        Object obj = session.getAttribute("session");
        System.err.println("-----------------------------------------进入拦截器---------------------------");
        System.err.println("-----------------------------------------sessionid---------------------------"+session.getId());
        // 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆
        if (obj == null || "".equals(obj.toString())) {
            response.sendRedirect(LOGIN_URL);
            System.err.print("------------------------session内没有值-----------------------------");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }
}
