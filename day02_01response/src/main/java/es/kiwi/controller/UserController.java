package es.kiwi.controller;

import es.kiwi.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回字符串
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString方法执行了.....");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("猕猴桃");
        user.setPassword("123");
        user.setAge(21);
        //存入request域
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 返回void
     * 请求转发是 一次请求  不用编写项目的名称
     */
    @RequestMapping("/testVoid")//默认跳转搭到testVoid.jsp
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行了.....");
        //编写请求转发的程序
        /*请求转发*/
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        /*重定向*/
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        /*直接响应*/
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好");

        return;

    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {

        //创建ModelANdView对象
        ModelAndView modelAndView = new ModelAndView();

        System.out.println("testModelAndView方法执行了.....");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("猕猴桃");
        user.setPassword("123");
        user.setAge(21);

        //把user对象存储到mv对象中，也会把user对象存入到request对象
        modelAndView.addObject("user", user);

        //跳转页面
        modelAndView.setViewName("success");

        return modelAndView;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect方法执行了.....");

        //请求的转发
//        return "forward:/WEB-INF/pages/success.jsp";

        //重定向，请求不到WEB-INF目录下,不用加项目名称 contextPath
        return "redirect:/index.jsp";

    }

    /**
     * 模拟异步请求和响应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax方法执行了.....");
        //客户端发送ajax的请求，传的是json字符串，导入jackson依赖后后端把json字符串封装到user对象中
        System.out.println(user);
        //做响应，模拟查询数据库
        user.setUsername("Mango");
        user.setAge(2);
        //做响应
        return user;

    }
}
