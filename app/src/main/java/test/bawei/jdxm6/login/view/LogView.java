package test.bawei.jdxm6.login.view;

import test.bawei.jdxm6.bean.LoginBean;

/**
 * Created by 大白 on 2017/11/1.
 */

public interface LogView {

    void onLogMobile();
    void onLogPwd();
    void onSuccess(LoginBean bean);
    void onFial();

}
