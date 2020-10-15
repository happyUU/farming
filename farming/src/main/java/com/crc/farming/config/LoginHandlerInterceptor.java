package com.crc.farming.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginHandlerInterceptor implements HandlerInterceptor {
    /**
     * 登录验证, 如果session没有初始化, 或者 user 没有存值, 说明用户没有登录, 无法访问后续路径
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("user") == null) {
            request.setAttribute("message", "没有权限访问, 请先登录!");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }
        else {
            return true;
        }
    }
}
