package com.srs.imooc.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 地址跳转
 */
@WebFilter(filterName = "DeviceAdapterFilter", urlPatterns = {"/hi/*","/hello/*"})
public class DeviceAdapterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //hello跳moblie
        //hi跳pc
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        if (uri.startsWith("pc") || uri.startsWith("moblie") ) {
            filterChain.doFilter(request, response);
        }

        String newUri = "";
        if (uri.indexOf("hello") != -1) {
            newUri = "moblie" + uri;
        } else {
            newUri = "pc" + uri;
        }
        res.sendRedirect(newUri);

    }

    @Override
    public void destroy() {

    }
}
