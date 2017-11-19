package test.bawei.jdxm6.registr.model;

import android.content.Context;

/**
 * Created by 索园 on 2017/11/13.
 */

public interface RegModel {
    void  regLogin(Context context, String regmobile, String regwd);
    void  regRequest(Context context,String regmobile,String regwd);
}
