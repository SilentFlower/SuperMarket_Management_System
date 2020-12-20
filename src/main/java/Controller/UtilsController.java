package Controller;

import Dao.EmployeeDao;
import Dao.UserDao;
import Domain.Employee;
import Domain.User;
import Service.UserService;
import Util.NewJsonUtil;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author SiletFlower
 * @date 2020/11/17 15:08:00
 * @description
 */
@Controller
@RequestMapping("/utils")
public class UtilsController {

    @Autowired
    private UserService userService;



    @RequestMapping("/goHome")
    public String goHome(){
        return "index";
    }

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        return "login";
    }

    @RequestMapping(value = "/getUserInfo",produces = {"text/html;charset=UTF-8"})
    @ResponseBody
    public String getUserInfo(String token) {
        Employee employee = userService.getUserInfo(token);
        return NewJsonUtil.toString(employee);
    }

    @RequestMapping("/get404")
    public String get404(){
        return "404";
    }

    @RequestMapping("/changePasswd")
    @ResponseBody
    public boolean veriyPasswd(String pre_passwd,String now_passwd,Integer u_id,HttpServletResponse response,HttpServletRequest request){
        Boolean b = userService.changePasswd(pre_passwd, now_passwd, u_id);
        if(b){
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("token")){
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    break;
                }
            }
            return true;
        }else {
            return false;
        }
    }



}
