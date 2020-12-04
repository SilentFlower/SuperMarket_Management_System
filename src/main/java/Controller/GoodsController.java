package Controller;

import Domain.Goods;
import Domain.Page;
import Domain.GoodsType;
import Service.GoodsService;
import Util.JsonUtil;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        String goodsTypesString = JsonUtil.toJsonUtil(goodss);
        String keyString = JsonUtil.toJsonUtil(key);
        mv.addObject("goods",goodsTypesString);
        mv.addObject("page",newPage);
        mv.addObject("goodsKeyword",keyString);
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



}
