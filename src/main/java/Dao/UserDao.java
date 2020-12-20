package Dao;

import Domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author SiletFlower
 * @date 2020/11/15 22:30:45
 * @description
 */
@Repository
public interface UserDao {

    @Insert("insert into user (user_name,password,admin) values(#{user_name},#{password},#{admin})")
    public Integer addNewUser(User user);

    @Select("select u_id from user where user_name = #{name}")
    public Integer findIdByName(String name);

    @Select("select * from user where user_name = #{name}")
    public User findByName(String name);

    @Select("select * from user where u_id = #{id}")
    public User findById(Integer id);

    @Update("update user set password = #{password}, admin = #{admin} where user_name = #{user_name}")
    public Integer updateUser(User user);

    @Delete("delete from user where u_id = #{u_id}")
    public Integer deleteById(Integer u_id);

    @Update("update user set admin = #{admin} where user_name = #{user_name}")
    Integer updateAdmin(User user);
}
