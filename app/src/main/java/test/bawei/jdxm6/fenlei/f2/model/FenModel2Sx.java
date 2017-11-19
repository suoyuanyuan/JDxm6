package test.bawei.jdxm6.fenlei.f2.model;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;

import okhttp3.Call;
import test.bawei.jdxm6.util.Api;
import test.bawei.jdxm6.bean.Fen2Bean;
import test.bawei.jdxm6.fenlei.f2.FenFinishListener2;

/**
 * Created by 索园 on 2017/11/14.
 */

public class FenModel2Sx implements FenModel2 {
    @Override
    public void getData(final FenFinishListener2 listener2, final String cid) {
        OkHttp3Utils.doGet(Api.Api_fen2 + "?cid" + cid, new GsonObjectCallback<Fen2Bean>() {
            @Override
            public void onUi(Fen2Bean bean) {
                listener2.Success(bean,cid);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
