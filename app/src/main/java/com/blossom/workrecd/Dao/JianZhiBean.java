package com.blossom.workrecd.Dao;

/**
 * Created by zxw on 2015/12/16.
 */
public class JianZhiBean {
    public String name;
    public String location;
    public String  datetime;
    public String  price;

    public JianZhiBean() {
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "JianZhiBean{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", datetime='" + datetime + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}


