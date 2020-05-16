package com.docking.component.ads.provider;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.docking.component.ads.listener.AdsCallback;

/**
 * 广告交互
 */
public interface AdsService extends IProvider {

    void requestAds(int position, AdsCallback callback);

}
