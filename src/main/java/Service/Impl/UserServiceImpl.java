package Service.Impl;

import Dao.UserDao;
import Domain.User;
import Service.UserService;
import Util.NewJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/11/15 22:29:58
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserInfo(String token) {
        String[] split = token.split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(split[1]);
        HashMap map = NewJsonUtil.toBean(decode, HashMap.class);
        Integer u_id = (Integer) map.get("u_id");
        User user = userDao.findById(u_id);
        return user;
    }
}
