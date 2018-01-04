package com.bawei.jiaosheng1221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jiaosheng1221.bean.LoginBean;
import com.bawei.jiaosheng1221.chushihua.Service;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.simple)
    ImageView simple;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.wang)
    TextView wang;
    @BindView(R.id.zhu)
    TextView zhu;
    @BindView(R.id.login)
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.zhu, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhu:
                Intent intent = new Intent(MainActivity.this, ZhuCeActivity.class);
                startActivity(intent);
                break;
            case R.id.login:
                String p = phone.getText().toString().trim();
                String pa = pass.getText().toString().trim();
                Retrofit retrofit =  new Retrofit.Builder()
                        .baseUrl("http://120.27.23.105")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
                Service service = retrofit.create(Service.class);
                service.getLogin(p,pa).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<LoginBean>() {
                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }

                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(LoginBean loginBean) {
                                String code = loginBean.getCode();
                                if (code.equals("0")){
                                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this, XingActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                break;
        }
    }
}
