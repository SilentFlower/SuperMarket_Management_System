package Service;

import Domain.Page;
import Domain.SaleGoods;

import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/12/14 20:46:24
 * @description
 */
public interface EmployeeSaleService {
    Map<String,Object> get_employeeSale(SaleGoods key, Page page);

    Boolean add_employeeSale(SaleGoods saleGoods);

    Boolean edit_employeeSale(SaleGoods saleGoods);

    Boolean delete_employeeSale(Integer sale_id);
}
