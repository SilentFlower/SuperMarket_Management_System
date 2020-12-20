package Service;

import Domain.User;

/**
 * @author SiletFlower
 * @date 2020/12/18 23:10:38
 * @description
 */
public interface LoginService {
    User loginRemember(User user);

    User login(User user);

}
