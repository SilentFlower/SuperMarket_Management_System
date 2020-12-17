package Domain;

import Util.DateUtil;
import Util.JsonUtil;
import Util.NewJsonUtil;

import java.text.ParseException;
import java.util.Date;

/**
 * @author SiletFlower
 * @date 2020/11/24 09:36:35
 * @description
 */
public class SaleGoods {
    private Integer sale_id;
    private Integer g_id;//销售商品的ID
    private Integer e_id;//销售的员工ID
    private Integer sale_amount;
    private Date sale_date;
    private String sale_date_string;
    private Double sale_price;
    private Goods goods;
    private Employee employee;
    private String startSearchTime;
    private String endSearchTime;

    public String getStartSearchTime() {
        return startSearchTime;
    }

    public void setStartSearchTime(String startSearchTime) {
        this.startSearchTime = startSearchTime;
    }

    public String getEndSearchTime() {
        return endSearchTime;
    }

    public void setEndSearchTime(String endSearchTime) {
        this.endSearchTime = endSearchTime;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getSale_id() {
        return sale_id;
    }

    public void setSale_id(Integer sale_id) {
        this.sale_id = sale_id;
    }

    public Integer getG_id() {
        return g_id;
    }

    public void setG_id(Integer g_id) {
        this.g_id = g_id;
    }

    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public Integer getSale_amount() {
        return sale_amount;
    }

    public void setSale_amount(Integer sale_amount) {
        this.sale_amount = sale_amount;
    }

    public Date getSale_date() {
        return sale_date;
    }

    /**
     * 回来测试
     * @param sale_date
     */
    public void setSale_date(Date sale_date) {
        this.sale_date = sale_date;
        if(sale_date != null){
            String dateString = DateUtil.getDateString(sale_date);
            this.sale_date_string = dateString;
        }
    }

    public String getSale_date_string() {
        return sale_date_string;
    }

    public void setSale_date_string(String sale_date_string) throws ParseException {
        this.sale_date_string = sale_date_string;
        if(sale_date_string != null){
            Date date = DateUtil.getDate(sale_date_string);
            this.sale_date = date;
        }
    }

    public Double getSale_price() {
        return sale_price;
    }

    public void setSale_price(Double sale_price) {
        this.sale_price = sale_price;
    }
}
