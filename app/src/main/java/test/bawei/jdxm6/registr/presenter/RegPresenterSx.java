package test.bawei.jdxm6.registr.presenter;

import android.content.Context;

import test.bawei.jdxm6.registr.FinishListener;
import test.bawei.jdxm6.registr.model.RegModel;
import test.bawei.jdxm6.registr.model.RegModelSx;
import test.bawei.jdxm6.registr.view.RegView;

/**
 * Created by 索园 on 2017/11/13.
 */

public class RegPresenterSx implements RegPresenter,FinishListener{
    private RegView regView;
    private final RegModel regModel;

    public RegPresenterSx(RegView regView) {
        this.regView = regView;
        regModel=new RegModelSx(this);
    }

    @Override
    public void RegModile() {
         regView.onRegPwd();
    }

    @Override
    public void RegPwd() {
        regView.onRegPwd();
    }

    @Override
    public void Success() {
       regView.onSuccess();
    }

    @Override
    public void Fail() {
      regView.onFail();
    }

    @Override
    public void getData(Context context, String regmobile, String regwd) {
       regModel.regLogin(context,regmobile,regwd);
    }
}
