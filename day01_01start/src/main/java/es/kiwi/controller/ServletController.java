package es.kiwi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/servlet")
public class ServletController {

    /**
     * Servlet原生API
     * @return
     */
    @RequestMapping("/api")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行了....");
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);
        return "success";
    }
}
