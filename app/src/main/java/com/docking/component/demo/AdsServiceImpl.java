package com.docking.component.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.docking.component.ads.listener.AdsCallback;
import com.docking.component.ads.provider.AdsService;

/**
 * @author dukangkang
 */
@Route(path = "/main/ads", name = "广告服务")
public class AdsServiceImpl implements AdsService {
    @Override
    public void requestAds(int position, AdsCallback callback) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final View view = LayoutInflater.from(MainApp.sContext).inflate(R.layout.ads_view, null, false);
        view.findViewById(R.id.ad_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setVisibility(View.GONE);
            }
        });
        callback.onSuccess(view);
    }

    @Override
    public void init(Context context) {

    }
}
