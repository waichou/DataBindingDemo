package com.leavesc.databinding_demo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.leavesc.databinding_demo.BR;

/**
 * 作者：叶应是叶
 * 时间：2018/5/16 20:54
 * 描述：
 */
public class Goods extends BaseObservable {//发现没有不能够双向绑定

    //如果是 public 修饰符，则可以直接在成员变量上方加上 @Bindable 注解
    private String name;

    //如果是 private 修饰符，则在成员变量的 get 方法上添加 @Bindable 注解
    private String details;

    private float price;

    private String address;

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }

    public Goods(String name, String details, float price, String address) {
        this.name = name;
        this.details = details;
        this.price = price;
        this.address = address;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //只更新本字段
        notifyPropertyChanged(com.leavesc.databinding_demo.BR.name);
    }

    @Bindable
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
        //更新所有字段
        notifyChange();
    }

    @Bindable
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", price=" + price +
                '}';
    }

}