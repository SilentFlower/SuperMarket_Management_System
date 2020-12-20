package Dao;

import Domain.Goods;
import Domain.GoodsType;
import Util.SqlBuilder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/11/24 09:53:32
 * @description
 */
@Repository
public interface GoodsTypeDao {


    @Select("select COUNT(tg_id) from type_goods where is_delete = false")
    public Integer getCount();

    @Select("select * from type_goods where is_delete = false limit #{start}, #{pageSize}")
    public List<GoodsType> getGoodTypes(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    @Select("select * from type_goods where tg_id = #{tg_id}")
    public GoodsType getById(Integer tg_id);

    @Insert("insert into type_goods(tg_name,tg_count) values(#{tg_name},#{tg_count})")
    public Integer addGoodsType(GoodsType goodsType);

    @Update("update  type_goods set is_delete = true where tg_id = #{tg_id}")
    public Integer deleteGoodsType(Integer tg_id);

    @Update("update type_goods set tg_name = #{tg_name}, tg_count = #{tg_count} where tg_id = #{tg_id}")
    public Integer editGoodsType(GoodsType goodsType);

    @Select("select * from type_goods where tg_name = #{tg_name} where is_delete = false")
    public GoodsType getByName(String tg_name);

    @Select("select tg_id from type_goods where tg_name = #{tg_name} where is_delete = false")
    public Integer getIdByName(String tg_name);

    @SelectProvider(type = SqlBuilder.class, method = "goodsTypeKeyword")
    public List<GoodsType> searchByKeyword(GoodsType goodsType);

    @Select("select tg_name from type_goods where is_delete = false")
    public List<String> getAllName();

    @Update("update type_goods set tg_count = tg_count+1 where tg_id = #{tg_id}")
    public Integer updateCountById(Integer tg_id);

    @Update("update type_goods set tg_count = tg_count-1 where tg_id = #{tg_id}")
    public Integer minusCountById(Integer tg_id);

}
