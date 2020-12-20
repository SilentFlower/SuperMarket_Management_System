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

    /**
     * 分页操作、条件查询操作，查商品种类
     * @param mv
     * @param page
     * @param goodsType
     * @return
     */
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

    /**
     * 根据tg_id获取商品种类
     * @param tg_id
     * @return
     */
    @RequestMapping("/getGoodsType")
    @ResponseBody
    public GoodsType getGoodsType(Integer tg_id){
        GoodsType editGoodsType = goodsService.getEditGoodsType(tg_id);
        return editGoodsType ;
    }

    /**
     * 修改商品种类信息
     * @param goodsType
     * @return
     */
    @RequestMapping("/editGoodsType")
    @ResponseBody
    public boolean editGoodsType(GoodsType goodsType){
        Boolean bool = goodsService.editGoodsType(goodsType);
        return bool;
    }


    /**
     * 删除商品种类（软删除）
     * @param tg_id
     * @return
     */
    @RequestMapping("/deleteGoodsType")
    @ResponseBody
    public boolean deleteGoodsType(Integer tg_id){
        Boolean bool = goodsService.deleteGoodsType(tg_id);
        return bool;
    }

    /**
     * 批量删除商品种类（软删除）
     * @param tg_ids
     * @return
     */
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


    /**
     * 添加商品种类
     * @param goodsType
     * @return
     */
    @RequestMapping("/addGoodsType")
    @ResponseBody
    public boolean addGoodsType(GoodsType goodsType){
        Boolean bool = goodsService.addGoodsType(goodsType);
        return bool;
    }

    /**
     * 获取所有商品，分页操作，条件查询操作
     * @param mv
     * @param page
     * @param goods
     * @return
     */
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

    /**
     * 获取所有商品种类名
     * @return
     */
    @RequestMapping("/getAllGoodsTypeName")
    @ResponseBody
    public List<String> getAllGoodsTypeName(){
        return goodsService.getAllGoodsTypeName();
    }

    /**
     * 添加商品
     * @param goods
     * @param goodsType
     * @return
     */
    @RequestMapping("/addGoods")
    @ResponseBody
    public boolean addGoods(Goods goods,GoodsType goodsType){
        goods.setGoodsType(goodsType);
        Boolean bool = goodsService.addGoods(goods);
        return bool;
    }

    /**
     * 获得需要修改商品
     * @param g_id
     * @return
     */
    @RequestMapping("/getEditGoods")
    @ResponseBody
    public Goods getEditGoods(Integer g_id){
        return goodsService.getEditGoods(g_id);
    }

    /**
     * 修改商品
     * @param goods
     * @param goodsType
     * @return
     */
    @RequestMapping("/edit_goods")
    @ResponseBody
    public boolean edit_goods(Goods goods,GoodsType goodsType){
        goods.setGoodsType(goodsType);
        Boolean bool = goodsService.edit_goods(goods);
        return bool;
    }

    /**
     * 商品删除（软删除）
     * @param g_id
     * @return
     */
    @RequestMapping("/deleteGoods")
    @ResponseBody
    public boolean deleteGoods(Integer g_id){
        Boolean bool = goodsService.deleteGoods(g_id);
        return bool;
    }

    /**
     * 商品批量删除（软删除）
     * @param g_ids
     * @return
     */
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

    /**
     * 查询库存操作
     * @param mv
     * @param page
     * @param goods_amount
     * @return
     */
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

    /**
     * 获取库存警报列表
     * @param mv
     * @param page
     * @return
     */
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

    /**
     * 添加库存警告
     * @param goods_alarm
     * @return
     */
    @RequestMapping("/add_goods_alarm")
    @ResponseBody
    public boolean add_goods_alarm(@RequestBody Goods_alarm goods_alarm){
        Boolean bool = goodsService.add_goods_alarm(goods_alarm);
        return bool;
    }

    /**
     * 修改库存警报
     * @param map
     * @return
     */
    @RequestMapping("/edit_goods_alarm")
    @ResponseBody
    public boolean edit_goods_alarm(@RequestBody Map<String,Object> map){
        Integer before_g_id = Integer.valueOf((String) map.get("before_g_id")) ;
        Goods_alarm goods_alarm = JsonUtil.toGoods_alarm(map.get("goods_alarm"));
        Boolean bool = goodsService.edit_goods_alarm(goods_alarm,before_g_id);
        return bool;
    }

    /**
     * 删除库存警报
     * @param g_id
     * @return
     */
    @RequestMapping("/delete_goods_alarm")
    @ResponseBody
    public boolean delete_goods_alarm(Integer g_id){
        Boolean bool = goodsService.delete_goods_alarm(g_id);
        return bool;
    }

    /**
     * 批量删除库存警报
     * @param g_ids
     * @return
     */
    @RequestMapping("/delete_goods_alarms")
    @ResponseBody
    public boolean delete_goods_alarms(Integer[] g_ids){
        for (Integer g_id : g_ids) {
            Boolean bool = goodsService.delete_goods_alarm(g_id);
            if(!bool){
                return bool;
            }
        }
        return true;
    }


}
