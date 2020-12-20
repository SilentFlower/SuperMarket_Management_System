package Service;

import Domain.Employee;

/**
 * @author SiletFlower
 * @date 2020/11/15 22:29:46
 * @description
 */
public interface UserService {

    Employee getUserInfo(String token);

    Boolean changePasswd(String pre_passwd, String now_passwd,Integer u_id);
}
