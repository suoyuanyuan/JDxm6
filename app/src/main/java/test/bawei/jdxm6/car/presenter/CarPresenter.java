package test.bawei.jdxm6.car.presenter;

import test.bawei.jdxm6.car.CarFinishListener;

/**
 * Created by 索园 on 2017/11/15.
 */

public interface CarPresenter {
    void passData(String  uid ,String token ,CarFinishListener listener);
}
