package es.kiwi.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor2 implements HandlerInterceptor {

    /**
     * 预处理：controller方法执行前
     *
     * @param request
     * @param response
     * @param handler
     * @return true 放行，执行下一个拦截器，如果没有，执行controller方法
     * false 不放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor 2 执行了...");
        /*request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        return false;*/

        return true;
    }

    /**
     * 后处理的方法， controller方法执行后， success.jsp执行之前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor 2 ...执行后");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);//success.jsp 执行了....
    }

    /**
     * success.jsp页面执行之后，该方法会执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        System.out.println("MyInterceptor 2 ...最后");
        /*不能再跳其他页面了*/
    }

    /*
    *   MyInterceptor1执行了...
        MyInterceptor 2 执行了...
        testInterceptor执行了....
        MyInterceptor 2 ...执行后
        MyInterceptor1...执行后
        success.jsp 执行了....
        MyInterceptor 2 ...最后
        MyInterceptor1...最后
    *
    * */
}
