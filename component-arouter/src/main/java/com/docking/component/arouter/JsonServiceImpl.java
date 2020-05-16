package com.docking.component.arouter;//package com.docking.component.arouter.activity;//package com.docking.component.core.arouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import java.lang.reflect.Type;

@Route(path = "/test/json")
public class JsonServiceImpl implements SerializationService {

    private Gson mGson;

    @Override
    public void init(Context context) {
        mGson = new Gson();

    }

    @Override
    public <T> T json2Object(String text, Class<T> clazz) {
        checkJson();
        Log.w("dkk", "json2Object: " + text);
        return mGson.fromJson(text, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        Log.w("dkk", "object2Json: object2Json");
        checkJson();
        return mGson.toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        Log.w("dkk", "parseObject: " + input);
        checkJson();
        return mGson.fromJson(input, clazz);
    }

    public void checkJson() {
        if (mGson == null) {
            mGson = new Gson();
        }
    }

//    @Override
//    public void init(Context context) {
//
//    }
//
//    @Override
//    public <T> T json2Object(String text, Class<T> clazz) {
//        return JSON.parseObject(text, clazz);
//    }
//
//    @Override
//    public String object2Json(Object instance) {
//        return JSON.toJSONString(instance);
//    }
//
//    @Override
//    public <T> T parseObject(String input, Type clazz) {
//        return JSON.parseObject(input, clazz);
//    }
}