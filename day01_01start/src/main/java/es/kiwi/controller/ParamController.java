package es.kiwi.controller;

import es.kiwi.model.Account;
import es.kiwi.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 请求参数绑定入门
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("testParam")
    public String testParam(String username, String password) {
        System.out.println("执行了....");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return "success";
    }

    /**
     * 请求参数绑定把数据封装到JavaBean的类中
     * @param account
     * @return
     */
    @RequestMapping(value = "saveAccount", method = RequestMethod.POST)
    public String saveAccount(Account account) {
        System.out.println("执行了....");
        System.out.println("Account: " + account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public String saveUser(User user) {
        System.out.println("执行了....");
        System.out.println("user: " + user);
        return "success";
    }
}
