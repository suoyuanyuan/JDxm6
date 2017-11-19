package test.bawei.jdxm6.car.model;

import android.content.Context;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import test.bawei.jdxm6.MainActivity;
import test.bawei.jdxm6.bean.carBean;
import test.bawei.jdxm6.car.CarFinishListener;
import test.bawei.jdxm6.util.Api;
import test.bawei.jdxm6.util.ApiService;

/**
 * Created by 索园 on 2017/11/15.
 */

public class CarModelSx implements carModel{
    @Override
    public void getData(String  uid , String token , final CarFinishListener listener) {
        Map<String,String> map=new HashMap<>();
        map.put("uid",uid);
        map.put("token",token);
        OkHttp3Utils.doPost(Api.api_getcar, map, new GsonObjectCallback<carBean>() {
            @Override
            public void onUi(carBean bean) {
                listener.Success(bean);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
