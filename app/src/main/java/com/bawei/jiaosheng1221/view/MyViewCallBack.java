package com.bawei.jiaosheng1221.view;

import com.bawei.jiaosheng1221.bean.DingdanBean;

/**
 * Created by Menglucywhh on 2017/11/20.
 */
public interface MyViewCallBack {
    public void viewSuccess(DingdanBean dingdanBean);
    public void viewFail(Exception e);
}
