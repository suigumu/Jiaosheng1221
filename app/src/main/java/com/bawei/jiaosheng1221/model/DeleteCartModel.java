package com.bawei.jiaosheng1221.model;


import com.bawei.jiaosheng1221.bean.DeleteBean;
import com.bawei.jiaosheng1221.chushihua.MyApp;
import com.bawei.jiaosheng1221.jiagou.IGetDataService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Menglucywhh on 2017/12/11.
 */

public class DeleteCartModel {

    public void delete(String pid, final DeleteCartModelCallBack deleteCartModelCallBack) {
        //https://www.zhaoapi.cn/product/deleteCart?uid=1650&pid=58
        Map<String,String> map = new HashMap<>();
        map.put("source","android");
        map.put("uid","4729");
        map.put("pid",pid);

        MyApp.inters.deleteCart(map).enqueue(new Callback<DeleteBean>() {
            @Override
            public void onResponse(Call<DeleteBean> call, Response<DeleteBean> response) {
                DeleteBean deleteBean = response.body();
                deleteCartModelCallBack.success(deleteBean);
            }

            @Override
            public void onFailure(Call<DeleteBean> call, Throwable t) {
                deleteCartModelCallBack.failure();
            }
        });
    }

}
