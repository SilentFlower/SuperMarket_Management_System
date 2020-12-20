package Service.Impl;

import Dao.EmployeeDao;
import Dao.UserDao;
import Domain.Employee;
import Domain.User;
import Service.UserService;
import Util.MD5Util;
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
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee getUserInfo(String token) {
        String[] split = token.split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(split[1]);
        HashMap map = NewJsonUtil.toBean(decode, HashMap.class);
        Integer u_id = (Integer) map.get("u_id");
        Employee employee = employeeDao.findByUid(u_id);
        return employee;
    }

    @Override
    public Boolean changePasswd(String pre_passwd, String now_passwd,Integer u_id) {
        User user = userDao.findById(u_id);
        String passwd = MD5Util.MD5(pre_passwd);
        if (user.getPassword().equals(passwd)) {
            Boolean b = userDao.updatePasswd(MD5Util.MD5(now_passwd), user.getU_id());
            return b;
        }
        return false;
    }
}
