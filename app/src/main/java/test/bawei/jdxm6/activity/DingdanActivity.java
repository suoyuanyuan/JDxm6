package test.bawei.jdxm6.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import test.bawei.jdxm6.R;
import test.bawei.jdxm6.adapter.DingAdapter;
import test.bawei.jdxm6.bean.BuildDing;
import test.bawei.jdxm6.bean.DingList;
import test.bawei.jdxm6.pay.PayDemoActivity;
import test.bawei.jdxm6.util.Api;

public class DingdanActivity extends BaseActivity {

    private String shop_allmoney;
    private RecyclerView re_ding;
    private TextView ding_set;
    private TextView moding_add;
    private TextView moding_mobile;
    private TextView moding_name;
    private TextView ljxd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingdan);
        Intent intent = getIntent();
        shop_allmoney = intent.getStringExtra("price");
        ljxd = (TextView) findViewById(R.id.ljxd);
        Intent intent1=new Intent(DingdanActivity.this, PayDemoActivity.class);
        startActivity(intent1);
        //创建订单

        SharedPreferences name = getSharedPreferences("name", Context.MODE_PRIVATE);
        String uid = name.getString("uid", null);
        //String price = name.getString("price", null);
       // String token = name.getString("token", null);
        Map<String,String> map=new HashMap<>();
        map.put("uid",uid);
        System.out.println("======================"+uid);
        map.put("price",shop_allmoney);
        System.out.println("======================"+shop_allmoney);
       // map.put("token",token);
        OkHttp3Utils.doPost(Api.api_builedingdan, map, new GsonObjectCallback<BuildDing>() {
            @Override
            public void onUi(BuildDing buildDing) {
                if (buildDing.getCode().equals("0")){
                    Toast.makeText(DingdanActivity.this,buildDing.getMsg().toString(),Toast.LENGTH_SHORT).show();
                }else if (buildDing.getCode().equals("1")){
                    Toast.makeText(DingdanActivity.this,buildDing.getMsg().toString(),Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
        //查询订单列表

        re_ding = (RecyclerView) findViewById(R.id.re_ding);
        re_ding.setLayoutManager(new LinearLayoutManager(this));
        Map<String,String> map1=new HashMap<>();
        map1.put("uid",uid);
      //  map1.put("token",token);
        OkHttp3Utils.doPost(Api.api_dinglist, map1, new GsonObjectCallback<DingList>() {
            @Override
            public void onUi(DingList dingList) {
                List<DingList.DataBean> list = dingList.getData();
                DingAdapter adapter=new DingAdapter(list,DingdanActivity.this);
                re_ding.setAdapter(adapter);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
        //订单设置跳转收货地址列表
        ding_set = (TextView) findViewById(R.id.ding_set);
        ding_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(DingdanActivity.this,AddressActivity.class);
                startActivity(intent1);
            }
        });
        //获取默认地址
   /*     moding_add = (TextView) findViewById(R.id.moding_add);
        moding_mobile = (TextView) findViewById(R.id.moding_mobile);
        moding_name = (TextView) findViewById(R.id.moding_name);
        Map<String,String> map2=new HashMap<>();
        map2.put("uid",uid);
        OkHttp3Utils.doPost();*/
    }
}
