package es.kiwi.controller;

import es.kiwi.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes({"msg"})//存入session域
public class AnnoController {


    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("name") String username) {
        System.out.println("执行了....");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取到请求体的内容
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行了....");
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{uid}")
    public String testPathVariable(@PathVariable("uid") String id) {
        System.out.println("执行了....");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头的值
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept") String header) {
        System.out.println("执行了....");
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookie) {
        System.out.println("执行了....");
        System.out.println(cookie);
        return "success";
    }

    /*@RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("执行了....");
        System.out.println("testModelAttribute: " + user);
        return "success";
    }


    @ModelAttribute
    public User showUser(String uname) {
        System.out.println("showUser执行了");
        //通过用户查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        System.out.println("showUser: " + user);
        return user;
    }*/

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("a") User user) {
        System.out.println("执行了....");
        System.out.println("testModelAttribute: " + user);
        return "success";
    }

    /**
     * 该方法会先执行,无返回值的使用
     */
    @ModelAttribute
    public void showUser(String uname, Map<String, User> map) {
        System.out.println("showUser执行了");
        //通过用户查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("a", user);
        System.out.println("showUser: " + user);
    }

    /**
     * @SessionAttributes
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttribute(Model model) {
        System.out.println("testSessionAttribute执行了....");
        //底层会存储到request域对象中
        model.addAttribute("msg", "Hello World!");
        return "success";
    }

    /**
     * 获取值
     * @param model
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttribute(ModelMap model) {
        System.out.println("getSessionAttribute执行了....");
        String msg = (String) model.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除session中的值
     * @param status
     * @return
     */
    @RequestMapping("/delSessionAttributes")
    public String getSessionAttribute(SessionStatus status) {
        System.out.println("getSessionAttribute执行了....");
        status.setComplete();
        return "success";
    }
}
