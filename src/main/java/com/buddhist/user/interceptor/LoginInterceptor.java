package com.buddhist.user.interceptor;

import com.buddhist.user.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * 登录认证拦截器
 * */
public class LoginInterceptor implements HandlerInterceptor
{
    /**
     * Handler执行之前调用这个方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        //获取请求的URL
        String url = request.getRequestURI();

        String passUrl = "/index;/jumpLogin;/checkUser;/registered;/checkPhone;/saveUser";
        String[] passUrls = passUrl.split(";");

        for (String tempUrl : passUrls)
        {
            if (url.contains(tempUrl))
            {
                return true;
            }
        }

        //获取Session
        HttpSession session = request.getSession();
        User existUser = (User) session.getAttribute("existUser");

        if (existUser != null)
        {
            return true;
        }
        //不符合条件的，跳转到登录界面
        request.getRequestDispatcher("/user/jumpLogin").forward(request, response);

        return false;
    }

    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {

    }

    /**
     * Handler执行完成之后调用这个方法
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {

    }
}
