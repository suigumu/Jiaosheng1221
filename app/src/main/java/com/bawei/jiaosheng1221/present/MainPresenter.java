package com.bawei.jiaosheng1221.present;

import com.bawei.jiaosheng1221.adapter.Bean;
import com.bawei.jiaosheng1221.bean.ShopBean;
import com.bawei.jiaosheng1221.model.MainModelImpl;
import com.bawei.jiaosheng1221.view.MaView;

/**
 * Created by Adminjs on 2017/12/21.
 */

public class MainPresenter {
    private MaView view;
    private MainModelImpl model;
    public MainPresenter(MaView view) {
        this.view = view;
        this.model = new MainModelImpl();
    }

    public void get(){
        model.getData(new MainModelImpl.ModelCallBack() {
            @Override
            public void success(Bean bean) {
                if(view != null){
                    view.success(bean);
                }
            }
        });
    }
    public void detach(){
        view = null;
    }
}

