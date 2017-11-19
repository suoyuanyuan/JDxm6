package test.bawei.jdxm6.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;
import com.youth.banner.Banner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import test.bawei.jdxm6.util.Api;
import test.bawei.jdxm6.R;
import test.bawei.jdxm6.bean.FenBean;
import test.bawei.jdxm6.bean.ShowBean;
import test.bawei.jdxm6.util.MyImage;

/**
 * Created by 索园 on 2017/11/13.
 */

public class ShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static   final  int type1=0;
    private static   final  int type2=1;
    private static   final  int type3=2;
    private Banner banner;
    private Context context;

    public ShowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return type1;
        }else if (position==1){
            return type2;
        }else{
            return type3;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==type1){
            View view = LayoutInflater.from(context).inflate(R.layout.show1, parent, false);
            MyViewHolder1 myViewHolder1=new MyViewHolder1(view);
            return myViewHolder1;
        }else if (viewType==type2){
            View view = LayoutInflater.from(context).inflate(R.layout.show2, parent, false);
            MyViewHolder2 myViewHolder2=new MyViewHolder2(view);
            return myViewHolder2;
        }else if (viewType==type3){
            View view = LayoutInflater.from(context).inflate(R.layout.show3, parent, false);
            MyViewHolder3 myViewHolder3=new MyViewHolder3(view);
            return myViewHolder3;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type){
            case type1:
             getimage();
                break;
            case type2:
                if (holder instanceof MyViewHolder2){
                    ((MyViewHolder2) holder).show_recycler.setLayoutManager(new GridLayoutManager(context,5));
                    OkHttp3Utils.doGet(Api.Api_fen1, new GsonObjectCallback<FenBean>() {
                        @Override
                        public void onUi(FenBean bean) {
                            List<FenBean.DataBean> list1= bean.getData();
                            Show1Adapter adapter=new Show1Adapter(list1,context);
                            ((MyViewHolder2) holder).show_recycler.setAdapter(adapter);

                        }

                        @Override
                        public void onFailed(Call call, IOException e) {

                        }
                    });
                }
                break;
            case type3:
                if (holder instanceof MyViewHolder3){
                    ((MyViewHolder3) holder).show_recycler2.setLayoutManager(new GridLayoutManager(context,2));
                    OkHttp3Utils.doGet(Api.Api_show, new GsonObjectCallback<ShowBean>() {
                        @Override
                        public void onUi(ShowBean showBean) {
                            List<ShowBean.TuijianBean.ListBean> list=showBean.getTuijian().getList();
                            Show2Adapter adapter=new Show2Adapter(list,context);
                            ((MyViewHolder3) holder).show_recycler2.setAdapter(adapter);
                        }

                        @Override
                        public void onFailed(Call call, IOException e) {

                        }
                    });
                }
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
    class MyViewHolder1 extends RecyclerView.ViewHolder{



        public MyViewHolder1(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }
    private void getimage(){

        List<String> list = new ArrayList<String>();
        list.add("http://120.27.23.105//images//ad//0.jpg");
        list.add("http://120.27.23.105//images//ad//1.jpg");
        list.add("http://120.27.23.105//images//ad//2.jpg");
        list.add("http://120.27.23.105//images//ad//3.jpg");


        banner.setImageLoader(new MyImage());
        banner.setImages(list);
        banner.setDelayTime(3000);
        banner.start();
    }
    class MyViewHolder2 extends RecyclerView.ViewHolder {

        private final RecyclerView show_recycler;

        public MyViewHolder2(View itemView) {
            super(itemView);
            show_recycler = itemView.findViewById(R.id.show_recycler);
        }
    }
    class MyViewHolder3 extends RecyclerView.ViewHolder {

        private final RecyclerView show_recycler2;

        public MyViewHolder3(View itemView) {
            super(itemView);
            show_recycler2 = itemView.findViewById(R.id.show_recycler2);
        }
    }
}
