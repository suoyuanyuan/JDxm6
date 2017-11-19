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

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import test.bawei.jdxm6.R;
import test.bawei.jdxm6.adapter.AddAdapter;
import test.bawei.jdxm6.bean.addList;
import test.bawei.jdxm6.util.Api;

public class AddressActivity extends AppCompatActivity {

    private RecyclerView re_address;
    private TextView tv_newadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        re_address = (RecyclerView) findViewById(R.id.re_address);
        re_address.setLayoutManager(new LinearLayoutManager(this));
        SharedPreferences name = getSharedPreferences("name", Context.MODE_PRIVATE);
        String uid = name.getString("uid", null);
        String token = name.getString("token", null);
        Map<String,String> map=new HashMap<>();
        map.put("uid",uid);
        map.put("token",token);
        OkHttp3Utils.doPost(Api.api_addlist, map, new GsonObjectCallback<addList>() {
            @Override
            public void onUi(addList addList) {
                List<addList.DataBean> list=addList.getData();
                AddAdapter adapter=new AddAdapter(list,AddressActivity.this);
                re_address.setAdapter(adapter);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
        tv_newadd = (TextView) findViewById(R.id.tv_newadd);
        tv_newadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddressActivity.this,SetAddActivity.class);
                startActivity(intent);
            }
        });
    }
}
