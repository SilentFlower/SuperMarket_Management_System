package Controller;

import Domain.Page;
import Domain.SaleGoods;
import Service.EmployeeSaleService;
import Util.JsonUtil;
import Util.NewJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/12/14 20:45:11
 * @description
 */
@Controller
@RequestMapping("/sale")
public class EmployeeSaleController {

    @Autowired
    private EmployeeSaleService employeeSaleService;

    @RequestMapping("/get_employeeSale")
    public ModelAndView get_employeeSale(ModelAndView mv,String saleGoods,Page page){
        SaleGoods key = null;
        if(saleGoods != null && !"".equals(saleGoods)){
            key = NewJsonUtil.toBean(saleGoods, SaleGoods.class);
        }
        Map<String, Object> map = employeeSaleService.get_employeeSale(key, page);
        Object employeeSale = map.get("employeeSale");
        Page newPage = (Page) map.get("newPage");
        Object allGoods = map.get("allGoods");
        Object employees = map.get("allEmployees");
        mv.addObject("employeeSale", NewJsonUtil.toString(employeeSale));
        mv.addObject("Searchkey", NewJsonUtil.toString(key));
        mv.addObject("allGoods", NewJsonUtil.toString(allGoods));
        mv.addObject("Page", page);
        mv.addObject("allEmployees", NewJsonUtil.toString(employees));
        mv.setViewName("employee_sale");
        return mv;
    }

    @RequestMapping("/add_employeeSale")
    @ResponseBody
    public boolean add_employeeSale(@RequestBody SaleGoods saleGoods){
        Boolean bool = employeeSaleService.add_employeeSale(saleGoods);
        return bool;
    }

    @PostMapping("/edit_employeeSale")
    @ResponseBody
    public boolean edit_employeeSale(@RequestBody SaleGoods saleGoods){
        Boolean bool = employeeSaleService.edit_employeeSale(saleGoods);
        return bool;
    }

    @PostMapping("/delete_employeeSale")
    @ResponseBody
    public boolean delete_employeeSale(Integer sale_id){
        Boolean bool = employeeSaleService.delete_employeeSale(sale_id);
        return bool;
    }

    @PostMapping("/delete_employeeSales")
    @ResponseBody
    public boolean delete_employeeSales(Integer[] sale_ids){
        for (Integer sale_id : sale_ids) {
            Boolean bool = employeeSaleService.delete_employeeSale(sale_id);
            if(!bool){
                return false;
            }
        }
        return true;
    }

}
