package Dao;

import Domain.Goods;
import Domain.SaleGoods;
import Util.SqlBuilder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/11/25 22:11:39
 * @description
 */
@Repository
public interface GoodsDao {

    @Select("select * from goods where is_delete = false limit #{start},#{pageSize}")
    @Results({
            @Result(property = "tg_id",column = "tg_id"),
            @Result(property = "goodsType",column = "tg_id",one = @One(select = "Dao.GoodsTypeDao.getById"))
    })
    List<Goods> getGoods(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    @SelectProvider(type = SqlBuilder.class, method = "goodsKeyword")
    @Results({
            @Result(property = "tg_id", column = "tg_id"),
            @Result(property = "goodsType", column = "tg_id",one = @One(select = "Dao.GoodsTypeDao.getById"))
    })
    List<Goods> goodsSearchByKey(Goods key);


    @Select("select COUNT(g_id) from goods where is_delete = false")
    public Integer getCount();

    @Insert("insert into goods(goods_name,goods_desc,goods_addr,goods_remarks,goods_amount,tg_id)" +
            "values(#{goods_name}, #{goods_desc}, #{goods_addr}, #{goods_remarks}, #{goods_amount}, #{tg_id})")
    public Integer addGoods(Goods goods);


    @Select("select * from goods where goods_name = #{goods_name} and is_delete = false")
    @Results({
            @Result(property = "tg_id",column = "tg_id"),
            @Result(property = "goodsType",column = "tg_id",one = @One(select = "Dao.GoodsTypeDao.getById"))
    })
    public Goods findByName(String goods_name);

    @Select("select g_id from goods where goods_name = #{goods_name} and is_delete = false")
    public Integer findIdByName(String goods_name);

    @Select("select * from goods where g_id = #{g_id} ")
    @Results({
            @Result(property = "tg_id",column = "tg_id"),
            @Result(property = "goodsType",column = "tg_id",one = @One(select = "Dao.GoodsTypeDao.getById"))
    })
    public Goods findById(Integer g_id);


    @Update("update goods set is_delete = true where g_id = #{g_id}")
    public Integer deleteById(Integer g_id);

    @Select("select goods_name from goods where is_delete = false")
    public List<String> findAllName();


    @Update("update goods set goods_name = #{goods_name},goods_desc = #{goods_desc}," +
            "goods_addr = #{goods_addr},goods_remarks = #{goods_remarks}," +
            "goods_amount = #{goods_amount},tg_id = #{tg_id} " +
            "where g_id = #{g_id}")
    public Integer updateGoods(Goods goods);

    @Select("select goods_name from goods where is_delete = false")
    public List<String> getAllName();

    @Select("select * from goods where is_delete = false")
    @Results({
            @Result(property = "tg_id",column = "tg_id"),
            @Result(property = "goodsType",column = "tg_id",one = @One(select = "Dao.GoodsTypeDao.getById"))
    })
    public List<Goods> findAll();

    /**
     * 级联删除
     * @return
     */
    @Update(" update goods set goods_amount = goods_amount + #{goods_amount} where g_id = #{g_id} ")
    Integer update_amount_plus(@Param("g_id") Integer g_id, @Param("goods_amount") Integer goods_amount);

    /**
     * 级联删除
     * @return
     */
    @Update(" update goods set goods_amount = goods_amount - #{goods_amount} where g_id = #{g_id} ")
    Integer update_amount_min(@Param("g_id") Integer g_id, @Param("goods_amount") Integer goods_amount);
}
