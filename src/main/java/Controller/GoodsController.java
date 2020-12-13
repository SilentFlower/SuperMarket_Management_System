package Controller;

import Domain.Goods;
import Domain.Goods_alarm;
import Domain.Page;
import Domain.GoodsType;
import Service.GoodsService;
import Util.JsonUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/11/24 09:50:20
 * @description
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/goodsType")
    public ModelAndView goodsType(ModelAndView mv, Page page, String goodsType){
        GoodsType key = null;
        if(goodsType != null && !"".equals(goodsType)){
            key = JsonUtil.toGoodsType(goodsType);
        }
        Map<String, Object> map = goodsService.getGoodType(page,key);
        Object goodsTypes = map.get("goodsType");
        Page newPage = (Page) map.get("page");
        String goodsTypesString = JsonUtil.toJsonUtil(goodsTypes);
        String keyString = JsonUtil.toJsonUtil(key);
        mv.addObject("goodsType",goodsTypesString);
        mv.addObject("page",newPage);
        mv.addObject("goodsTypeKeyword",keyString);
        mv.setViewName("goodsTypeList");
        return mv;
    }

    @RequestMapping("/getGoodsType")
    @ResponseBody
    public GoodsType getGoodsType(Integer tg_id){
        GoodsType editGoodsType = goodsService.getEditGoodsType(tg_id);
        return editGoodsType ;
    }

    @RequestMapping("/editGoodsType")
    @ResponseBody
    public boolean editGoodsType(GoodsType goodsType){
        Boolean bool = goodsService.editGoodsType(goodsType);
        return bool;
    }


    @RequestMapping("/deleteGoodsType")
    @ResponseBody
    public boolean deleteGoodsType(Integer tg_id){
        Boolean bool = goodsService.deleteGoodsType(tg_id);
        return bool;
    }

    @RequestMapping("/deleteGoodsTypes")
    @ResponseBody
    public boolean deleteGoodsType(Integer[] tg_ids){
        for (Integer tg_id : tg_ids) {
            if(goodsService.deleteGoodsType(tg_id)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }


    @RequestMapping("/addGoodsType")
    @ResponseBody
    public boolean addGoodsType(GoodsType goodsType){
        Boolean bool = goodsService.addGoodsType(goodsType);
        return bool;
    }

    @RequestMapping("/getGoods")
    public ModelAndView getGoods(ModelAndView mv,Page page,String goods){
        Goods key = null;
        if(goods != null && !"".equals(goods)){
            key = JsonUtil.toGoods(goods);
        }
        Map<String, Object> map = goodsService.getGoods(page,key);
        Object goodss = map.get("goods");
        Page newPage = (Page) map.get("page");
        mv.addObject("goods",JsonUtil.toJsonUtil(goodss));
        mv.addObject("page",newPage);
        mv.addObject("goodsKeyword",JsonUtil.toJsonUtil(key));
        mv.setViewName("goodsList");
        return mv;
    }

    @RequestMapping("/getAllGoodsTypeName")
    @ResponseBody
    public List<String> getAllGoodsTypeName(){
        return goodsService.getAllGoodsTypeName();
    }

    @RequestMapping("/addGoods")
    @ResponseBody
    public boolean addGoods(Goods goods,GoodsType goodsType){
        goods.setGoodsType(goodsType);
        Boolean bool = goodsService.addGoods(goods);
        return bool;
    }

    @RequestMapping("/getEditGoods")
    @ResponseBody
    public Goods getEditGoods(Integer g_id){
        return goodsService.getEditGoods(g_id);
    }

    @RequestMapping("/edit_goods")
    @ResponseBody
    public boolean edit_goods(Goods goods,GoodsType goodsType){
        goods.setGoodsType(goodsType);
        Boolean bool = goodsService.edit_goods(goods);
        return bool;
    }

    @RequestMapping("/deleteGoods")
    @ResponseBody
    public boolean deleteGoods(Integer g_id){
        Boolean bool = goodsService.deleteGoods(g_id);
        return bool;
    }

    @RequestMapping("/deleteGoodss")
    @ResponseBody
    public boolean deleteGoodss(Integer[] g_ids){
        for (Integer g_id : g_ids) {
            Boolean delete = goodsService.deleteGoods(g_id);
            if(delete == true){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    @RequestMapping("/get_goods_amount")
    @ResponseBody
    public ModelAndView get_goods_amount(ModelAndView mv,Page page,String goods_amount){
        Goods key = null;
        if(goods_amount != null && !"".equals(goods_amount)){
            key = JsonUtil.toGoods(goods_amount);
        }
        Map<String, Object> map = goodsService.getGoods(page, key);
        List<String> allGoodsName = goodsService.getAllGoodsName();
        List<String> allGoodsTypeName = goodsService.getAllGoodsTypeName();
        Object goodss = map.get("goods");
        Page newPage = (Page) map.get("page");
        mv.addObject("goods",JsonUtil.toJsonUtil(goodss));
        mv.addObject("page",newPage);
        mv.addObject("goods_amount_key",JsonUtil.toJsonUtil(key));
        mv.addObject("goods_names",JsonUtil.toJsonUtil(allGoodsName));
        mv.addObject("goods_type_names",JsonUtil.toJsonUtil(allGoodsTypeName));
        mv.setViewName("goods_amount_search");
        return mv;
    }

    @RequestMapping("/get_goods_alarm")
    @ResponseBody
    public ModelAndView get_goods_alarm(ModelAndView mv,Page page){
        mv.setViewName("goods_alarm");
        Map<String, Object> map = goodsService.get_goods_alarm(page);
        Object goods_alarm = map.get("goods_alarm");
        Page newPage = (Page) map.get("page");
        Object allGoods = map.get("allGoods");
        mv.addObject("goods_alarm",JsonUtil.toJsonUtil(goods_alarm));
        mv.addObject("allGoods", JsonUtil.toJsonUtil(allGoods));
        mv.addObject("page", newPage);
        return mv;
    }

    @RequestMapping("/add_goods_alarm")
    @ResponseBody
    public boolean add_goods_alarm(@RequestBody Goods_alarm goods_alarm){
        Boolean bool = goodsService.add_goods_alarm(goods_alarm);
        return bool;
    }

    @RequestMapping("/edit_goods_alarm")
    @ResponseBody
    public boolean edit_goods_alarm(@RequestBody Map<String,Object> map){
//        Boolean bool = goodsService.edit_goods_alarm();
        return true;
    }



}
