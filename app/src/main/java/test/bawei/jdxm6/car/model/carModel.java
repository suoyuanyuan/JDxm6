package test.bawei.jdxm6.car.model;

import test.bawei.jdxm6.car.CarFinishListener;

/**
 * Created by 索园 on 2017/11/15.
 */

public interface carModel {
    void getData(String  uid ,String token ,CarFinishListener listener);
}
