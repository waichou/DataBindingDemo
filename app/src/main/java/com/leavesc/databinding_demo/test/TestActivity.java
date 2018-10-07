package com.leavesc.databinding_demo.test;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.leavesc.databinding_demo.R;
import com.leavesc.databinding_demo.databinding.ActivityTestBinding;

public class TestActivity extends AppCompatActivity {

    private ActivityTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_test);
        DataCtrol dataCtrol = new DataCtrol();
        binding.setCtrl(dataCtrol);

    }
}
