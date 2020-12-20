package Dao;

import Domain.Page;
import Domain.Supplier;
import Util.SqlBuilder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/11/22 14:35:08
 * @description
 */
@Repository
public interface SupplierDao {



    @Select("select count(s_id) from supplier")
    public Integer getCount();

    @Select("select * from supplier limit #{start},#{pageSize}")
    public List<Supplier> getByPage(@Param("start") int start, @Param("pageSize") Integer pageSize);

    @Select("select * from supplier where supplier_name = #{supplier_name}")
    public Supplier findByName(String supplier_name);//此处需要改写成id来获取

    @Select("select s_id from supplier where supplier_name = #{supplier_name}")
    public Integer findIdByName(String supplier_name);//此处需要改写成id来获取

    @Select("select * from supplier where s_id = #{s_id}")
    public Supplier findById(Integer s_id);

    @Insert("insert into supplier" +
            "(supplier_name,supplier_desc,supplier_addr,supplier_email,supplier_contact,supplier_bankcard) " +
            "values(#{supplier_name},#{supplier_desc},#{supplier_addr}," +
            "#{supplier_email},#{supplier_contact},#{supplier_bankcard})")
    public void addSupplier(Supplier supplier);

    @Update("update supplier set supplier_desc = #{supplier_desc}, supplier_addr = #{supplier_addr}," +
            "supplier_email = #{supplier_email}, supplier_contact = #{supplier_contact}, supplier_bankcard = #{supplier_bankcard}" +
            " where supplier_name = #{supplier_name}")
    public void editSupplier(Supplier supplier);


    //可能需要联表删除
    @Delete("delete from supplier where s_id = #{s_id}")
    public Integer deleteSupplier(Integer s_id);

    @SelectProvider(type = SqlBuilder.class,method = "supplierKeyword")
    public List<Supplier> searchByKey(Supplier key);

    @Select("select supplier_name from supplier")
    public List<String> findAllName();
}
