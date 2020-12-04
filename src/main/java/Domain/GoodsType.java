package Domain;

/**
 * @author SiletFlower
 * @date 2020/11/24 09:34:59
 * @description
 */
public class GoodsType {
    private Integer tg_id;
    private String tg_name;
    private Integer tg_count;

    public Integer getTg_id() {
        return tg_id;
    }

    public void setTg_id(Integer tg_id) {
        this.tg_id = tg_id;
    }

    public String getTg_name() {
        return tg_name;
    }

    public void setTg_name(String tg_name) {
        this.tg_name = tg_name;
    }

    public Integer getTg_count() {
        return tg_count;
    }

    public void setTg_count(Integer tg_count) {
        this.tg_count = tg_count;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "tg_id=" + tg_id +
                ", tg_name='" + tg_name + '\'' +
                ", tg_count=" + tg_count +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsType goodsType = (GoodsType) o;

        if (tg_id != null ? !tg_id.equals(goodsType.tg_id) : goodsType.tg_id != null) return false;
        if (tg_name != null ? !tg_name.equals(goodsType.tg_name) : goodsType.tg_name != null) return false;
        return tg_count != null ? tg_count.equals(goodsType.tg_count) : goodsType.tg_count == null;
    }

    @Override
    public int hashCode() {
        int result = tg_id != null ? tg_id.hashCode() : 0;
        result = 31 * result + (tg_name != null ? tg_name.hashCode() : 0);
        result = 31 * result + (tg_count != null ? tg_count.hashCode() : 0);
        return result;
    }
}
