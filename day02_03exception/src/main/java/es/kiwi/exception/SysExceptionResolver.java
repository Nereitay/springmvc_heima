package es.kiwi.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器对象
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常业务逻辑
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        //获取到异常对象
        SysException e = null;
        if (ex instanceof SysException) {
           e = (SysException) ex;
        } else {
            e = new SysException("系统正在维护...");
        }
        //创建ModelAndView
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
