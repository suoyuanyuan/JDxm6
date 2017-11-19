package test.bawei.jdxm6.util;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import test.bawei.jdxm6.bean.FenBean;
import test.bawei.jdxm6.bean.FenBeanList;

/**
 * Created by 索园 on 2017/11/14.
 */

public interface ApiService {
    //http://120.27.23.105/product/getCatagory
    @GET("getCatagory")
    Observable<FenBean> getFen1();
    //http://120.27.23.105/product/getProducts?pscid=1
    @GET("getProducts")
    Observable<FenBeanList> getBeanList(@Query("pscid") String pscid);

}
