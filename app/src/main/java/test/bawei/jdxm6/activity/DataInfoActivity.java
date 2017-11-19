package test.bawei.jdxm6.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;
import com.youth.banner.Banner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import test.bawei.jdxm6.util.Api;
import test.bawei.jdxm6.R;
import test.bawei.jdxm6.bean.Datainfo;
import test.bawei.jdxm6.bean.addBean;
import test.bawei.jdxm6.util.MyImage;

public class DataInfoActivity extends BaseActivity {

    private String pid;
    private Banner banner;
    private List<String> list=new ArrayList<>();
    private TextView title_info;
    private TextView subhead_info;
    private TextView price_info;
    private TextView car;
    private String sellerid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_info);
        Intent intent=getIntent();
        pid = intent.getStringExtra("pid");
        banner = (Banner) findViewById(R.id.banner2);
        getimage();
        title_info = (TextView) findViewById(R.id.title_info);
        subhead_info = (TextView) findViewById(R.id.subhead_info);
        price_info = (TextView) findViewById(R.id.price_info);
        Map<String,String> map=new HashMap<>();
        map.put("pid",pid);
        OkHttp3Utils.doPost(Api.api_info, map, new GsonObjectCallback<Datainfo>() {

            @Override
            public void onUi(Datainfo datainfo) {

                title_info.setText(datainfo.getData().getTitle());
                price_info.setText(datainfo.getData().getPrice()+"");
                subhead_info.setText(datainfo.getData().getSubhead());
                sellerid = datainfo.getData().getSellerid() + "";
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
            //添加购物车
        car = (TextView) findViewById(R.id.car);
        car.setOnClickListener(new View.OnClickListener() {

            private String uid;

            @Override
            public void onClick(View view) {
                //uid = Login2Activity.preferences.getString("uid", "");

                uid=getSharedPreferences("name", Context.MODE_PRIVATE).getString("uid",null);
                Map<String,String> m=new HashMap<String, String>();
                m.put("uid",uid);
                m.put("pid",pid);
                m.put("sellerid",sellerid);
                OkHttp3Utils.doPost(Api.api_add, m, new GsonObjectCallback<addBean>() {
                    @Override
                    public void onUi(addBean addBean) {
                        if (addBean.getCode().equals("0")){
                            Toast.makeText(DataInfoActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                        }else if (addBean.getCode().equals("1")){
                            Toast.makeText(DataInfoActivity.this,"添加失败",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });
            }
        });
    }
    private void getimage(){
        list.add("https://m.360buyimg.com//n0//jfs//t9004//210//1160833155//647627//ad6be059//59b4f4e1N9a2b1532.jpg!q70.jpg");
        list.add("https://m.360buyimg.com//n0//jfs//t7504//338//63721388//491286//f5957f53//598e95f1N7f2adb87.jpg!q70.jpg");
        list.add("https://m.360buyimg.com//n0//jfs//t7441//10//64242474//419246//adb30a7d//598e95fbNd989ba0a.jpg");
        banner.setImageLoader(new MyImage());
        banner.setImages(list);
        banner.setDelayTime(3000);
        banner.start();
    }
}
