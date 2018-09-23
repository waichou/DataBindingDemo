package com.leavesc.databinding_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void startActivity(Class c) {
        startActivity(new Intent(this, c));
    }

    public void startActivity2(View view) {
        startActivity(SimpleBindingActivity.class);
    }

    public void startActivity3(View view) {//BaseObservable
        startActivity(BaseObservableActivity.class);
    }

    public void startActivity4(View view) {//ObservableField
        startActivity(ObservableFieldActivity.class);
    }

    public void startActivity12(View view) {//ObserableCollection
        startActivity(ObservableCollectionActivity.class);
    }

    public void startActivity5(View view) {//事件绑定
        startActivity(EventBindingActivity.class);
    }

    public void startActivity6(View view) {//viewStub 和 include
        startActivity(ViewStubAndIncludeActivity.class);
    }

    public void startActivity7(View view) {//其他数据类型
        startActivity(OtherDataBindingActivity.class);
    }

    public void startActivity8(View view) {//BindingAdapter 和 BindingConversion
        startActivity(BindingAdapterActivity.class);
    }

    public void startActivity9(View view) {//引用资源
        startActivity(ReferResourceActivity.class);
    }

    public void startActivity10(View view) {//双向绑定
        startActivity(DoubleBindingActivity.class);
    }

    public void startActivity11(View view) {//Fragment
        startActivity(FragmentBindingActivity.class);
    }


}
