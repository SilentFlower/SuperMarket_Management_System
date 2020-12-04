package Dao;

import Domain.Goods;
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

    @Select("select * from goods limit #{start},#{pageSize}")
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


    @Select("select COUNT(g_id) from goods")
    public Integer getCount();

    @Insert("insert into goods(goods_name,goods_desc,goods_addr,goods_remarks,goods_amount,tg_id)" +
            "values(#{goods_name}, #{goods_desc}, #{goods_addr}, #{goods_remarks}, #{goods_amount}, #{tg_id})")
    public Integer addGoods(Goods goods);


    @Select("select * from goods where goods_name = #{goods_name}")
    @Results({
            @Result(property = "tg_id",column = "tg_id"),
            @Result(property = "goodsType",column = "tg_id",one = @One(select = "Dao.GoodsTypeDao.getById"))
    })
    public Goods findByName(String goods_name);

    @Select("select g_id from goods where goods_name = #{goods_name}")
    public Integer findIdByName(String goods_name);

    @Select("select * from goods where g_id = #{g_id}")
    @Results({
            @Result(property = "tg_id",column = "tg_id"),
            @Result(property = "goodsType",column = "tg_id",one = @One(select = "Dao.GoodsTypeDao.getById"))
    })
    public Goods findById(Integer g_id);


    @Delete("delete from goods where g_id = #{g_id}")
    public Integer deleteById(Integer g_id);

    @Select("select goods_name from goods")
    public List<String> findAllName();


    @Update("update goods set goods_name = #{goods_name},goods_desc = #{goods_desc}," +
            "goods_addr = #{goods_addr},goods_remarks = #{goods_remarks}," +
            "goods_amount = #{goods_amount},tg_id = #{tg_id} " +
            "where g_id = #{g_id}")
    public Integer updateGoods(Goods goods);
}
