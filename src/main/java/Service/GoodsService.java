package Service;

import Domain.Goods;
import Domain.Page;
import Domain.GoodsType;

import java.util.List;
import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/11/24 09:52:24
 * @description
 */
public interface GoodsService {
    public Map<String,Object> getGoodType(Page page,GoodsType goodsType);

    public GoodsType getEditGoodsType(Integer tg_id);

    public Boolean addGoodsType(GoodsType goodsType);

    public Boolean deleteGoodsType(Integer tg_id);

    public Boolean editGoodsType(GoodsType goodsType);

    public Map<String, Object> getGoods(Page page, Goods key);

    public List<String> getAllGoodsTypeName();

    public Boolean addGoods(Goods goods);

    public Goods getEditGoods(Integer g_id);

    public Boolean deleteGoods(Integer g_id);

    public Boolean edit_goods(Goods goods);
}
