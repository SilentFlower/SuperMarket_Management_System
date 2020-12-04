package Domain;

/**
 * @author SiletFlower
 * @date 2020/11/24 09:17:10
 * @description
 */
public class Goods {
    private Integer g_id;
    private String goods_name;
    private String goods_desc;//描述
    private String goods_addr;
    private String goods_remarks;//备注
    private Integer goods_amount;
    private Integer tg_id;//种类
    private GoodsType goodsType;//种类的pojo对象

    public GoodsType getGoodsType() {
        return goodsType;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "g_id=" + g_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_desc='" + goods_desc + '\'' +
                ", goods_addr='" + goods_addr + '\'' +
                ", goods_remarks='" + goods_remarks + '\'' +
                ", goods_amount=" + goods_amount +
                ", tg_id=" + tg_id +
                ", goodsType=" + goodsType +
                '}';
    }

    public Integer getGoods_amount() {
        return goods_amount;
    }

    public void setGoods_amount(Integer goods_amount) {
        this.goods_amount = goods_amount;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getG_id() {
        return g_id;
    }

    public void setG_id(Integer g_id) {
        this.g_id = g_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_desc() {
        return goods_desc;
    }

    public void setGoods_desc(String goods_desc) {
        this.goods_desc = goods_desc;
    }

    public String getGoods_addr() {
        return goods_addr;
    }

    public void setGoods_addr(String goods_addr) {
        this.goods_addr = goods_addr;
    }

    public String getGoods_remarks() {
        return goods_remarks;
    }

    public void setGoods_remarks(String goods_remarks) {
        this.goods_remarks = goods_remarks;
    }


    public Integer getTg_id() {
        return tg_id;
    }

    public void setTg_id(Integer tg_id) {
        this.tg_id = tg_id;
    }
}
