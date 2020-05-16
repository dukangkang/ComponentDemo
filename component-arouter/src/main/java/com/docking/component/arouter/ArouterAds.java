//package com.docking.component.arouter;
//
//import android.content.Context;
//import android.util.Log;
//import android.view.View;
//import android.widget.FrameLayout;
//
//import com.alibaba.android.arouter.launcher.ARouter;
//import com.docking.component.arouter.listener.AdsCallback;
//import com.docking.component.arouter.provider.AdsService;
//
//public class ArouterAds {
//
//    public ArouterAds() {
//        ARouter.getInstance().inject(this);
//    }
//
//    public FrameLayout initAds(Context context, int position) {
//        final FrameLayout frameLayout = new FrameLayout(context);
//        AdsService adsService = ARouter.getInstance().navigation(AdsService.class);
//        Log.w("dkk", "--->>> adsService = " + adsService);
//        if (adsService != null) {
//            adsService.requestAds(position, new AdsCallback() {
//                @Override
//                public void onSuccess(View view) {
//                    frameLayout.removeAllViews();
//                    frameLayout.addView(view);
//                }
//
//                @Override
//                public void onFailed() {
//
//                }
//            });
//        }
//        return frameLayout;
//    }
//}
