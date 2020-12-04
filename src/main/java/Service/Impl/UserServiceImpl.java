package Service.Impl;

import Dao.UserDao;
import Domain.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SiletFlower
 * @date 2020/11/15 22:29:58
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

}
