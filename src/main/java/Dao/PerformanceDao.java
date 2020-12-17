package Dao;

import Domain.Performance;
import Util.SqlBuilder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/12/17 22:28:21
 * @description
 */
@Repository
public interface PerformanceDao {

    @SelectProvider(type = SqlBuilder.class,method = "get_performance")
    @Results({
            @Result(property = "employee",column = "e_id",one = @One(select = "Dao.EmployeeDao.findById"))
    })
    List<Performance> get_performance(@Param("start") Integer start, @Param("end") Integer end, @Param("performance") Performance performance);
}
