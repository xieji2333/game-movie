package com.atxieji.interceptors;

import com.atxieji.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lmhstart
 * @create 2021/10/31-23:59
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    /*
    阻止用户通过在浏览器中直接输入 /index 来访问首页
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session= request.getSession();
        User user = (User) session.getAttribute("userLogin");
        if (user != null) {
            //放行
            return true;
        }

        request.setAttribute("msg","Please login!");
        request.getRequestDispatcher("/login").forward(request,response);
        //拦截
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
