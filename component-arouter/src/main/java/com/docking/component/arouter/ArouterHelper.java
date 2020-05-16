package com.docking.component.arouter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;

public class ArouterHelper<T> {

    /**
     * 构建标准的路由请求
     * @param path
     */
    public static void navigation(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    /**
     * 构建标准的路由请求，并指定分组
     * @param path
     * @param group
     */
    public static void navigation(String path, String group) {
        // 构建标准的路由请求，并指定分组
        ARouter.getInstance().build(path, group).navigation();
    }

/*
    public <T> void navigation(String path, String key, T t) {
        // 2. 跳转并携带参数
        ARouter.getInstance().build(path)
                .withObject(key, t)
                .navigation();
    }
*/

//    public static void navigation(String path, ArouterBean bean) { // 2. 跳转并携带参数
//        ARouter.getInstance().build(path)
//                .withString("key1", "hello world")
//                .withObject("key", bean)
//                .navigation();
//    }

    public static void navigation(String path, List list) { // 2. 跳转并携带参数
        ARouter.getInstance().build(path)
                .withString("key1", "hello world")
                .withObject("key", list)
                .navigation();
    }

    public static Fragment getFragment(String path) {

        // 获取Fragment
        Fragment fragment = (Fragment) ARouter.getInstance().build(path).navigation();
        return fragment;
    }


}
