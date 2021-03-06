package Dao;

import Domain.SaleGoods;
import Util.SqlBuilder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/12/14 20:47:12
 * @description
 */
@Repository
public interface EmployeeSaleDao {

    @Select("select count(sale_id) from sale_goods")
    Integer findCount();

    @Select("select * from sale_goods limit #{start},#{size}")
    @Results({
            @Result(property ="g_id" ,column ="g_id" ),
            @Result(property ="e_id" ,column ="e_id" ),
            @Result(property ="goods" ,column ="g_id",one = @One(select = "Dao.GoodsDao.findById")),
            @Result(property ="employee" ,column ="e_id",one = @One(select = "Dao.EmployeeDao.findById"))
    })
    List<SaleGoods> findByPage(@Param("start") int start, @Param("size") int size);


    @Insert("insert into sale_goods (g_id,e_id,sale_amount,sale_date,sale_price)" +
            "values(#{g_id}, #{e_id}, #{sale_amount}, #{sale_date}, #{sale_price})")
    Boolean add_employeeSale(SaleGoods saleGoods);

    @UpdateProvider(type = SqlBuilder.class, method = "edit_employeeSale")
    Boolean edit_employeeSale(SaleGoods saleGoods);

    @Delete("delete from sale_goods where sale_id = #{sale_id}")
    Boolean delete_employeeSale(Integer sale_id);

    @SelectProvider(type = SqlBuilder.class,method = "employeeSaleByKey")
    @Results({
            @Result(property ="g_id" ,column ="g_id" ),
            @Result(property ="e_id" ,column ="e_id" ),
            @Result(property ="goods" ,column ="g_id",one = @One(select = "Dao.GoodsDao.findById")),
            @Result(property ="employee" ,column ="e_id",one = @One(select = "Dao.EmployeeDao.findById"))
    })
    List<SaleGoods> findByKey(SaleGoods saleGoods);

    @Select("select * from sale_goods where e_id = #{e_id}")
    @Results({
            @Result(property ="g_id" ,column ="g_id" ),
            @Result(property ="e_id" ,column ="e_id" ),
            @Result(property ="goods" ,column ="g_id",one = @One(select = "Dao.GoodsDao.findById")),
            @Result(property ="employee" ,column ="e_id",one = @One(select = "Dao.EmployeeDao.findById"))
    })
    List<SaleGoods> get_employeeSale_e_id(Integer e_id);

    @Delete("delete from sale_goods where e_id = #{e_id}")
    Integer delete_employeeSale_e_id(Integer e_id);

    @Select("select * from sale_goods where sale_id = #{sale_id}")
    @Results({
            @Result(property ="g_id" ,column ="g_id" ),
            @Result(property ="e_id" ,column ="e_id" ),
            @Result(property ="goods" ,column ="g_id",one = @One(select = "Dao.GoodsDao.findById")),
            @Result(property ="employee" ,column ="e_id",one = @One(select = "Dao.EmployeeDao.findById"))
    })
    SaleGoods getById(Integer sale_id);
}
