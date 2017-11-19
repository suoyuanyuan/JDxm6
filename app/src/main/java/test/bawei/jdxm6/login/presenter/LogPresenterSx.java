package test.bawei.jdxm6.login.presenter;

import android.content.Context;

import test.bawei.jdxm6.bean.LoginBean;
import test.bawei.jdxm6.login.LogFinishListener;
import test.bawei.jdxm6.login.model.LogModel;
import test.bawei.jdxm6.login.model.LogModelSx;
import test.bawei.jdxm6.login.view.LogView;

/**
 * Created by 索园 on 2017/11/13.
 */

public class LogPresenterSx implements LogPresenter,LogFinishListener {
    private LogView logView;
    private final LogModel logModel;

    public LogPresenterSx(LogView logView) {
        this.logView = logView;
        logModel=new LogModelSx(this);
    }

    @Override
    public void LogMobile() {
          logView.onLogMobile();
    }

    @Override
    public void LogPwd() {
         logView.onLogPwd();
    }

    @Override
    public void Success(LoginBean bean) {
      logView.onSuccess(bean);
    }

    @Override
    public void Fail() {
       logView.onFial();
    }

    @Override
    public void getData(Context context, String logMobile, String logPwd) {
        logModel.LogLogin(context,logMobile,logPwd);
    }
}
