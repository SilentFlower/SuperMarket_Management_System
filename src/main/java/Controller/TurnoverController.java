package Controller;

import Domain.Page;
import Domain.Turnover;
import Service.TurnoverService;
import Util.NewJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/12/16 22:42:21
 * @description
 */
@RestController
@RequestMapping("/turnover")
public class TurnoverController {

    @Autowired
    private TurnoverService turnoverService;

    @RequestMapping("/get_Turnover")
    public ModelAndView get_Turnover(ModelAndView mv, Page page,String turnover){
        Turnover key = null;
        if (turnover != null && !"".equals(turnover)) {
            key = NewJsonUtil.toBean(turnover, Turnover.class);
        }
        Map<String, Object> map = turnoverService.get_Turnover(page, key);
        Object turnovers = map.get("turnover");
        Object allGoods = map.get("allGoods");
        Page newPage = (Page) map.get("page");
        mv.addObject("turnover", NewJsonUtil.toString(turnovers));
        mv.addObject("allGoods", NewJsonUtil.toString(allGoods));
        mv.addObject("page", newPage);
        mv.addObject("turnoverKey", NewJsonUtil.toString(key));
        mv.setViewName("turnover");
        return mv;
    }


}
