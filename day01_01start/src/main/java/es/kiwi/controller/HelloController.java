package es.kiwi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器类
 */
@Controller
@RequestMapping(path = "/user")
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello() {
        System.out.println("Hello SpringMVC");
        return "success";
    }

    @RequestMapping(
            value = "/testRequestMapping",
            method = RequestMethod.GET,
            params = {"username=Ryan"},
            headers = {"Accept"})
    public String testRequestMapping() {
        System.out.println("测试RequestMapping注解");
        return "success";
    }
}
