package es.kiwi.controller;

import es.kiwi.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/springmvc")
public class HttpMethodController {

    /**
     * post 请求：保存
     * @param user
     * @return
     */
    @RequestMapping(value = "/testRestPOST", method = RequestMethod.POST)
    public String testRestfulURLPOST(User user) {
        System.out.println("rest post" + user);
        return "success";
    }

    /**
     * put 请求：更新
     * @param user
     * @param id
     * @return
     */
    @RequestMapping(value = "/testRestPUT/{id}", method = RequestMethod.PUT)
    public String testRestfulURLPUT(@PathVariable("id") Integer id, User user, HttpServletRequest request) {
        System.out.println("rest put " + id + "," + user);
        System.out.println(request.getMethod());
        return "success";
    }

    /**
     * post 请求：删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/testRestDELETE/{id}", method = RequestMethod.DELETE)
    public String testRestfulURLDELETE(@PathVariable("id") Integer id, HttpServletRequest request) {
        System.out.println("rest delete " + id);
        System.out.println(request.getMethod());
        return "success";
    }

    /**
     * post 请求：查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/testRestGET/{id}", method = RequestMethod.GET)
    public String testRestfulURLGET(@PathVariable("id") Integer id, HttpServletRequest request) {
        System.out.println("rest get " + id);
        System.out.println(request.getMethod());
        return "success";
    }
}
