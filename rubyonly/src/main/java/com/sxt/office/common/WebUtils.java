package com.sxt.office.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author tanghua
 * @Date: 2020/5/25 16:19
 * @Version 1.0
 */
public class WebUtils {


    /**
     * 获取request
     */
    public static HttpServletRequest getRequest() {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = requestAttributes.getRequest();
        return request;

    }

    /**
     *  获取session
     * @return
     */
    public static HttpSession getSession() {

        return getRequest().getSession();
    }
}
