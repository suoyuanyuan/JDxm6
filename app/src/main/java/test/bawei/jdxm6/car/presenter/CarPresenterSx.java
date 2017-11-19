package test.bawei.jdxm6.car.presenter;

import test.bawei.jdxm6.bean.carBean;
import test.bawei.jdxm6.car.CarFinishListener;
import test.bawei.jdxm6.car.model.CarModelSx;
import test.bawei.jdxm6.car.model.carModel;
import test.bawei.jdxm6.car.view.CarView;

/**
 * Created by 索园 on 2017/11/15.
 */

public class CarPresenterSx implements CarPresenter,CarFinishListener {
    private CarView carView;
    private final carModel carModel;
    public CarPresenterSx(CarView carView) {
        this.carView = carView;
        carModel=new CarModelSx();
    }

    @Override
    public void passData(String  uid ,String token ,CarFinishListener listener) {
        carModel.getData(uid,token,listener);
    }

    @Override
    public void Success(carBean bean) {
       carView.showData(bean);
    }
}
