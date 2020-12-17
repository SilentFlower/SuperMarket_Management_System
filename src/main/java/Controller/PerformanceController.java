package Controller;

import Domain.Page;
import Domain.Performance;
import Domain.Turnover;
import Service.PerformanceService;
import Util.NewJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/12/17 22:22:23
 * @description
 */
@RestController
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @RequestMapping("/get_performance")
    public ModelAndView get_performance(ModelAndView mv, Page page,String performance){
        Performance key = null;
        if (performance != null && !"".equals(performance)) {
            key = NewJsonUtil.toBean(performance, Performance.class);
        }
        Map<String, Object> map = performanceService.get_performance(page, key);
        Object performances = map.get("performance");
        Object allEmployees= map.get("allEmployees");
        Page newPage = (Page) map.get("page");
        mv.addObject("performance", NewJsonUtil.toString(performances));
        mv.addObject("allEmployees", NewJsonUtil.toString(allEmployees));
        mv.addObject("page", newPage);
        mv.addObject("performanceKey", NewJsonUtil.toString(key));
        mv.setViewName("performance");
        return mv;
    }
}
