package com.bawei.jiaosheng1221.model;

import com.bawei.jiaosheng1221.adapter.Bean;
import com.bawei.jiaosheng1221.chushihua.MyApp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2017/12/21.
 */

public class MainModelImpl {
    public void getData(final ModelCallBack callBack){
       /* Map<String,String> map = new HashMap<>();
        map.put("keywords","%E7%AC%94%E8%AE%B0%E6%9C%AC");
        map.put("page","1");*/
        MyApp.inters.get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bean>() {
                    @Override
                    public void accept(Bean bean) throws Exception {
                        callBack.success(bean);
                    }
                });
    }

    public interface ModelCallBack {
        public void success(Bean bean);
    }
}
