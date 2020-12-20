package Util;

import Domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author SiletFlower
 * @date 2020/11/20 10:12:22
 * @description
 */
public class SqlBuilder {

    public String bulidSqlByKeyword(Employee employee){
        int count = 0;
        StringBuilder builder = new StringBuilder("select * from employee a");
        if(employee.getUser()!=null){
            builder.append(" left join user b on a.u_id = b.u_id  where user_name like CONCAT('%',#{user.user_name},'%') ");
            count++;
        }else{
            builder.append(" where ");
        }
        if(employee.getEmployee_name() != null){
            if(count > 0){
                builder.append(" and ");
            }
            builder.append(" employee_name like CONCAT('%',#{employee_name},'%') ");
            count++;
        }
        if(employee.getEmployee_addr() != null){
            if(count > 0){
                builder.append(" and ");
            }
            builder.append(" employee_addr like CONCAT('%',#{employee_addr},'%') ");
            count++;
        }
        if(employee.getEmployee_tel() != null){
            if(count > 0){
                builder.append(" and ");
            }
            builder.append(" employee_tel like CONCAT('%',#{employee_tel},'%') ");
            count++;
        }
        if(employee.getEmployee_email() != null ){
            if(count > 0){
                builder.append(" and ");
            }
            builder.append(" employee_email like CONCAT('%',#{employee_email},'%') ");
            count++;
        }

        String s = builder.toString();
        return s;
    }

