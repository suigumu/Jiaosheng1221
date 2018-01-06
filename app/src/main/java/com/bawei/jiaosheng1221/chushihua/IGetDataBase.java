package com.bawei.jiaosheng1221.chushihua;

import com.bawei.jiaosheng1221.adapter.Bean;
import com.bawei.jiaosheng1221.bean.DeleteBean;
import com.bawei.jiaosheng1221.bean.ShopBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Adminjs on 2017/12/21.
 */
//http://120.27.23.105/product/searchProducts?keywords=%E7%AC%94%E8%AE%B0%E6%9C%AC&page=1
public interface IGetDataBase {
    @GET("product/searchProducts?keywords=%E7%AC%94%E8%AE%B0%E6%9C%AC&page=1")
    Observable<Bean> get();
    //删除
    //https://www.zhaoapi.cn/product/deleteCart?uid=1650&pid=58
    @GET("/product/deleteCart")
    Call<DeleteBean> deleteCart(@QueryMap Map<String,String> map);
}
