package com.docking.component.arouter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.docking.component.arouter.ArouterPath;
import com.docking.component.arouter.R;
import com.docking.component.arouter.ArouterHelper;

public class ArouterActivity extends AppCompatActivity implements View.OnClickListener {

    TextView testTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter_main);
        initView();
        initListener();
    }

    private void initView() {
        testTv = this.findViewById(R.id.arouter_test);
    }

    private void initListener() {
        testTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == testTv.getId()) {
            ArouterHelper.navigation(ArouterPath.AROUTER_TEST_PATH);
        }
    }
}
