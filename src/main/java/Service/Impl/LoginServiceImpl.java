package Service.Impl;

import Dao.UserDao;
import Domain.User;
import Service.LoginService;
import Util.MD5Util;
import Util.NewJsonUtil;
import Util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

/**
 * @author SiletFlower
 * @date 2020/12/18 23:10:49
 * @description
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;

    @Override
    public User loginRemember(User user) {
        User veriy = null;
        if(user != null){
            veriy = userDao.findByName(user.getUser_name());
            if(veriy != null && MD5Util.MD5(user.getPassword()).equals(veriy.getPassword())){
                String get_token = TokenUtil.createToken(veriy);
                veriy.setToken(get_token);
                return veriy;
            }
        }
        return null;
    }

    @Override
    public User login(User user) {
        User veriy = userDao.findByName(user.getUser_name());
        if(veriy != null){
            if(MD5Util.MD5(user.getPassword()).equals(veriy.getPassword())){
                return veriy;
            }
        }
        return null;
    }
}
