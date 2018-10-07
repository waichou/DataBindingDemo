package com.leavesc.databinding_demo;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.leavesc.databinding_demo.application.MyApp;
import com.leavesc.databinding_demo.databinding.ActivityMain8Binding;
import com.leavesc.databinding_demo.model.Image;

import java.util.Random;

/**
 * 作者：叶应是叶
 * 时间：2018/5/20 14:10
 * 描述：
 */
public class BindingAdapterActivity extends AppCompatActivity {

    private static final String TAG = "Main8Activity";

    private ActivityMain8Binding activityMain8Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMain8Binding = DataBindingUtil.setContentView(this, R.layout.activity_main8);
        activityMain8Binding.setImage(new Image("https://www.baidu.com/img/bd_logo1.png?where=super"));
        activityMain8Binding.setHandler(new Handler());
//        activityMain8Binding.setShow(0);
    }

    public void goneBtnClick(View view) {
        activityMain8Binding.setShow(View.GONE);

    }

    public void showBtnClick(View view) {
//         <variable
//                name="show"
//               type="Integer"/>   直接对这个show变量操作可以直接做出显隐
        activityMain8Binding.setShow(View.VISIBLE);
    }

    public class Handler {

        public void onClick(Image image) {
            image.getUrl().set("https://www.baidu.com/img/bd_logo1.png?where=super");
        }

    }

    @BindingAdapter({"url"})
    public static void loadImage(ImageView view, String url) {
        Log.e(TAG, "loadImage url : " + url);

        Glide.with(MyApp.mContext).load(url).into(view);
    }

    @BindingAdapter("android:text")
    public static void setText(Button view, String text) {
        view.setText(text + "-Button");
    }

    @BindingConversion
    public static String conversionString(String text) {
        return text + "-conversionString";
    }

    @BindingConversion
    public static Drawable convertStringToDrawable(String str) {
        if (str.equals("红色")) {
            return new ColorDrawable(Color.parseColor("#FF4081"));
        }
        if (str.equals("蓝色")) {
            return new ColorDrawable(Color.parseColor("#3F51B5"));
        }
        return new ColorDrawable(Color.parseColor("#344567"));
    }

    @BindingConversion
    public static int convertStringToColor(String str) {
        if (str.equals("红色")) {
            return Color.parseColor("#FF4081");
        }
        if (str.equals("蓝色")) {
            return Color.parseColor("#3F51B5");
        }
        return Color.parseColor("#344567");
    }


    @BindingAdapter("showView")
    public static void showView(Button btn,int visible){//这个参数可以定义成实际匹配的View，或者定义成它的父View类；BindingAdapter注解在默认的情况下就会加载！
        btn.setVisibility(visible);
    }
}