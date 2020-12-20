package Controller;

import Dao.UserDao;
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

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo(String token) {
        User user = userService.getUserInfo(token);
        return NewJsonUtil.toString(user);
    }



}
