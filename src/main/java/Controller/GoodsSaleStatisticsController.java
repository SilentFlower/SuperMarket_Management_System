package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author SiletFlower
 * @date 2020/12/16 22:42:21
 * @description
 */
@RestController
@RequestMapping("/goodsStatistics")
public class GoodsSaleStatisticsController {

    @RequestMapping("/get_goodsSaleStatistics")
    public ModelAndView get_goodsSaleStatistics(ModelAndView mv){
        mv.setViewName("goods_sale");
        return mv;
    }


}
