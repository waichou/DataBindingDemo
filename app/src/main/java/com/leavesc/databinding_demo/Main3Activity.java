package com.leavesc.databinding_demo;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.leavesc.databinding_demo.databinding.ActivityMain3Binding;
import com.leavesc.databinding_demo.model.Goods;

import java.util.Random;

/**
 * 作者：叶应是叶
 * 时间：2018/5/16 21:07
 * 描述：
 */
public class Main3Activity extends AppCompatActivity {

    private Goods goods;

    private ActivityMain3Binding activityMain3Binding;

    private static final String TAG = "Main3Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        activityMain3Binding = DataBindingUtil.setContentView(this, R.layout.activity_main3);
        goods = new Goods("code", "hi", 24);
        activityMain3Binding.setGoods(goods);
        activityMain3Binding.setGoodsHandler(new GoodsHandler());
        goods.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == com.leavesc.databinding_demo.BR.name) {
                    Log.e(TAG, "BR.name");
                } else if (propertyId == com.leavesc.databinding_demo.BR.details) {
                    Log.e(TAG, "BR.details");
                } else if (propertyId == com.leavesc.databinding_demo.BR._all) {
                    Log.e(TAG, "BR._all");
                } else if(propertyId == BR.price){
                    Log.e(TAG, "BR.price");
                }
                else {
                    Log.e(TAG, "未知");
                }
            }
        });
        activityMain3Binding.edTextChanged.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
//                if ()
            }
        });
    }

    public class GoodsHandler {

        public void changeGoodsName() {
            goods.setName("code" + new Random().nextInt(100));
            goods.setPrice(new Random().nextInt(100));
        }

        public void changeGoodsDetails() {
            goods.setDetails("hi" + new Random().nextInt(100));
            goods.setPrice(new Random().nextInt(100));
        }

        public TextWatcher textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                System.out.println("before changed===" +s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("text changed===" +s);

            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println("after changed===" +s);
            }
        };

        public View.OnFocusChangeListener changeListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    System.out.println("有焦点--,focus=" + hasFocus);
                } else {
                    System.out.println("无焦点--,focus=" + hasFocus);
                }
            }
        };
    }

}
