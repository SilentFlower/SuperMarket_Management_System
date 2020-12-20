package Dao;

import Domain.Supplier;
import Domain.SupplierGoods;
import Util.SqlBuilder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/11/27 22:41:07
 * @description
 */
@Repository
public interface SupplierGoodsDao {

    @Select("select COUNT(sg_id) from supply_goods")
    public Integer getCount();

    @Select("select * from supply_goods limit #{start},#{pageSize}")
    @Results({
            @Result(property = "g_id", column = "g_id"),
            @Result(property = "s_id", column = "s_id"),
            @Result(property = "goods", column = "g_id",one = @One(select = "Dao.GoodsDao.findById")),
            @Result(property = "supplier",column = "s_id",one = @One(select = "Dao.SupplierDao.findById"))
    })
    public List<SupplierGoods> getByPage(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    @Insert("insert into supply_goods(g_id,s_id,sg_amount,sg_price,sg_date) " +
            "values(#{g_id}, #{s_id}, #{sg_amount}, #{sg_price}, #{sg_date})")
    public Integer add_supplierGoods(SupplierGoods supplierGoods);


    @Select("select * from supply_goods where sg_id = #{sg_id}")
    @Results({
            @Result(property = "g_id", column = "g_id"),
            @Result(property = "s_id", column = "s_id"),
            @Result(property = "goods", column = "g_id",one = @One(select = "Dao.GoodsDao.findById")),
            @Result(property = "supplier",column = "s_id",one = @One(select = "Dao.SupplierDao.findById"))
    })
    public SupplierGoods findById(Integer sg_id);

    @Update("update supply_goods set g_id = #{g_id},s_id = #{s_id}," +
            "sg_amount = #{sg_amount},sg_price = #{sg_price},sg_date = #{sg_date}" +
            " where sg_id = #{sg_id}")
    public Integer update_supplierGoods(SupplierGoods supplierGoods);

    @Delete("delete from supply_goods where sg_id = #{sg_id}")
    public Integer delete_supplierGoods(Integer sg_id);

    @SelectProvider(type = SqlBuilder.class,method = "supplierGoodsKeyword")
    @Results({
            @Result(property = "g_id",column = "g_id"),
            @Result(property = "s_id",column = "s_id"),
            @Result(property = "goods",column = "g_id", one = @One(select = "Dao.GoodsDao.findById")),
            @Result(property = "supplier",column = "s_id", one = @One(select = "Dao.SupplierDao.findById"))
    })
    List<SupplierGoods> getByKeyWord(@Param("key") SupplierGoods key,@Param("date") Date date);


    @Update("update supply_goods set sg_paid = true where sg_id = #{sg_id}")
    public Integer pay_supplierGoodss(Integer sg_id);

    @Select("select * from supply_goods where s_id = #{s_id} and sg_paid = false")
    @Results({
            @Result(property = "g_id",column = "g_id"),
            @Result(property = "s_id",column = "s_id"),
            @Result(property = "goods",column = "g_id", one = @One(select = "Dao.GoodsDao.findById")),
            @Result(property = "supplier",column = "s_id", one = @One(select = "Dao.SupplierDao.findById"))
    })
    public List<SupplierGoods> getUnpaidBy_s_id(Integer s_id);

    @Select("select * from supply_goods where s_id = #{s_id}")
    @Results({
            @Result(property = "g_id",column = "g_id"),
            @Result(property = "s_id",column = "s_id"),
            @Result(property = "goods",column = "g_id", one = @One(select = "Dao.GoodsDao.findById")),
            @Result(property = "supplier",column = "s_id", one = @One(select = "Dao.SupplierDao.findById"))
    })
    public List<SupplierGoods> findBy_s_id(Integer s_id);

    @Delete("delete from supply_goods where s_id = #{s_id} ")
    Integer delete_supplierGoods_s_id(Integer s_id);

    @Select("select * from where sg_id = #{sg_id}")
    @Results({
            @Result(property = "g_id",column = "g_id"),
            @Result(property = "s_id",column = "s_id"),
            @Result(property = "goods",column = "g_id", one = @One(select = "Dao.GoodsDao.findById")),
            @Result(property = "supplier",column = "s_id", one = @One(select = "Dao.SupplierDao.findById"))
    })
    SupplierGoods getById(Integer sg_id);
}
