package com.bawei.jiaosheng1221.model;

import com.bawei.jiaosheng1221.bean.DeleteBean;
/**
 * Created by Menglucywhh on 2017/12/11.
 */

public interface DeleteCartModelCallBack {
    public void success(DeleteBean deleteBean);
    public void failure();
}
