package Service;

import Domain.Page;
import Domain.Supplier;
import Domain.SupplierGoods;
import Domain.Supplier_bill;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/11/22 14:34:11
 * @description
 */
public interface SupplierService {
    /**
     * 分页查询供应商，按条件分类查询供应商
     * @param page
     * @param supplier
     * @return
     */
    public Map<String,Object> getSuppliers(Page page,Supplier supplier);

    public Integer getCount();

    /**
     * 新增供应商
     * @param supplier
     * @return
     */
    public Boolean addSupplier(Supplier supplier);

    /**
     * 获取到需要修改的供应商
     * @param s_id
     * @return
     */
    public Supplier getEditSupplier(Integer s_id);

    /**
     * 修改供应商
     * @param supplier
     * @return
     */
    public Boolean editSupplier(Supplier supplier);

    /**
     * 删除供应商
     * @param s_id
     * @return
     */
    public Boolean deleteSupplier(Integer s_id);

    /**
     * 获取供货记录，条件查询，分页查询
     * @param page
     * @param key
     * @param date
     * @return
     */
    public Map<String, Object> getSupplierGoods(Page page, SupplierGoods key,Date date);

    /**
     * 添加供货记录
     * @param supplierGoods
     * @return
     */
    public Boolean add_supplierGoods(SupplierGoods supplierGoods);

    /**
     * 获取所有商品和供货商
     * @return
     */
    public Map<String,Object> getGoodsAndType();

    /**
     * 获取商品的种类
     * @param goods_name
     * @return
     */
    public String getGoodsType(String goods_name);

    /**
     * 根据id获取供货记录
     * @param sg_id
     * @return
     */
    public SupplierGoods getSupplierGoods(Integer sg_id);

    /**
     * 修改供货记录
     * @param supplierGoods
     * @return
     */
    public Boolean edit_supplierGoods(SupplierGoods supplierGoods);

    /**
     * 删除供货记录
     * @param sg_id
     * @return
     */
    public Boolean delete_supplierGoods(Integer sg_id);

    /**
     * 支付未支付的供货记录
     * @param sg_id
     * @return
     */
    public Boolean pay_supplierGoodss(Integer sg_id);

    /**
     * 获取所有供货商账单，包括分页操作，查询操作
     * @param page
     * @param key
     * @return
     */
    public Map<String,Object> get_supplierBill(Page page, Supplier_bill key);

    /**
     * 根据供货商ID获取支付账单
     * @param s_id
     * @return
     */
    public List<SupplierGoods> get_paySupplierBill(Integer s_id);
}
