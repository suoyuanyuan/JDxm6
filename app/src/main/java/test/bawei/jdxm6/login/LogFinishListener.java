package test.bawei.jdxm6.login;

import test.bawei.jdxm6.bean.LoginBean;

/**
 * Created by 索园 on 2017/11/13.
 */

public interface LogFinishListener {
    void LogMobile();
    void LogPwd();
    void Success(LoginBean bean);
    void Fail();
}
