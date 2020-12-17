package Service;

import Domain.Page;
import Domain.Performance;

import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/12/17 22:27:34
 * @description
 */
public interface PerformanceService {
    Map<String, Object> get_performance(Page page, Performance key);
}
