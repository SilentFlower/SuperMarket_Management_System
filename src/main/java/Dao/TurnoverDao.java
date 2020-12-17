package Dao;

import Domain.Page;
import Domain.Turnover;
import Util.SqlBuilder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/12/17 20:38:54
 * @description
 */
@Repository
public interface TurnoverDao {

    @SelectProvider(type = SqlBuilder.class,method = "get_Turnover")
    @Results({
            @Result(property = "goods",column = "g_id",one = @One(select = "Dao.GoodsDao.findById"))
    })
    List<Turnover> get_Turnover(@Param("start") Integer start,@Param("end") Integer end,@Param("turnover") Turnover turnover);

}
