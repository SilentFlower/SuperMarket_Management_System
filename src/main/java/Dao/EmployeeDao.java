package Dao;

import Domain.Employee;
import Domain.User;
import Util.SqlBuilder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/11/15 09:21:37
 * @description
 */
@Repository
public interface EmployeeDao {

    @Select("select * from employee limit #{start},#{pageSize}")
    @Results({
            @Result(property = "user",column = "u_id",javaType = User.class,one = @One(select = "Dao.UserDao.findById")),
            @Result(property = "u_id",column = "u_id")
    })
    public List<Employee> getByPage(@Param("start") int start,@Param("pageSize") int pageSize);

    @Select("select COUNT(e_id) from employee")
    public Integer getCount();

    @Select("select * from employee where employee_email = #{employee_email}")
    @Results({
            @Result(property = "u_id",column = "u_id"),
            @Result(property = "user",column = "u_id",javaType = User.class,one = @One(select = "Dao.UserDao.findById"))
    })
    public Employee findByEmail(String email);

    @Insert("insert into employee(employee_name,employee_sex,employee_addr,employee_tel,employee_email,u_id) " +
            "values(#{employee_name},#{employee_sex},#{employee_addr},#{employee_tel},#{employee_email},#{u_id})")
    public Integer addEmployee(Employee employee);

    @Select("select * from employee where e_id = #{e_id}")
    @Results({
            @Result(property = "u_id",column = "u_id"),
            @Result(property = "user",column = "u_id",javaType = User.class,one = @One(select = "Dao.UserDao.findById"))
    })
    public Employee findById(Integer e_id);

    @Select("select * from employee where u_id = #{u_id}")
    @Results({
            @Result(property = "u_id",column = "u_id"),
            @Result(property = "user",column = "u_id",javaType = User.class,one = @One(select = "Dao.UserDao.findById"))
    })
    public Employee findByUid(Integer u_id);

    @Update("update employee set employee_name = #{employee_name}, employee_sex = #{employee_sex}, " +
            "employee_addr = #{employee_addr}, employee_tel = #{employee_tel}, employee_email = #{employee_email}" +
            "where e_id = #{e_id}")
    public Integer updateEmployee(Employee employee);

    @Delete("delete from employee where e_id = #{e_id}")

    public Integer deleteById(Integer e_id);



    @SelectProvider(type = SqlBuilder.class, method = "bulidSqlByKeyword")
    @Results({
            @Result(property = "u_id", column = "u_id"),
            @Result(property = "user.u_id", column = "u_id"),
            @Result(property = "user.password", column = "password"),
            @Result(property = "user.admin", column = "admin")
    })
    public List<Employee> searchByKey(Employee employee);

    @Select("select * from employee")
    @Results({
            @Result(property = "u_id",column = "u_id"),
            @Result(property = "user",column = "u_id",javaType = User.class,one = @One(select = "Dao.UserDao.findById"))
    })
    public List<Employee> findAll();
}
