package test.bawei.jdxm6.login.model;

import android.content.Context;
import android.text.TextUtils;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import test.bawei.jdxm6.util.Api;
import test.bawei.jdxm6.bean.LoginBean;
import test.bawei.jdxm6.login.LogFinishListener;

/**
 * Created by 索园 on 2017/11/13.
 */

public class LogModelSx implements LogModel{
    private LogFinishListener logFinishListener;

    public LogModelSx(LogFinishListener logFinishListener) {
        this.logFinishListener = logFinishListener;
    }

    @Override
    public void LogLogin(Context context, String logMobile, String logPwd) {
        if (TextUtils.isEmpty(logMobile)){
            logFinishListener.LogMobile();
            return;
        }
        if (TextUtils.isEmpty(logPwd)){
            logFinishListener.LogPwd();
            return;
        }
        LogRequest(context,logMobile,logPwd);
    }

    @Override
    public void LogRequest(Context context, String logMobile, String logPwd) {
        Map<String,String> map = new HashMap<>();
        map.put("mobile",logMobile);
        map.put("password",logPwd);
        OkHttp3Utils.doPost(Api.Api_login, map, new GsonObjectCallback<LoginBean>() {
            @Override
            public void onUi(LoginBean loginBean) {

                    logFinishListener.Success(loginBean);

            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
