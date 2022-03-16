package com.srs.imooc.web.filter;


import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ServletComponentScan
 * 使用@ServletComponentScan注解后，Servlet、Filter、Listener可以直接通过@WebServlet、@WebFilter、@WebListener注解自动注册，无需其他代码。
 * 换一种方式的话，就等于@ComponentScan + @Component
 *
 * 看OneFilter注解
 */
//@ServletComponentScan
//@ComponentScan
@RestController
public class FilterController {

    @GetMapping(value = "/moblie/hello")
    public String hello(@RequestParam(value = "name", required = false) String name) {
        return "Hello " + name;
    }

    @GetMapping(value = "/pc/hi")
    public String hi(@RequestParam(value = "name", required = false) String name, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("srs","srs");
        return "Hi " + name;
    }
}
