package Domain;

import org.springframework.stereotype.Component;

/**
 * @author SiletFlower
 * @date 2020/12/7 21:55:42
 * @description
 */
public class Goods_alarm {
    private Goods goods;
    private Integer low;
    private Integer high;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getLow() {
        return low;
    }

    public void setLow(Integer low) {
        this.low = low;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return "Goods_alarm{" +
                "goods=" + goods +
                ", low=" + low +
                ", high=" + high +
                '}';
    }
}
