package Util;

import Domain.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.ibatis.type.TypeReference;

import java.io.IOException;

/**
 * @author SiletFlower
 * @date 2020/11/15 12:16:50
 * @description
 */
public class JsonUtil {
    @SneakyThrows
    public static String  toJsonUtil(Object object){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    @SneakyThrows
    public static Employee toEmployee(String s){
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(s, Employee.class);
        return employee;
    }

    @SneakyThrows
    public static Supplier toSupplier(String s){
        ObjectMapper objectMapper = new ObjectMapper();
        Supplier supplier = objectMapper.readValue(s, Supplier.class);
        return supplier;
    }

    @SneakyThrows
    public static GoodsType toGoodsType(String s){
        ObjectMapper objectMapper = new ObjectMapper();
        GoodsType goodsType = objectMapper.readValue(s, GoodsType.class);
        return goodsType;
    }

    @SneakyThrows
    public static Goods toGoods(String s){
        ObjectMapper objectMapper = new ObjectMapper();
        Goods goodsType = objectMapper.readValue(s, Goods.class);
        return goodsType;
    }

    @SneakyThrows
    public static SupplierGoods toSupplierGoods(String s) {
        ObjectMapper objectMapper = new ObjectMapper();
        SupplierGoods supplierGoods = objectMapper.readValue(s, SupplierGoods.class);
        return supplierGoods;
    }

    public static Supplier_bill toSupplier_bill(String supplier_bill) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Supplier_bill key = objectMapper.readValue(supplier_bill, Supplier_bill.class);
        return key;
    }

    public static Goods_alarm toGoods_alarm(Object goods_alarm) {
        ObjectMapper objectMapper = new ObjectMapper();
        Goods_alarm key = objectMapper.convertValue(goods_alarm, Goods_alarm.class);
        return key;
    }

    @SneakyThrows
    public static SaleGoods toSaleGoods(String key) {
        ObjectMapper objectMapper = new ObjectMapper();
        SaleGoods saleGoods = objectMapper.readValue(key, SaleGoods.class);
        return saleGoods;
    }
}
