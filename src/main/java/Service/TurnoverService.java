package Service;

import Domain.Page;
import Domain.Turnover;

import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/12/17 20:37:56
 * @description
 */
public interface TurnoverService {

    Map<String,Object> get_Turnover(Page page, Turnover key);
}
