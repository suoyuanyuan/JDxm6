package test.bawei.jdxm6.fenlei.f1.model;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.bawei.jdxm6.util.Api;
import test.bawei.jdxm6.util.ApiService;
import test.bawei.jdxm6.bean.FenBean;
import test.bawei.jdxm6.fenlei.f1.FenFinishListener1;

/**
 * Created by 索园 on 2017/11/14.
 */

public class FenModel1Sx implements FenModel {
    @Override
    public void getData(final FenFinishListener1 listener1) {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.api_f1).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<FenBean> observable = apiService.getFen1();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FenBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FenBean bean) {
             listener1.Success(bean);
                    }
                });
    }
}
