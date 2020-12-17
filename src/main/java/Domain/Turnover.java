package Domain;

/**
 * @author SiletFlower
 * @date 2020/12/17 20:24:25
 * @description
 */
public class Turnover {
    private Integer g_id;
    private Goods goods;
    private String startSearchTime;
    private String endSearchTime;
    private Double turnover;
    private Integer amount;

    public Integer getG_id() {
        return g_id;
    }

    public void setG_id(Integer g_id) {
        this.g_id = g_id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

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

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }
}
