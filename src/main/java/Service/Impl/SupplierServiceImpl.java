package Service.Impl;

import Dao.*;
import Domain.*;
import Service.SupplierService;
import Util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/11/22 14:34:22
 * @description
 */
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;
    @Autowired
    private SupplierGoodsDao supplierGoodsDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private SupplierBillDao supplierBillDao;


    @Override
    public Map<String,Object> getSuppliers(Page page,Supplier supplier) {
        Map map = new HashMap<String,Object>();
        List<Supplier> suppliers = null;
        Integer start = (page.getCurrentPage()-1)*page.getPageSize();
        Integer end = start+page.getPageSize();
        Page newPage = null;
        if(supplier == null){
            Integer count = supplierDao.getCount();
            newPage = PageUtil.dealWithPage(page, count);
            suppliers = supplierDao.getByPage(start, newPage.getPageSize());
        }else {
            suppliers = supplierDao.searchByKey(supplier);
            newPage = PageUtil.dealWithPage(page,suppliers.size());
            if(end >= newPage.getCount()){
                end = newPage.getCount();
            }
            suppliers = suppliers.subList(start,end);
        }
        map.put("suppliers",suppliers);
        map.put("page",newPage);
        return map;
    }

    @Override
    public Integer getCount() {
        return supplierDao.getCount();
    }

    @Override
    public Boolean addSupplier(Supplier supplier) {
        Supplier su = supplierDao.findByName(supplier.getSupplier_name());
        if(su != null){
            return false;
        }else{
            supplierDao.addSupplier(supplier);
            return true;
        }
    }

    @Override
    public Supplier getEditSupplier(Integer s_id) {
        return supplierDao.findById(s_id);
    }

    @Override
    public Boolean editSupplier(Supplier supplier) {
        Supplier su = supplierDao.findByName(supplier.getSupplier_name());
        if(supplier.equals(su)){
            return false;
        }else{
            supplierDao.editSupplier(supplier);
            return true;
        }
    }

    /**
     * 删除需要级联 影响supply_goods 和 goods的库存
     * @param s_id
     * @return
     */
    @Override
    public Boolean deleteSupplier(Integer s_id) {
        Integer integer = supplierDao.deleteSupplier(s_id);
        //根据ID查询所有的进货表
        List<SupplierGoods> supplierGoods = supplierGoodsDao.findBy_s_id(s_id);
        //删除表supplierGoods内容
        supplierGoodsDao.delete_supplierGoods_s_id(s_id);
        //更新goods库存
        for (SupplierGoods supplierGood : supplierGoods) {
            Integer integer1 = goodsDao.update_amount_min(supplierGood.getG_id(), supplierGood.getSg_amount());
        }
        if(integer > 0){
            return true;
        }
        return false;
    }


    @Override
    public Map<String, Object> getSupplierGoods(Page page, SupplierGoods key, Date date) {
        Map map = new HashMap<String,Object>();
        List<SupplierGoods> supplierGoods = null;
        Integer start = (page.getCurrentPage()-1)*page.getPageSize();
        Integer end = start+page.getPageSize();
        Page newPage = null;
        if(key == null){
            Integer count = supplierGoodsDao.getCount();
            newPage = PageUtil.dealWithPage(page, count);
            supplierGoods = supplierGoodsDao.getByPage(start, newPage.getPageSize());
        }else {
            supplierGoods = supplierGoodsDao.getByKeyWord(key, date);
            newPage = PageUtil.dealWithPage(page,supplierGoods.size());
            if(end >= newPage.getCount()){
                end = newPage.getCount();
            }
            supplierGoods = supplierGoods.subList(start,end);
        }
        map.put("supplierGoods",supplierGoods);
        map.put("page",newPage);
        return map;
    }

    /**
     * 级联更新goods
     * @param supplierGoods
     * @return
     */
    @Override
    public Boolean add_supplierGoods(SupplierGoods supplierGoods) {
        Integer g_id = goodsDao.findIdByName(supplierGoods.getGoods().getGoods_name());
        Integer s_id = supplierDao.findIdByName(supplierGoods.getSupplier().getSupplier_name());
        supplierGoods.setG_id(g_id);
        supplierGoods.setS_id(s_id);
        Integer integer = supplierGoodsDao.add_supplierGoods(supplierGoods);
        if(integer > 0){
            //增加库存
            goodsDao.update_amount_plus(supplierGoods.getG_id(), supplierGoods.getSg_amount());
            return true;
        }
        return false;
    }


    @Override
    public Map<String, Object> getGoodsAndType() {
        Map map = new HashMap<String,Object>();
        List<String> suppliers = supplierDao.findAllName();
        List<String> goods = goodsDao.findAllName();
        map.put("suppliers",suppliers);
        map.put("goods", goods);
        return map;
    }

    @Override
    public String getGoodsType(String goods_name) {
        Goods goods = goodsDao.findByName(goods_name);
        if(goods == null){
            return null;
        }
        return goods.getGoodsType().getTg_name();
    }

    @Override
    public SupplierGoods getSupplierGoods(Integer sg_id) {
        return supplierGoodsDao.findById(sg_id);
    }

    @Override
    public Boolean edit_supplierGoods(SupplierGoods supplierGoods) {
        boolean bool = false;
        SupplierGoods before = supplierGoodsDao.findById(supplierGoods.getSg_id());
        if(!before.getGoods().getGoods_name().equals(supplierGoods.getGoods().getGoods_name())){
            Integer idByName = goodsDao.findIdByName(supplierGoods.getGoods().getGoods_name());
            supplierGoods.setG_id(idByName);
            bool = true;
        }else{
            supplierGoods.setG_id(before.getG_id());
        }

        if(!before.getSupplier().getSupplier_name().equals(supplierGoods.getSupplier().getSupplier_name())){
            Integer idByName = supplierDao.findIdByName(supplierGoods.getSupplier().getSupplier_name());
            supplierGoods.setS_id(idByName);
            bool = true;
        }else{
            supplierGoods.setS_id(before.getS_id());
        }

        if(     !before.getSg_amount().equals(supplierGoods.getSg_amount()) ||
                !before.getSg_price().equals(supplierGoods.getSg_price()) ||
                !before.getSg_date_string().equals(supplierGoods.getSg_date_string())    ){
            bool = true;
        }

        if(bool){
            Integer integer = supplierGoodsDao.update_supplierGoods(supplierGoods);
            if(integer > 0){
                //级联更新  根据g_id变化和数量变化
                if(!before.getG_id().equals(supplierGoods.getG_id()) || !before.getSg_amount().equals(supplierGoods.getSg_amount())){
                    goodsDao.update_amount_min(before.getG_id(), before.getSg_amount());
                    goodsDao.update_amount_plus(supplierGoods.getG_id(), supplierGoods.getSg_amount());
                }
                return true;
            }
        }

        return false;
    }


    /**
     * 级联删除
     * @param sg_id
     * @return
     */
    @Override
    public Boolean delete_supplierGoods(Integer sg_id) {
        Integer integer = supplierGoodsDao.delete_supplierGoods(sg_id);
        SupplierGoods delete = supplierGoodsDao.getById(sg_id);
        if(integer > 0){
            goodsDao.update_amount_min(delete.getG_id(), delete.getSg_amount());
            return true;
        }
        return false;
    }

    @Override
    public Boolean pay_supplierGoodss(Integer sg_id) {
        Integer integer = supplierGoodsDao.pay_supplierGoodss(sg_id);
        if(integer > 0){
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> get_supplierBill(Page page, Supplier_bill key) {
        Map map = new HashMap<String,Object>();
        List<Supplier_bill> supplier_bills = null;
        Integer start = (page.getCurrentPage()-1)*page.getPageSize();
        Integer end = start+page.getPageSize();
        Page newPage = null;
        if (key == null){
            Integer count = supplierBillDao.getCount();
            newPage = PageUtil.dealWithPage(page, count);
            supplier_bills= supplierBillDao.getByPage(start, page.getPageSize());
        }else{
            supplier_bills = supplierBillDao.getByKey(key);
            newPage = PageUtil.dealWithPage(page,supplier_bills.size());
            if(end >= newPage.getCount()){
                end = newPage.getCount();
            }
            supplier_bills = supplier_bills.subList(start,end);
            if(supplier_bills != null){
                for (Supplier_bill supplier_bill : supplier_bills) {
                    supplier_bill.setSb_start(key.getSb_start());
                    supplier_bill.setSb_end(key.getSb_end());
                }
            }
        }
        List<String> supplier_names = supplierDao.findAllName();
        map.put("supplier_bills", supplier_bills);
        map.put("supplier_names", supplier_names);
        map.put("page", newPage);
        return map;
    }


    @Override
    public List<SupplierGoods> get_paySupplierBill(Integer s_id) {
        List<SupplierGoods> supplier_goods = supplierGoodsDao.getUnpaidBy_s_id(s_id);
        return supplier_goods;
    }
}
