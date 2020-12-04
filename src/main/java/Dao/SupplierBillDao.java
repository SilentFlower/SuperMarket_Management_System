package Dao;

import Domain.Page;
import Domain.Supplier_bill;
import Util.SqlBuilder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/12/2 22:26:49
 * @description
 */
@Repository
public interface SupplierBillDao {

    @Select("select COUNT(DISTINCT(s_id)) from supply_goods")
    public Integer getCount();

    @Select("  select a.s_id, " +
            "  SUM(sg_amount)'sb_all_amount', " +
            "  SUM(IF(sg_paid=1,sg_amount,0)) as sb_paid_amount, " +
            "  SUM(IF(sg_paid=0,sg_amount,0)) as sb_unPaid_amount " +
            "  from supply_goods a " +
            "  left join supplier b on a.s_id = b.s_id " +
            "  GROUP BY a.s_id " +
            "  LIMIT #{start},#{pageSize}")
    @Results({
            @Result(property = "supplier", column = "s_id",one = @One(select = "Dao.SupplierDao.findById"))
    })
    public List<Supplier_bill> getByPage(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    @SelectProvider(type = SqlBuilder.class,method = "supplier_bill_keyword")
    @Results({
            @Result(property = "supplier", column = "s_id",one = @One(select = "Dao.SupplierDao.findById"))
    })
    public List<Supplier_bill> getByKey(Supplier_bill supplier_bill);
}
