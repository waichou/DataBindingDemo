package com.leavesc.databinding_demo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.leavesc.databinding_demo.databinding.ActivityMain5Binding;
import com.leavesc.databinding_demo.model.User;

/**
 * 作者：叶应是叶
 * 时间：2018/5/16 22:32
 * 描述：
 */
public class EventBindingActivity extends AppCompatActivity {

    private ActivityMain5Binding activityMain5Binding;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMain5Binding = DataBindingUtil.setContentView(this, R.layout.activity_main5);
        user = new User("leavesC", "12345");
        activityMain5Binding.setUserInfo(user);
        activityMain5Binding.setUserPresenter(new UserPresenter());
        activityMain5Binding.setCustomHandler(new CustomHandler());
    }

    public class UserPresenter {

        public void onUserNameClick(User user) {
            Toast.makeText(EventBindingActivity.this, "用户名：" + user.getName(), Toast.LENGTH_SHORT).show();
        }

        public void afterTextChanged(Editable s) {
            user.setName(s.toString());
            activityMain5Binding.setUserInfo(user);
        }

        public void afterUserPasswordChanged(Editable s) {
            user.setPassword(s.toString());
            activityMain5Binding.setUserInfo(user);
        }

    }

    public class CustomHandler{
        public void changeViewStatus(View view){
            if (view instanceof Button)
            System.out.println("current button text is "/* + view.getText().toString()*/);

            activityMain5Binding.setIsVisible(activityMain5Binding.showStatus.getVisibility()==View.VISIBLE?false:true);

        }

        //自定义监听器

        public void customListener(User user,boolean isVisible){
//            if (view instanceof Button){
//                System.out.println("view is button");
//            }
            System.out.println("user is " + user + ",,," + isVisible);
        }
    }

}
