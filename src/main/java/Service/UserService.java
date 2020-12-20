package Service;

import Domain.User;

/**
 * @author SiletFlower
 * @date 2020/11/15 22:29:46
 * @description
 */
public interface UserService {

    User getUserInfo(String token);
}
