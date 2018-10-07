package com.leavesc.databinding_demo.test;

import com.leavesc.databinding_demo.model.User;

/**
 * @author zhouwei
 * @date 2018/9/27
 * @time 20:33
 * @desc
 */
public class DataCtrol {

    private User user;

    public DataCtrol(){
        user = new User("zhouwei","123");

        print();
    }

    private void print() {
        System.out.println("hheehe!");
    }


    public User getModel(){
        return user;
    }
}
