package com.bawei.jiaosheng1221.chushihua;

import com.bawei.jiaosheng1221.bean.LoginBean;
import com.bawei.jiaosheng1221.bean.RegistBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Adminjs on 2017/12/21.
 */

public interface Service {
    ///http://120.27.23.105/user/login
    @GET("user/login")
    Observable<LoginBean> getLogin(@Query("mobile") String mobile, @Query("password") String passwprd);
    @GET("user/reg")
    Observable<RegistBean> getRegist(@Query("mobile") String mobile, @Query("password") String passwprd);
}
