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

    /**
     * 分页查询供应商，按条件分类查询供应商
     * @param page
     * @param mv
     * @param supplier
     * @return
     */
    @RequestMapping("/getSuppliers")
    public ModelAndView getSuppliers(Page page, ModelAndView mv,String supplier){
        Supplier key = null;
        if(supplier != null && !"".equals(supplier)){
            key = JsonUtil.toSupplier(supplier);
        }
        Map<String, Object> map = supplierService.getSuppliers(page,key);
        Page newPage = (Page) map.get("page");
        Object suppliers = map.get("suppliers");
        mv.addObject("suppliers",JsonUtil.toJsonUtil(suppliers));
        mv.addObject("page",newPage);
        mv.addObject("supplierKeyword",JsonUtil.toJsonUtil(key));
        mv.setViewName("supplierList");
        return mv;
    }

    /**
     * 新增供应商
     * @param supplier
     * @return
     */
    @RequestMapping("addSupplier")
    @ResponseBody
    public boolean addSupplier(Supplier supplier){
        Boolean bool = supplierService.addSupplier(supplier);
        return bool;
    }

    /**
     * 获取到需要修改的供应商
     * @param s_id
     * @return
     */
    @RequestMapping("getEditSupplier")
    @ResponseBody
    public Supplier getEditSupplier(Integer s_id){
        Supplier supplier = supplierService.getEditSupplier(s_id);
        return supplier;
    }

    /**
     * 修改供应商
     * @param supplier
     * @return
     */
    @RequestMapping("editSupplier")
    @ResponseBody
    public boolean editSupplier(Supplier supplier){
        Boolean bool = supplierService.editSupplier(supplier);
        return bool;
    }

    /**
     * 删除供应商
     * @param s_id
     * @return
     */
    @RequestMapping("/deleteSupplier")
    @ResponseBody
    public boolean deleteSupplier(Integer s_id){
        Boolean b = supplierService.deleteSupplier(s_id);
        return b;
    }

    /**
     * 批量删除供货商
     * @param s_ids
     * @return
     */
    @RequestMapping("/deleteSuppliers")
    @ResponseBody
    public boolean deleteSuppliers(Integer[] s_ids){
        for (Integer s_id : s_ids) {
            if(supplierService.deleteSupplier(s_id)){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取供货记录，条件查询，分页查询
     * @param mv
     * @param page
     * @param supplierGoods
     * @param endTime
     * @return
     * @throws ParseException
     */
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
        mv.addObject("supplierGoods",JsonUtil.toJsonUtil(supplierGoodss));
        mv.addObject("page",newPage);
        mv.addObject("supplierGoodsKeyword",JsonUtil.toJsonUtil(key));
        mv.setViewName("supplier_goods");
        return mv;
    }

    /**
     * 新增进货记录
     * @param supplierGoods
     * @param supplier
     * @param goods
     * @return
     */
    @RequestMapping("/add_supplierGoods")
    @ResponseBody
    public boolean add_supplierGoods(SupplierGoods supplierGoods, Supplier supplier, Goods goods) {
        supplierGoods.setSupplier(supplier);
        supplierGoods.setGoods(goods);
        Boolean bool = supplierService.add_supplierGoods(supplierGoods);
        return bool;
    }

    /**
     * 获取所有商品和种类
     * @param mv
     * @return
     */
    @RequestMapping("/get_goodsAndType")
    @ResponseBody
    public Map<String, Object> getGoodsAndType(ModelAndView mv){
        Map<String, Object> map = supplierService.getGoodsAndType();
        return map;
    }

    /**
     * 根据商品名获取商品种类
     * @param goods_name
     * @return
     */
    @RequestMapping(value = "/get_goodsType",produces = {"text/html;charset=UTF-8"})
    @ResponseBody
    public String getGoodsType(String goods_name){
        String name = supplierService.getGoodsType(goods_name);
        return name;
    }

    /**
     * 根据ID获取供货记录
     * @param sg_id
     * @return
     */
    @RequestMapping("get_editSupplierGoods")
    @ResponseBody
    public SupplierGoods getSupplierGoods(Integer sg_id){
        SupplierGoods supplierGoods = supplierService.getSupplierGoods(sg_id);
        return  supplierGoods;
    }

    /**
     * 根据id修改供货记录
     * @param supplierGoods
     * @param goods
     * @param supplier
     * @return
     */
    @RequestMapping("edit_supplierGoods")
    @ResponseBody
    public boolean edit_supplierGoods(SupplierGoods supplierGoods,Goods goods,Supplier supplier){
        supplierGoods.setGoods(goods);
        supplierGoods.setSupplier(supplier);
        Boolean bool = supplierService.edit_supplierGoods(supplierGoods);
        return bool;
    }

    /**
     * 删除供货记录
     * @param sg_id
     * @return
     */
    @RequestMapping("/delete_supplierGoods")
    @ResponseBody
    public boolean delete_supplierGoods(Integer sg_id){
        Boolean bool = supplierService.delete_supplierGoods(sg_id);
        return bool;
    }

    /**
     * 批量删除供货记录
     * @param sg_ids
     * @return
     */
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

    /**
     * 支付未支付的供货记录
     * @param sg_ids
     * @return
     */
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

    /**
     * 获取所有供货商账单，包括分页操作，查询操作
     * @param mv
     * @param page
     * @param supplier_bill
     * @return
     * @throws IOException
     */
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
        mv.addObject("supplier_bill_key",JsonUtil.toJsonUtil(key));
        mv.addObject("page", newPage);
        mv.addObject("supplier_bill", JsonUtil.toJsonUtil(supplier_bills));
        mv.addObject("supplier_names", JsonUtil.toJsonUtil(supplier_names));
        mv.setViewName("supplier_bill");
        return mv;
    }

    /**
     * 根据供货商ID获取支付账单
     * @param s_id
     * @return
     */
    @RequestMapping("/get_paySupplierBill")
    @ResponseBody
    public List<SupplierGoods> get_paySupplierBill(Integer s_id){
        List<SupplierGoods> paySupplierBill = supplierService.get_paySupplierBill(s_id);
        return paySupplierBill;
    }

    /**
     * 根据多个供货商ID 批量获取支付账单
     * @param s_ids
     * @return
     */
    @RequestMapping("/get_paySupplierBills")
    @ResponseBody
    public List<SupplierGoods> get_paySupplierBills(Integer[] s_ids){
        List<SupplierGoods> paySupplierBill = null;
        List<SupplierGoods> pay = null;
        int count = 0;
        for (Integer s_id : s_ids) {
            if(count == 0){
                paySupplierBill = supplierService.get_paySupplierBill(s_id);
                count++;
            }else{
                pay = supplierService.get_paySupplierBill(s_id);
                paySupplierBill.addAll(pay);
            }
        }
        return paySupplierBill;
    }




}
