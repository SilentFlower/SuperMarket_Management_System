package Service.Impl;

import Dao.EmployeeDao;
import Dao.EmployeeSaleDao;
import Dao.GoodsDao;
import Domain.Employee;
import Domain.Goods;
import Domain.Page;
import Domain.SaleGoods;
import Service.EmployeeSaleService;
import Util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/12/14 20:46:52
 * @description
 */
@Service
public class EmployeeSaleServiceImpl implements EmployeeSaleService{

    @Autowired
    private EmployeeSaleDao employeeSaleDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Map<String, Object> get_employeeSale(SaleGoods key, Page page) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<SaleGoods> saleGoods = null;
        int start = (page.getCurrentPage()-1)*page.getPageSize();
        int end = start + page.getPageSize();
        Page newPage = null;
        List<Goods> all = goodsDao.findAll();
        List<Employee> all2 = employeeDao.findAll();
        if(key == null){
            Integer count = employeeSaleDao.findCount();
            newPage = PageUtil.dealWithPage(page, count);
            saleGoods = employeeSaleDao.findByPage(start, end);
        }else{
            saleGoods = employeeSaleDao.findByKey(key);
            newPage = PageUtil.dealWithPage(page, saleGoods.size());
            if (end >= newPage.getCount()) {
                end = newPage.getCount();
            }
            saleGoods = saleGoods.subList(start, end);
        }
        map.put("employeeSale", saleGoods);
        map.put("newPage", newPage);
        map.put("allGoods", all);
        map.put("allEmployees", all2);
        return map;
    }

    @Override
    public Boolean add_employeeSale(SaleGoods saleGoods) {
        Boolean bool = employeeSaleDao.add_employeeSale(saleGoods);
        return bool;
    }

    @Override
    public Boolean edit_employeeSale(SaleGoods saleGoods) {
        Boolean bool = employeeSaleDao.edit_employeeSale(saleGoods);
        return bool;
    }

    @Override
    public Boolean delete_employeeSale(Integer sale_id) {
        Boolean bool = employeeSaleDao.delete_employeeSale(sale_id);
        return bool;
    }
}
