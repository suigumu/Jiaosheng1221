package com.bawei.jiaosheng1221;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jiaosheng1221.adapter.ShopAdapter;
import com.bawei.jiaosheng1221.bean.ShopBean;
import com.bawei.jiaosheng1221.present.MainPresente;
import com.bawei.jiaosheng1221.view.MainViewListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2017/12/19.
 */

public class GouActivity extends Activity implements MainViewListener {

    @BindView(R.id.third_recyclerview)
    RecyclerView thirdRecyclerview;
    @BindView(R.id.third_allselect)
    CheckBox checkBoxAll;
    @BindView(R.id.third_totalprice)
    TextView thirdTotalprice;
    @BindView(R.id.third_totalnum)
    TextView thirdTotalnum;
    @BindView(R.id.third_submit)
    TextView thirdSubmit;
    @BindView(R.id.third_pay_linear)
    LinearLayout thirdPayLinear;
    private MainPresente presenter;
    private ShopAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gou);
        ButterKnife.bind(this);
        presenter = new MainPresente(this);
        presenter.getData();


        adapter = new ShopAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        thirdRecyclerview.setLayoutManager(manager);
        thirdRecyclerview.setAdapter(adapter);


        adapter.setListener(new ShopAdapter.UpdateUiListener() {
            @Override
            public void setTotal(String total, String num,boolean allCheck) {


                checkBoxAll.setChecked(allCheck);
                thirdTotalnum.setText("总数:"+num);
                thirdTotalprice.setText("总价:"+total);
            }
        });


    }

    @Override
    public void success(ShopBean bean) {
        adapter.add(bean);
    }

    @Override
    public void failure(Exception e) {

        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @OnClick(R.id.third_allselect)
    public void onViewClicked() {

        adapter.selectAll(checkBoxAll.isChecked());


    }
}