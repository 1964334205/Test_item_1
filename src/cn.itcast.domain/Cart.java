package cn.itcast.domain;

import java.util.LinkedHashMap;
import java.util.Map;

//用户购物车
public class Cart {
    private Map<String,CartLtem> map = new LinkedHashMap();
    private float unit_price;
    public Map<String, CartLtem> getMap() {
        return map;
    }

    public void setMap(Map<String, CartLtem> map) {
        this.map = map;
    }

    public void add(Book book){
        //查看购物车是否存在要添加的书对应的购物项
        CartLtem calendar = map.get(book.getId());
        if (calendar == null){
            calendar = new CartLtem();
            calendar.setBook(book);
            calendar.setQuantity(1);
            map.put(book.getId(),calendar);
        }else {
            calendar.setQuantity(calendar.getQuantity()+1);
        }
    }

    public void add(Book book,int quantityint){
        //查看购物车是否存在要添加的书对应的购物项
        CartLtem calendar = map.get(book.getId());
        if (calendar == null){
            calendar = new CartLtem();
            calendar.setBook(book);
            calendar.setQuantity(quantityint);
            map.put(book.getId(),calendar);
        }else {
            calendar.setQuantity(calendar.getQuantity()+quantityint);
        }
    }
    public float getUnit_price() {
        float totalprice = 0;
        for (Map.Entry<String,CartLtem> entry :map.entrySet()){
            CartLtem cartLtem = entry.getValue();
            totalprice +=cartLtem.getUnit_price();
        }
        this.unit_price = totalprice;
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }
}

