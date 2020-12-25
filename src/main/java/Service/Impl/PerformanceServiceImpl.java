package Service.Impl;

import Dao.EmployeeDao;
import Dao.PerformanceDao;
import Domain.*;
import Service.PerformanceService;
import Util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/12/17 22:27:48
 * @description
 */
@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceDao performanceDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Map<String, Object> get_performance(Page page, Performance key) {
        Map map = new HashMap();
        int start = (page.getCurrentPage() - 1) * page.getPageSize();
        int end = start + page.getPageSize();
        List<Performance> performance = performanceDao.get_performance(start, page.getPageSize(), key);
        Integer count = performanceDao.getCount();
        List<Employee> allEmployees = employeeDao.findAll();
        Page newPage = PageUtil.dealWithPage(page, count);
        map.put("performance", performance);
        map.put("allEmployees", allEmployees);
        map.put("page", newPage);
        return map;
    }
}
