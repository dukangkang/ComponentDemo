package com.docking.component.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.docking.component.ads.ArouterAds;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView testTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        testTv = this.findViewById(R.id.host_test);
    }

    private void initListener() {
        testTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == testTv.getId()) {
            Toast.makeText(this, "点击test", Toast.LENGTH_SHORT).show();

//            List<UserBean> list = new ArrayList<>();
////            for (int i = 0; i < 5; i++) {
////                UserBean bean = new UserBean();
////                bean.name = "张三 " + i;
////                bean.age = 24;
////
////                list.add(bean);
////            }
////            ArouterHelper.navigation(ArouterPath.AROUTER_TEST_PATH, list);

//            Fragment fragment = ArouterHelper.getFragment(ArouterPath.AROUTER_FRAGMENT_PATH);
//            FragmentManager fragmentManager = this.getSupportFragmentManager();
//            FragmentTransaction transaction = fragmentManager.beginTransaction();
//            transaction.replace(R.id.host_fragment, fragment);
//            transaction.commitAllowingStateLoss();

            ArouterAds arouterAds = new ArouterAds();
            FrameLayout frameLayout = arouterAds.initAds(this, 11);

            FrameLayout layout = findViewById(R.id.host_adview);
            layout.removeAllViews();
            layout.addView(frameLayout);
        }
    }
}