    public String supplierKeyword(Supplier supplier){
        int count = 0;
        StringBuilder sql = new StringBuilder("select * from supplier where");
        if(supplier.getSupplier_name() != null){
            sql.append(" supplier_name like CONCAT('%',#{supplier_name},'%') ");
            count++;
        }
        if(supplier.getSupplier_addr() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" supplier_addr like CONCAT('%',#{supplier_addr},'%') ");
            count++;
        }
        if(supplier.getSupplier_bankcard() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" supplier_bankcard like CONCAT('%',#{supplier_bankcard},'%') ");
            count++;
        }
        if(supplier.getSupplier_contact() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" supplier_contact like CONCAT('%',#{supplier_contact},'%') ");
        }
        if(supplier.getSupplier_desc() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" supplier_desc like CONCAT('%',#{supplier_desc},'%') ");
        }
        if(supplier.getSupplier_email() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" supplier_email like CONCAT('%',#{supplier_email},'%') ");
        }

        return sql.toString();
    }

    public String goodsTypeKeyword(GoodsType goodsType){
        int count = 0;
        StringBuilder sql = new StringBuilder("select * from type_goods where is_delete = false and ");
        if(goodsType.getTg_id() != null){
            sql.append(" tg_id like CONCAT('%',#{tg_id},'%') ");
            count++;
        }
        if(goodsType.getTg_name() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" tg_name like CONCAT('%',#{tg_name},'%') ");
            count++;
        }
        if(goodsType.getTg_count() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" tg_count like CONCAT('%',#{tg_count},'%') ");
            count++;
        }

        return sql.toString();

    }

    public String goodsKeyword(Goods goods){
        int count = 0;
        StringBuilder sql = new StringBuilder("select * from goods a");
        if(goods.getGoodsType() != null){
            sql.append(" left join type_goods b on a.tg_id = b.tg_id where " +
                    " a.is_delete = false and tg_name like CONCAT('%',#{goodsType.tg_name},'%') ");
            count++;
        }
        if(count <= 0){
            sql.append(" where ");
        }
        if(goods.getGoods_addr() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" goods_addr like CONCAT('%',#{goods_addr},'%') ");
            count++;
        }
        if(goods.getGoods_amount() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" goods_amount <= #{goods_amount} ");
            count++;
        }
        if(goods.getGoods_desc() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" goods_desc like CONCAT('%',#{goods_desc},'%') ");
            count++;
        }
        if(goods.getGoods_remarks() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" goods_remarks like CONCAT('%',#{goods_remarks},'%') ");
            count++;
        }
        if(goods.getGoods_name() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" goods_name like CONCAT('%',#{goods_name},'%') ");
            count++;
        }

        return sql.toString();
    }

    public String supplierGoodsKeyword(@Param("key")SupplierGoods key, @Param("date")Date date){
        int count = 0;
        StringBuilder sql = new StringBuilder("select * from supply_goods a");
        if(key.getGoods().getGoods_name() != null || key.getGoods().getGoodsType() != null){
            sql.append(" left join goods b on a.g_id = b.g_id");
        }
        if(key.getSupplier().getSupplier_name() != null){
            sql.append(" left join supplier c on c.s_id = a.s_id ");
        }
        if(key.getGoods().getGoodsType()!= null){
            sql.append(" left join type_goods d on d.tg_id = b.tg_id ");
        }

        sql.append(" where ");

        if(key.getGoods().getGoodsType()!= null){
            sql.append(" tg_name like CONCAT('%',#{key.goods.goodsType.tg_name},'%') ");
            count++;
        }
        if(key.getSupplier().getSupplier_name() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" supplier_name like CONCAT('%',#{key.supplier.supplier_name},'%')");
            count++;
        }
        if(key.getGoods().getGoods_name() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" goods_name like CONCAT('%',#{key.goods.goods_name},'%')");
            count++;
        }
        if(key.getSg_price() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" sg_price <= #{key.sg_price} ");
            count++;
        }
        if(key.getSg_amount() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" sg_amount <= #{key.sg_amount} ");
            count++;
        }
        if(key.getSg_paid() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" sg_paid = #{key.sg_paid} ");
            count++;
        }
        if(key.getSg_date() != null){
            if(count > 0){
                sql.append(" and ");
            }
            if(date != null){
                sql.append(" sg_date between #{key.sg_date} and #{date} ");
            }else{
                sql.append(" sg_date >= #{key.sg_date_string} ");
            }
            count++;
        }else if(date != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" sg_date <= #{date} ");
        }

        return sql.toString();
    }

    public String supplier_bill_keyword(Supplier_bill supplier_bill) {
        int count = 0;
        StringBuilder sql = new StringBuilder("  select a.s_id,sg_date,supplier_name, " +
                                            "  SUM(sg_amount)'sb_all_amount', " +
                                            "  SUM(IF(sg_paid=1,sg_amount,0)) as sb_paid_amount, " +
                                            "  SUM(IF(sg_paid=0,sg_amount,0)) as sb_unPaid_amount " +
                                            "  from supply_goods a " +
                                            "  left join supplier b on a.s_id = b.s_id " +
                                            "  GROUP BY a.s_id having ");
        if(supplier_bill.getSb_all_amount() != null){
            count++;
            sql.append(" sb_all_amount <= #{sb_all_amount} ");
        }
        if(supplier_bill.getSb_paid_amount() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" sb_paid_amount <= #{sb_paid_amount} ");
            count++;
        }
        if(supplier_bill.getSb_unPaid_amount() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" sb_unPaid_amount <= #{sb_unPaid_amount} ");
            count++;
        }
        if(supplier_bill.getSupplier() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" supplier_name = #{supplier.supplier_name} ");
            count++;
        }
        if(supplier_bill.getSb_start() != null && supplier_bill.getSb_end()!= null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" sg_date between #{sb_start} and #{sb_end} ");
        }else if(supplier_bill.getSb_start() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" sg_date >= #{sb_start} ");
        }else if(supplier_bill.getSb_end() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" sg_date <= #{sb_end} ");
        }

        return sql.toString();
    }

    public String edit_employeeSale(SaleGoods saleGoods){
        int count = 0;
        StringBuilder sql = new StringBuilder(" update sale_goods set");
        if(saleGoods.getG_id() != null && !"".equals(saleGoods.getG_id())){
            sql.append(" g_id = #{g_id} ");
            count++;
        }
        if(saleGoods.getE_id() != null && !"".equals(saleGoods.getE_id())){
            if(count > 0){
                sql.append(" , ");
            }
            sql.append(" e_id = #{e_id} ");
            count++;
        }
        if(saleGoods.getSale_amount() != null && !"".equals(saleGoods.getSale_amount())){
            if(count > 0){
                sql.append(" , ");
            }
            sql.append(" sale_amount = #{sale_amount} ");
            count++;
        }
        if(saleGoods.getSale_price() != null && !"".equals(saleGoods.getSale_price())){
            if(count > 0){
                sql.append(" , ");
            }
            sql.append(" sale_price = #{sale_price} ");
            count++;
        }
        if(saleGoods.getSale_date() != null && !"".equals(saleGoods.getSale_date())){
            if(count > 0){
                sql.append(" , ");
            }
            sql.append(" sale_date = #{sale_date} ");
            count++;
        }
        sql.append(" where sale_id = #{sale_id} ");
        return sql.toString();
    }

    public String employeeSaleByKey(SaleGoods saleGoods){
        int count = 0;
        StringBuilder sql = new StringBuilder(" select * from sale_goods a ");
        if(saleGoods.getEmployee().getEmployee_name() != null){
            sql.append(" left join employee b on a.e_id = b.e_id ");
        }

        if(saleGoods.getGoods().getGoods_name() != null || saleGoods.getGoods().getGoodsType() != null){
            sql.append(" left join goods c on a.g_id = c.g_id ");
        }

        if(saleGoods.getGoods().getGoodsType()!= null){
            sql.append(" left join type_goods d on d.tg_id = c.tg_id ");
        }

        sql.append(" where ");
        if(saleGoods.getSale_price() != null){
            sql.append(" sale_price <= #{sale_price} ");
            count++;
        }
        if(saleGoods.getSale_amount() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" sale_amount <= #{sale_amount} ");
            count++;
        }
        if(saleGoods.getStartSearchTime() != null){
            if(count > 0){
                sql.append(" and ");
            }
            if(saleGoods.getEndSearchTime() != null){
                sql.append(" sale_date between #{startSearchTime} and #{endSearchTime} ");
            }else{
                sql.append(" sale_date >= #{startSearchTime} ");
            }
            count++;
        }else if(saleGoods.getEndSearchTime() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" sale_date <= #{endSearchTime} ");
            count++;
        }
        if(saleGoods.getEmployee().getEmployee_name() != null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" b.employee_name like CONCAT('%',#{employee.employee_name},'%') ");
            count++;
        }
        if(saleGoods.getGoods().getGoods_name() != null){
            if(saleGoods.getGoods().getGoods_name() != null){
                if(count > 0){
                    sql.append(" and ");
                }
                sql.append(" goods_name like CONCAT('%',#{goods.goods_name},'%') ");
            }
            count++;
        }
        if(saleGoods.getGoods() != null && saleGoods.getGoods().getGoodsType()!= null){
            if(count > 0){
                sql.append(" and ");
            }
            sql.append(" tg_name like CONCAT('%',#{goods.goodsType.tg_name},'%')");
        }
        return sql.toString();
    }

    public String get_Turnover(@Param("start") Integer start,@Param("end") Integer end,@Param("turnover") Turnover turnover){
        int count = 0;
        StringBuilder sql = new StringBuilder(" select g_id,sum(sale_price) as turnover," +
                                              " sum(sale_amount) as amount from sale_goods ");
        if(turnover != null){
            sql.append(" where ");
            if(turnover.getStartSearchTime() != null && turnover.getStartSearchTime() != ""){
                if(turnover.getEndSearchTime() != null && turnover.getEndSearchTime() != ""){
                    sql.append(" sale_date between #{turnover.startSearchTime} and #{turnover.endSearchTime} ");
                }else{
                    sql.append(" sale_date >= #{turnover.startSearchTime} ");
                }
                count++;
            }else if(turnover.getEndSearchTime() != null && turnover.getEndSearchTime() != "" ){
                sql.append(" sale_date <= #{turnover.endSearchTime} ");
                count++;
            }
            if(turnover.getG_id() != null){
                if(count > 0){
                    sql.append(" and ");
                }
                sql.append(" g_id = #{turnover.g_id} ");
            }
        }
        sql.append(" group by g_id limit #{start},#{end}");
        return sql.toString();
    }

    public String get_performance(@Param("start") Integer start,@Param("end") Integer end,@Param("performance") Performance performance){
        int count = 0;
        StringBuilder sql = new StringBuilder(" select e_id,sum(sale_price) as performance," +
                " sum(sale_amount) as amount from sale_goods ");
        if(performance != null){
            sql.append(" where ");
            if(performance.getStartSearchTime() != null && performance.getStartSearchTime()!= ""){
                if(performance.getEndSearchTime() != null && performance.getEndSearchTime() != ""){
                    sql.append(" sale_date between #{performance.startSearchTime} and #{performance.endSearchTime} ");
                }else{
                    sql.append(" sale_date >= #{performance.startSearchTime} ");
                }
                count++;
            }else if(performance.getEndSearchTime() != null && performance.getEndSearchTime() != "" ){
                sql.append(" sale_date <= #{performance.endSearchTime} ");
                count++;
            }
            if(performance.getE_id() != null){
                if(count > 0){
                    sql.append(" and ");
                }
                sql.append(" e_id = #{performance.e_id} ");
            }
        }
        sql.append(" group by e_id limit #{start},#{end}");
        return sql.toString();
    }
}
