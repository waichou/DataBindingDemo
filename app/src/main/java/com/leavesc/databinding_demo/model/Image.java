package com.leavesc.databinding_demo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.leavesc.databinding_demo.BR;

/**
 * 作者：叶应是叶
 * 时间：2018/5/20 13:40
 * 描述：
 */
public class Image extends BaseObservable{

    private ObservableField<String> url;

    public Image(){

    }

    public Image(String url) {
        this.url = new ObservableField<>(url);
    }

    public ObservableField<String> getUrl() {
        return url;
    }

    public void setUrl(ObservableField<String> url) {
        this.url = url;
    }

}
