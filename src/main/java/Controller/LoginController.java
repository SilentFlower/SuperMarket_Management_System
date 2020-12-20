package Controller;

import Domain.User;
import Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author SiletFlower
 * @date 2020/12/18 23:08:11
 * @description
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public boolean login(User user, HttpServletRequest request, HttpServletResponse response){
        User veriy = null;
        if(user.getRemember()){
            veriy = loginService.loginRemember(user);
            if (veriy != null){
                Cookie cookie = new Cookie("token",veriy.getToken());
                cookie.setPath("/");
                cookie.setMaxAge(60*60*24);
                response.addCookie(cookie);
                return true;
            }
        }else{
            veriy = loginService.login(user);
            if(veriy != null){
                return true;
            }
        }
        return false;
    }

}
