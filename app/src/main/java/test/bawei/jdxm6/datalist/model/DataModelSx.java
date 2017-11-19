package test.bawei.jdxm6.datalist.model;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.bawei.jdxm6.util.Api;
import test.bawei.jdxm6.util.ApiService;
import test.bawei.jdxm6.bean.FenBeanList;
import test.bawei.jdxm6.datalist.DataFinishListener;

/**
 * Created by 索园 on 2017/11/14.
 */

public class DataModelSx implements DataModel{
    @Override
    public void getData(final DataFinishListener listener, String pscid) {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.api_list).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService=retrofit.create(ApiService.class);
        Observable<FenBeanList> observable = apiService.getBeanList(pscid);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FenBeanList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FenBeanList beanList) {
                        listener.Success(beanList);
                    }
                });
    }
}
