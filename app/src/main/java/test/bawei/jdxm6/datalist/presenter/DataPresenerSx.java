package test.bawei.jdxm6.datalist.presenter;

import test.bawei.jdxm6.bean.FenBeanList;
import test.bawei.jdxm6.datalist.DataFinishListener;
import test.bawei.jdxm6.datalist.model.DataModel;
import test.bawei.jdxm6.datalist.model.DataModelSx;
import test.bawei.jdxm6.datalist.view.DataShow;

/**
 * Created by 索园 on 2017/11/14.
 */

public class DataPresenerSx implements DataPresener,DataFinishListener {
    private DataShow dataShow;
    private final DataModel dataModel;
    public DataPresenerSx(DataShow dataShow) {
        this.dataShow = dataShow;
        dataModel=new DataModelSx();
    }

    @Override
    public void passData(String pscid) {
        dataModel.getData(this,pscid);
    }

    @Override
    public void Success(FenBeanList beanList) {
         dataShow.showData(beanList);
    }
}
