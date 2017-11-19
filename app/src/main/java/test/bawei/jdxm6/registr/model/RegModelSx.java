package test.bawei.jdxm6.registr.model;

import android.content.Context;
import android.text.TextUtils;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import test.bawei.jdxm6.util.Api;
import test.bawei.jdxm6.bean.Bean;
import test.bawei.jdxm6.registr.FinishListener;

/**
 * Created by 索园 on 2017/11/13.
 */

public class RegModelSx implements RegModel {
    private FinishListener listener;

    public RegModelSx(FinishListener listener) {
        this.listener = listener;
    }

    @Override
    public void regLogin(Context context, String regmobile, String regwd) {
        if (TextUtils.isEmpty(regmobile)){
            listener.RegModile();
        }
        if (TextUtils.isEmpty(regwd)){
            listener.RegPwd();
            return;
        }
        regRequest(context,regmobile,regwd);
    }

    @Override
    public void regRequest(Context context, String regmobile, String regwd) {
        Map<String,String> map=new HashMap<>();
        map.put("mobile",regmobile);
        map.put("password",regwd);
        OkHttp3Utils.doPost(Api.Api_regist, map, new GsonObjectCallback<Bean>() {
            @Override
            public void onUi(Bean bean) {
                 if (bean.getCode().equals("0")){
                     listener.Success();
                 }else if (bean.getCode().equals("1")){
                     listener.Fail();
                 }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
