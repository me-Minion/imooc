package com.srs.imooc.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * urlPatterns 作用范围
 * /* 表示对所有路径都生效
 *
 * 先执行配置形式的
 * 再执行注解形式的
 * 如果过滤器名称相同，会被覆盖
 * 所以，项目开发时，尽量保证使用同一种方式（配置或注解）
 *
 * initParams 参数配置化
 *
 * urlPatterns
 * 设置过滤范围：
 * 1、精准匹配 /index.jsp
 * 2、模糊匹配 /servlet/* 以前缀进行模糊匹配
 *           *.jsp 以后缀进行模糊匹配
 * /* 所有地址
 *
 * /指映射Web应用根路径，且只对Servlet生效
 *
 * 可以定义多个
 * urlPatterns = {"/filter/hi/*", "*.jsp"}
 *
 * --------------------------------------------
 *
 * 过滤链
 *
 * 多个过滤器时，一层层的进入1234，再一层层的返回4321
 *
 * filter-mapping的书写顺序决定了过滤器的执行顺序
 *
 *
 * filterChain.doFilter();如果不写，过滤链就会中断
 *
 *
 * 使用注解时，过滤器的顺序是按照名称排序的，升序，不区分大小写
 *
 */
//@Component
@WebFilter(filterName = "OneFilter",urlPatterns = "/filter/hi/*",
        initParams = {@WebInitParam(name = "encoding", value = "GBK")})
public class OneFilter implements Filter {

    private String  encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("OneFilter init");
        encoding = filterConfig.getInitParameter("encoding");
        System.out.println(encoding);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("OneFilter 过滤器已生效");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        httpServletRequest.setCharacterEncoding(encoding);


        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setContentType("text/html;charset=" + encoding);

        //过滤链
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("OneFilter destroy");
    }
}
