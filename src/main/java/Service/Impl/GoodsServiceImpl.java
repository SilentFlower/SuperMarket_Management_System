package Service.Impl;

import Dao.GoodsDao;
import Dao.GoodsTypeDao;
import Domain.Goods;
import Domain.Goods_alarm;
import Domain.Page;
import Domain.GoodsType;
import Service.GoodsService;
import Util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;

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
    @Autowired
    private MailUtil mailUtil;

    @Value("${mail.toEmail}")
    private String to;

    private Map<Integer, Goods_alarm> goods_alarm = new LinkedHashMap<Integer, Goods_alarm>();


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
        Map<Integer, Goods_alarm> back = new LinkedHashMap<Integer, Goods_alarm>();
        Map<String, Object> map = new HashMap<String, Object>();
        Page newPage = PageUtil.dealWithPage(page, goods_alarm.size());
        Integer start = (page.getCurrentPage()-1)*page.getPageSize();
        Integer end = start+page.getPageSize();
        if(end >= newPage.getCount()){
            end = newPage.getCount();
        }
        int count = 0;
        for (Integer s : goods_alarm.keySet()) {
            if(count >= start && count < end) {
                back.put(s, goods_alarm.get(s));
            }
            count++;
        }
        List<Goods> all = goodsDao.findAll();
        map.put("goods_alarm", back);
        map.put("page",newPage);
        map.put("allGoods",all);
        return map;
    }

    @Override
    public Boolean add_goods_alarm(Goods_alarm g_a) {
        if (goods_alarm.containsKey(g_a.getGoods().getG_id())) {
            return false;
        }
        goods_alarm.put(g_a.getGoods().getG_id(), g_a);
        return true;
    }

    @Override
    public Boolean edit_goods_alarm(Goods_alarm g_a, Integer before_g_id) {
        Goods_alarm before = this.goods_alarm.get(before_g_id);
        if(!g_a.getGoods().getG_id().equals(before_g_id)){
            if(goods_alarm.containsKey(g_a.getGoods().getG_id())){
                return false;
            }
            goods_alarm.remove(before_g_id);
            goods_alarm.put(g_a.getGoods().getG_id(), g_a);
            return true;
        }else if(!before.getHigh().equals(g_a.getHigh()) || !before.getLow().equals(g_a.getLow())){
            goods_alarm.put(g_a.getGoods().getG_id(), g_a);
            return true;
        }
        return false;
    }

    @Override
    @Scheduled(cron = "0 0/1 * * * ?")
    public void goods_timer() {
//        StringBuilder builder = new StringBuilder();
//        Boolean bool = false;
//        Integer high = null;
//        Integer low = null;
//        Set<Integer> integers = goods_alarm.keySet();
//        for (Integer integer : integers) {
//            Goods_alarm goodsAlarm = goods_alarm.get(integer);
//            Integer g_id = integer;
//            high = goodsAlarm.getHigh();
//            low = goodsAlarm.getLow();
//            Goods goods = goodsDao.findById(g_id);
//            if(high == null){
//                high = goods.getGoods_amount();
//            }
//            if(low == null){
//                low = goods.getGoods_amount();
//            }
//            if(goods.getGoods_amount() < low){
//                bool = true;
//                builder.append("商品 <strong>"+goods.getGoods_name()+"</strong> 库存小于<strong> "+low+"</strong>，请及时调整。");
//            }else if(goods.getGoods_amount() > high){
//                bool = true;
//                builder.append("商品 <strong>"+goods.getGoods_name()+"</strong> 库存大于<strong> "+high+"</strong>，请及时调整。");
//            }
//            if(true){
//                String message = EmailTemplateUtil.emailTemplate(builder.toString());
//                mailUtil.sendMail(message ,to,"库存警报");
//                bool = false;
//            }else{
//                continue;
//            }
//        }
    }

    @PostConstruct
    @Override
    public void goods_timer_load() {
        Object o = ObjectSaveUtil.readFileToObject();
        if(o != null){
            goods_alarm = (Map<Integer, Goods_alarm>) o;
        }
    }

    @PreDestroy
    @Override
    public void goods_timer_off() {
        ObjectSaveUtil.writeObjectToFile(goods_alarm);
    }

    @Override
    public Boolean delete_goods_alarm(Integer g_id) {
        Goods_alarm remove = goods_alarm.remove(g_id);
        if(remove != null){
            return true;
        }
        return false;
    }
}
