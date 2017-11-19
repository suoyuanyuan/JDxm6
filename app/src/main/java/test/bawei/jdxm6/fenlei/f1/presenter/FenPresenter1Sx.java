package test.bawei.jdxm6.fenlei.f1.presenter;

import test.bawei.jdxm6.bean.FenBean;
import test.bawei.jdxm6.fenlei.f1.FenFinishListener1;
import test.bawei.jdxm6.fenlei.f1.model.FenModel;
import test.bawei.jdxm6.fenlei.f1.model.FenModel1Sx;
import test.bawei.jdxm6.fenlei.f1.view.FenView1;

/**
 * Created by 索园 on 2017/11/14.
 */

public class FenPresenter1Sx implements FenPresenter1,FenFinishListener1 {
    private FenView1 fenView1;
    private final FenModel fenModel;
    public FenPresenter1Sx(FenView1 fenView1) {
        this.fenView1 = fenView1;
        fenModel=new FenModel1Sx();
    }

    @Override
    public void Success(FenBean bean) {
        fenView1.ShowData(bean);
    }

    @Override
    public void passData() {
         fenModel.getData(this);
    }
}
