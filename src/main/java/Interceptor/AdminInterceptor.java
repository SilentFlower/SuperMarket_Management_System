package Interceptor;

import Domain.Employee;
import Service.UserService;
import Util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author SiletFlower
 * @date 2020/12/19 14:38:35
 * @description
 */
public class AdminInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        String token = TokenUtil.getNowToken(cookies);
        Employee employee = userService.getUserInfo(token);
        if(employee.getUser().getAdmin() == null || employee.getUser().getAdmin() == false){
            response.sendRedirect(request.getContextPath()+"/utils/get404");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
