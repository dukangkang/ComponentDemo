package com.docking.component.arouter.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.docking.component.arouter.ArouterPath;
import com.docking.component.arouter.R;
import com.docking.component.arouter.bean.UserBean;

import java.util.List;

@Route(path = ArouterPath.AROUTER_TEST_PATH)
public class TestActivity extends Activity {

    @Autowired(name = "key1")
    String desc;

    // 支持解析自定义对象，URL中使用json传递
    @Autowired(name = "key")
    List<UserBean> bean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_arouter_test);

        Log.w("dkk", "desc = " + desc);
        if (bean != null) {
            Log.w("dkk", "bean = " + bean.toString());
        }
    }

}
