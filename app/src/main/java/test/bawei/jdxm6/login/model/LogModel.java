package test.bawei.jdxm6.login.model;

import android.content.Context;

/**
 * Created by 大白 on 2017/11/1.
 */

public interface LogModel {

   void LogLogin(Context context, String logMobile, String logPwd);
   void LogRequest(Context context, String logMobile, String logPwd);

}
