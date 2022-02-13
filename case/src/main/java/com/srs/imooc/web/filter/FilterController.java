package com.srs.imooc.web.filter;


import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ServletComponentScan
 * 使用@ServletComponentScan注解后，Servlet、Filter、Listener可以直接通过@WebServlet、@WebFilter、@WebListener注解自动注册，无需其他代码。
 * 换一种方式的话，就等于@ComponentScan + @Component
 */
@ServletComponentScan
//@ComponentScan
@RestController
public class FilterController {

    @GetMapping(value = "/moblie/hello")
    public String hello(@RequestParam(value = "name", required = false) String name) {
        return "Hello " + name;
    }

    @GetMapping(value = "/pc/hi")
    public String hi(@RequestParam(value = "name", required = false) String name) {
        return "Hi " + name;
    }
}