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
 BindingAdapter 动态根据参数来更改当前View的状态
 BindingConversion 动态根据参数来更改当前View的状态

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
        activityMain8Binding.setIsShow(false);
    }

    public void showBtnClick(View view) {
//         <variable
//                name="show"
//               type="Integer"/>   直接对这个show变量操作可以直接做出显隐
        activityMain8Binding.setShow(View.VISIBLE);

        activityMain8Binding.setIsShow(true);
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

    @BindingAdapter("visibility")
    public static void isVisiblityForView(View view ,boolean isShow){
        view.setVisibility(isShow?View.VISIBLE:View.GONE);
    }


    /**
     * 源码中@BindingAdapter注解的定义，可以看到：
     - value属性是一个String数组，用来存放自定义的属性，示例：android:onItemClick，app:onItemClick
     - requireAll是一个布尔值，用来表示定义的所有属性是否必须都要使用。

     我们定义了3个属性，requireAll=false代表我们在使用时，可以只使用其中一个属性，也可以三个属性都使用；
     如果requireAll=true，代表我们定义的这三个属性都是必须要使用的，不然就会报错。
     * @param v
     * @param boo
     * @param value
     */
    @BindingAdapter(value = {"aaa","bbb"},requireAll = false)
    public static void testAAABBB(Button v,boolean boo,int value){
        v.setText("button is test! " + boo + "," + value);
    }

}