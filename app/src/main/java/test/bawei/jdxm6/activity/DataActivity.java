package test.bawei.jdxm6.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import test.bawei.jdxm6.R;
import test.bawei.jdxm6.adapter.DataAdapter;
import test.bawei.jdxm6.bean.FenBeanList;
import test.bawei.jdxm6.datalist.presenter.DataPresener;
import test.bawei.jdxm6.datalist.presenter.DataPresenerSx;
import test.bawei.jdxm6.datalist.view.DataShow;

public class DataActivity extends BaseActivity implements DataShow{

    private RecyclerView re4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Intent intent=getIntent();
        String pscid = intent.getStringExtra("pscid");
        re4 = (RecyclerView) findViewById(R.id.re4);
        re4.setLayoutManager(new LinearLayoutManager(DataActivity.this));
        DataPresener dataPresener=new DataPresenerSx(this);
        dataPresener.passData(pscid);
    }

    @Override
    public void showData(FenBeanList beanList) {
        List<FenBeanList.DataBean> list=beanList.getData();
        DataAdapter adapter=new DataAdapter(list,DataActivity.this);
        re4.setAdapter(adapter);
        adapter.setOnItemClickListener(new DataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FenBeanList.DataBean bean) {
                String pid = bean.getPid() + "";
                Intent intent=new Intent(DataActivity.this,DataInfoActivity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
            }
        });
    }
}
