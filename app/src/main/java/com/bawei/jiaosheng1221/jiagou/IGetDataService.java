package com.bawei.jiaosheng1221.jiagou;



import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Menglucywhh on 2017/12/4.
 */

public interface IGetDataService {


    // https://www.zhaoapi.cn/product/addCart?source=android&pid=57&uid=1650&token=2FC3EF31EA25696D2715A971ADE38DE1
    //"uid": 1650,
    // "token": "2FC3EF31EA25696D2715A971ADE38DE1",
    @GET("/product/addCart")
    Call<AddCartBean> addCart(@QueryMap Map<String, String> map);


    //https://www.zhaoapi.cn/product/getCarts?source=android&uid=1650&token=2FC3EF31EA25696D2715A971ADE38DE1
    //uid": 1650,
    // "token": "2FC3EF31EA25696D2715A971ADE38DE1",
    @GET("product/getCarts")
    Call<SelectCartBean> selectCart(@QueryMap Map<String, String> map);



}
