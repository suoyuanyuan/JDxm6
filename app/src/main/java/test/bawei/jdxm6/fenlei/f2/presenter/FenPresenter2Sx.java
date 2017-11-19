package test.bawei.jdxm6.fenlei.f2.presenter;

import test.bawei.jdxm6.bean.Fen2Bean;
import test.bawei.jdxm6.fenlei.f2.FenFinishListener2;
import test.bawei.jdxm6.fenlei.f2.model.FenModel2;
import test.bawei.jdxm6.fenlei.f2.model.FenModel2Sx;
import test.bawei.jdxm6.fenlei.f2.view.FenView2;

/**
 * Created by 索园 on 2017/11/14.
 */

public class FenPresenter2Sx implements FenPresenter2,FenFinishListener2{
    private FenView2 fenView2;
    private final FenModel2 fenModel2;

    public FenPresenter2Sx(FenView2 fenView2) {
        this.fenView2 = fenView2;
        fenModel2=new FenModel2Sx();
    }

    @Override
    public void passData(String cid) {
       fenModel2.getData(this,cid);
    }

    @Override
    public void Success(Fen2Bean bean, String cid) {
        fenView2.showData(bean);
    }
}
