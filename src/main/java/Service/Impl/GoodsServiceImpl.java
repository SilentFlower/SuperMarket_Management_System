package Service.Impl;

import Dao.GoodsDao;
import Dao.GoodsTypeDao;
import Domain.Goods;
import Domain.Goods_alarm;
import Domain.Page;
import Domain.GoodsType;
import Service.GoodsService;
import Util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/11/24 09:52:43
 * @description
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsTypeDao goodsTypeDao;
    @Autowired
    private GoodsDao goodsDao;

    private List<Goods_alarm> goods_alarm = new ArrayList<Goods_alarm>();


    @Override
    public Map<String, Object> getGoodType(Page page,GoodsType goodsType) {
        Map map = new HashMap<String,Object>();
        List<GoodsType> goodsTypes = null;
        Integer start = (page.getCurrentPage()-1)*page.getPageSize();
        Integer end = start+page.getPageSize();
        Page newPage = null;
        if(goodsType == null){
            Integer count = goodsTypeDao.getCount();
            newPage = PageUtil.dealWithPage(page, count);
            goodsTypes = goodsTypeDao.getGoodTypes(start, newPage.getPageSize());
        }else {
            goodsTypes = goodsTypeDao.searchByKeyword(goodsType);
            newPage = PageUtil.dealWithPage(page,goodsTypes.size());
            if(end >= newPage.getCount()){
                end = newPage.getCount();
            }
            goodsTypes = goodsTypes.subList(start,end);

        }
        map.put("goodsType",goodsTypes);
        map.put("page",newPage);
        return map;
    }

    @Override
    public GoodsType getEditGoodsType(Integer tg_id) {
        return goodsTypeDao.getById(tg_id);
    }

    @Override
    public Boolean addGoodsType(GoodsType goodsType) {
        GoodsType byName = goodsTypeDao.getByName(goodsType.getTg_name());
        if(byName != null){
            return false;
        }
        Integer integer = goodsTypeDao.addGoodsType(goodsType);
        if(integer > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteGoodsType(Integer tg_id) {
        Integer integer = goodsTypeDao.deleteGoodsType(tg_id);
        if(integer >0 ){
            return true;
        }
        return false;
    }

    @Override
    //注意更新时候名字需要保持不一致
    public Boolean editGoodsType(GoodsType goodsType) {
        GoodsType before = goodsTypeDao.getById(goodsType.getTg_id());
        if(!goodsType.equals(before)){
            if(!goodsType.getTg_name().equals(before.getTg_name())){
                GoodsType gt = goodsTypeDao.getByName(goodsType.getTg_name());
                if(gt == null){
                    Integer integer = goodsTypeDao.editGoodsType(goodsType);
                    if(integer > 0){
                        return true;
                    }
                }
            }else{
                Integer integer = goodsTypeDao.editGoodsType(goodsType);
                if(integer > 0){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Map<String, Object> getGoods(Page page, Goods key) {
        Map map = new HashMap<String,Object>();
        List<Goods> goods = null;
        Integer start = (page.getCurrentPage()-1)*page.getPageSize();
        Integer end = start+page.getPageSize();
        Page newPage = null;
        if(key == null){
            Integer count = goodsDao.getCount();
            newPage = PageUtil.dealWithPage(page, count);
            goods = goodsDao.getGoods(start, newPage.getPageSize());
        }else {
            goods = goodsDao.goodsSearchByKey(key);
            newPage = PageUtil.dealWithPage(page,goods.size());
            if(end >= newPage.getCount()){
                end = newPage.getCount();
            }
            goods = goods.subList(start,end);

        }
        map.put("goods",goods);
        map.put("page",newPage);
        return map;
    }

    @Override
    public List<String> getAllGoodsTypeName() {
        return goodsTypeDao.getAllName();
    }

    @Override
    public Boolean addGoods(Goods goods) {
        Goods find = goodsDao.findByName(goods.getGoods_name());
        if(find == null){
            GoodsType goodsType = goodsTypeDao.getByName(goods.getGoodsType().getTg_name());
            goods.setTg_id(goodsType.getTg_id());
            Integer integer = goodsDao.addGoods(goods);
            if(integer > 0){
                Integer integer1 = goodsTypeDao.updateCountById(goodsType.getTg_id());
                if(integer1 > 0){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Goods getEditGoods(Integer g_id) {
        return goodsDao.findById(g_id);
    }

    @Override
    public Boolean edit_goods(Goods goods) {
        Boolean bool = false;
        Goods before = goodsDao.findById(goods.getG_id());
        if(!before.getGoodsType().getTg_name().equals(goods.getGoodsType().getTg_name())){
            Integer idByName = goodsTypeDao.getIdByName(goods.getGoodsType().getTg_name());
            goods.setTg_id(idByName);
            bool = true;
        }else{
            goods.setTg_id(before.getTg_id());
        }
        if(!before.getGoods_name().equals(goods.getGoods_name()) ||
           !before.getGoods_remarks().equals(goods.getGoods_remarks()) ||
           !before.getGoods_desc().equals(goods.getGoods_desc()) ||
           !before.getGoods_amount().equals(goods.getGoods_amount()) ||
           !before.getGoods_addr().equals(goods.getGoods_addr())){
            bool = true;
        }
        if(bool){
            Integer integer = goodsDao.updateGoods(goods);
            if(integer > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean deleteGoods(Integer g_id) {
        Goods g = goodsDao.findById(g_id);
        Integer integer = goodsDao.deleteById(g_id);
        if(integer > 0){
            Integer integer1 = goodsTypeDao.minusCountById(g.getTg_id());
            if(integer1 > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> getAllGoodsName() {
        return goodsDao.getAllName();
    }


    @Override
    public Map<String,Object> get_goods_alarm(Page page) {
        Map<String, Object> map = new HashMap<String, Object>();
        Page newPage = PageUtil.dealWithPage(page, goods_alarm.size());
        List<Goods> allGoods = goodsDao.findAll();
        map.put("goods_alarm", goods_alarm);
        map.put("page",newPage);
        map.put("allGoods",allGoods);
        return map;
    }

    @Override
    public Boolean add_goods_alarm(Goods_alarm g_a) {
        for (Goods_alarm goodsAlarm : goods_alarm) {
            if(goodsAlarm.getGoods().getG_id().equals(g_a.getGoods().getG_id())){
                return false;
            }
        }
        return goods_alarm.add(g_a);
    }

    @Override
    public Boolean edit_goods_alarm(Goods_alarm goods_alarm, Integer before_g_id) {
        return null;
    }

    @Override
    @Scheduled(cron = "0 0/1 * * * ?")
    public void goods_timer() {
        Integer high = null;
        Integer low = null;
        for (Goods_alarm goodsAlarm : goods_alarm) {
            Integer g_id = goodsAlarm.getGoods().getG_id();
            high = goodsAlarm.getHigh();
            low = goodsAlarm.getLow();
            Goods goods = goodsDao.goods_alarm(g_id, low, high);
            if(goods != null){
                System.out.println("执行发送邮件");
            }else {
                continue;
            }
        }
    }

}
