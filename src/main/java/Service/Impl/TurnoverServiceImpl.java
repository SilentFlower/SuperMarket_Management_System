package Service.Impl;

import Dao.GoodsDao;
import Dao.TurnoverDao;
import Domain.Goods;
import Domain.Page;
import Domain.Turnover;
import Service.TurnoverService;
import Util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/12/17 20:38:14
 * @description
 */
@Service
public class TurnoverServiceImpl implements TurnoverService {

    @Autowired
    private TurnoverDao turnoverDao;

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Map<String,Object> get_Turnover(Page page, Turnover key) {
        Map map = new HashMap();
        int start = (page.getCurrentPage() - 1) * page.getPageSize();
        int end = start + page.getPageSize();
        List<Turnover> turnover = turnoverDao.get_Turnover(start, page.getPageSize(), key);
        List<Goods> allGoods = goodsDao.findAll();
        Integer count = turnoverDao.getCount();
        Page newPage = PageUtil.dealWithPage(page, count);
        map.put("turnover", turnover);
        map.put("allGoods", allGoods);
        map.put("page", newPage);
        return map;
    }
}
