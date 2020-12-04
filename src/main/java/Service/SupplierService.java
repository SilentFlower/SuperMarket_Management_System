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
    public Map<String,Object> getSuppliers(Page page,Supplier supplier);

    public Integer getCount();

    public Boolean addSupplier(Supplier supplier);

    public Supplier getEditSupplier(String supplier_name);

    public Boolean editSupplier(Supplier supplier);

    public Boolean deleteSupplier(String supplier_name);

    public Map<String, Object> getSupplierGoods(Page page, SupplierGoods key,Date date);

    public Boolean add_supplierGoods(SupplierGoods supplierGoods);

    public Map<String,Object> getGoodsAndType();

    public String getGoodsType(String goods_name);

    public SupplierGoods getSupplierGoods(Integer sg_id);

    public Boolean edit_supplierGoods(SupplierGoods supplierGoods);

    public Boolean delete_supplierGoods(Integer sg_id);

    public Boolean pay_supplierGoodss(Integer sg_id);

    public Map<String,Object> get_supplierBill(Page page, Supplier_bill key);

    public List<SupplierGoods> get_paySupplierBill(Integer s_id);
}
