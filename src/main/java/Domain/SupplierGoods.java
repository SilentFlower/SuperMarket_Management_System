package Domain;

import Util.DateUtil;
import lombok.SneakyThrows;

import java.util.Date;

/**
 * @author SiletFlower
 * @date 2020/11/24 09:43:20
 * @description
 */
public class SupplierGoods {
    private Integer sg_id;
    private Integer g_id;//商品
    private Goods goods;
    private Integer s_id;//供应商
    private Supplier supplier;
    private Integer sg_amount;
    private Double sg_price;
    private Date sg_date;
    private String sg_date_string;
    private Boolean sg_paid;

    @Override
    public String toString() {
        return "SupplierGoods{" +
                "sg_id=" + sg_id +
                ", g_id=" + g_id +
                ", goods=" + goods +
                ", s_id=" + s_id +
                ", supplier=" + supplier +
                ", sg_amount=" + sg_amount +
                ", sg_price=" + sg_price +
                ", sg_date=" + sg_date +
                ", sg_date_string='" + sg_date_string + '\'' +
                ", sg_paid=" + sg_paid +
                '}';
    }

    public Boolean getSg_paid() {
        return sg_paid;
    }

    public void setSg_paid(Boolean sg_paid) {
        this.sg_paid = sg_paid;
    }

    public Integer getSg_id() {
        return sg_id;
    }

    public void setSg_id(Integer sg_id) {
        this.sg_id = sg_id;
    }

    public Integer getG_id() {
        return g_id;
    }

    public void setG_id(Integer g_id) {
        this.g_id = g_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getSg_amount() {
        return sg_amount;
    }

    public void setSg_amount(Integer sg_amount) {
        this.sg_amount = sg_amount;
    }

    public Double getSg_price() {
        return sg_price;
    }

    public void setSg_price(Double sg_price) {
        this.sg_price = sg_price;
    }

    public Date getSg_date() {
        return sg_date;
    }

    public void setSg_date(Date sg_date) {
        this.sg_date = sg_date;
        if(sg_date != null){
            this.sg_date_string = DateUtil.getDateString(sg_date);
        }
    }

    public String getSg_date_string() {
        return sg_date_string;
    }

    @SneakyThrows
    public void setSg_date_string(String sg_date_string) {
        this.sg_date_string = sg_date_string;
        if(sg_date_string != null){
            this.sg_date = DateUtil.getDate(sg_date_string);
        }
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }


}
