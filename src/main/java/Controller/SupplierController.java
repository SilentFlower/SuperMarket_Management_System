package Controller;

import Dao.GoodsTypeDao;
import Domain.*;
import Service.SupplierService;
import Util.DateUtil;
import Util.JsonUtil;
import Util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/11/22 14:33:27
 * @description
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/getSuppliers")
    public ModelAndView getSuppliers(Page page, ModelAndView mv,String supplier){
        Supplier key = null;
        if(supplier != null && !"".equals(supplier)){
            key = JsonUtil.toSupplier(supplier);
        }
        Map<String, Object> map = supplierService.getSuppliers(page,key);
        Page newPage = (Page) map.get("page");
        Object suppliers = map.get("suppliers");
        String suppliersString = JsonUtil.toJsonUtil(suppliers);
        String keyString = JsonUtil.toJsonUtil(key);
        mv.addObject("suppliers",suppliersString);
        mv.addObject("page",newPage);
        mv.addObject("supplierKeyword",keyString);
        mv.setViewName("supplierList");
        return mv;
    }

    @RequestMapping("addSupplier")
    @ResponseBody
    public boolean addSupplier(Supplier supplier){
        Boolean bool = supplierService.addSupplier(supplier);
        return bool;
    }

    @RequestMapping("getEditSupplier")
    @ResponseBody
    public Supplier getEditSupplier(String supplier_name){
        Supplier supplier = supplierService.getEditSupplier(supplier_name);
        return supplier;
    }

    @RequestMapping("editSupplier")
    @ResponseBody
    public boolean editSupplier(Supplier supplier){
        Boolean bool = supplierService.editSupplier(supplier);
        return bool;
    }

    @RequestMapping("/deleteSupplier")
    @ResponseBody
    public boolean deleteSupplier(String supplier_name){
        System.out.println(supplier_name);
        supplierService.deleteSupplier(supplier_name);
        return true;
    }

    @RequestMapping("/deleteSuppliers")
    @ResponseBody
    public boolean deleteSuppliers(String[] supplier_names){
        for (String supplier_name : supplier_names) {
            if(supplierService.deleteSupplier(supplier_name)){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    @RequestMapping("/supplierGoods")
    public ModelAndView supplierGoods(ModelAndView mv,Page page,String supplierGoods,String endTime) throws ParseException {
        SupplierGoods key = null;
        Date end_date = null;
        if(supplierGoods != null && !"".equals(supplierGoods)){
            key = JsonUtil.toSupplierGoods(supplierGoods);
        }
        if(endTime != null && !"".equals(endTime) && !"null".equals(endTime)){
            mv.addObject("endTime", endTime);
            end_date = DateUtil.getDate(endTime);
        }else{
            mv.addObject("endTime", "null");
        }
        Map<String, Object> map = supplierService.getSupplierGoods(page,key,end_date);
        Object supplierGoodss = map.get("supplierGoods");
        Page newPage = (Page) map.get("page");
        String supplierGoodsString = JsonUtil.toJsonUtil(supplierGoodss);
        String keyString = JsonUtil.toJsonUtil(key);
        mv.addObject("supplierGoods",supplierGoodsString);
        mv.addObject("page",newPage);
        mv.addObject("supplierGoodsKeyword",keyString);
        mv.setViewName("supplier_goods");
        return mv;
    }

    @RequestMapping("/add_supplierGoods")
    @ResponseBody
    public boolean add_supplierGoods(SupplierGoods supplierGoods, Supplier supplier, Goods goods) {
        supplierGoods.setSupplier(supplier);
        supplierGoods.setGoods(goods);
        Boolean bool = supplierService.add_supplierGoods(supplierGoods);
        return bool;
    }

    @RequestMapping("/get_goodsAndType")
    @ResponseBody
    public Map<String, Object> getGoodsAndType(ModelAndView mv){
        Map<String, Object> map = supplierService.getGoodsAndType();
        return map;
    }

    @RequestMapping(value = "/get_goodsType",produces = {"text/html;charset=UTF-8"})
    @ResponseBody
    public String getGoodsType(String goods_name){
        String name = supplierService.getGoodsType(goods_name);
        return name;
    }

    @RequestMapping("get_editSupplierGoods")
    @ResponseBody
    public SupplierGoods getSupplierGoods(Integer sg_id){
        SupplierGoods supplierGoods = supplierService.getSupplierGoods(sg_id);
        return  supplierGoods;
    }

    @RequestMapping("edit_supplierGoods")
    @ResponseBody
    public boolean edit_supplierGoods(SupplierGoods supplierGoods,Goods goods,Supplier supplier){
        supplierGoods.setGoods(goods);
        supplierGoods.setSupplier(supplier);
        Boolean bool = supplierService.edit_supplierGoods(supplierGoods);
        return bool;
    }

    @RequestMapping("/delete_supplierGoods")
    @ResponseBody
    public boolean delete_supplierGoods(Integer sg_id){
        Boolean bool = supplierService.delete_supplierGoods(sg_id);
        return bool;
    }

    @RequestMapping("/delete_supplierGoodss")
    @ResponseBody
    public boolean delete_supplierGoodss(Integer[] sg_ids){
        for (Integer sg_id : sg_ids) {
            Boolean delete = supplierService.delete_supplierGoods(sg_id);
            if(delete == false){
                return false;
            }else{
                continue;
            }
        }
        return true;
    }

    @RequestMapping("/pay_supplierGoods")
    @ResponseBody
    public boolean pay_supplierGoodss(Integer[] sg_ids){
        for (Integer sg_id : sg_ids) {
            Boolean delete = supplierService.pay_supplierGoodss(sg_id);
            if(delete == false){
                return false;
            }else{
                continue;
            }
        }
        return true;
    }

    @RequestMapping("/get_supplierBill")
    @ResponseBody
    public ModelAndView get_supplierBill(ModelAndView mv,Page page,String supplier_bill) throws IOException {
        Supplier_bill key = null;
        if(supplier_bill != null && !"".equals(supplier_bill)){
            key = JsonUtil.toSupplier_bill(supplier_bill);
        }
        Map<String, Object> map = supplierService.get_supplierBill(page, key);
        Object supplier_bills = map.get("supplier_bills");
        Page newPage = (Page)map.get("page");
        Object supplier_names = map.get("supplier_names");
        String supplier_names_string = JsonUtil.toJsonUtil(supplier_names);
        String supplier_bill_string = JsonUtil.toJsonUtil(supplier_bills);
        String key_string = JsonUtil.toJsonUtil(key);
        mv.addObject("supplier_bill_key",key_string);
        mv.addObject("page", newPage);
        mv.addObject("supplier_bill", supplier_bill_string);
        mv.addObject("supplier_names", supplier_names_string);
        mv.setViewName("supplier_bill");
        return mv;
    }




}
