package test.bawei.jdxm6.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import test.bawei.jdxm6.R;
import test.bawei.jdxm6.bean.DingList;

/**
 * Created by 索园 on 2017/11/16.
 */

public class DingAdapter extends RecyclerView.Adapter<DingAdapter.MyViewHolder> {
    private List<DingList.DataBean> list;
    private Context context;

    public DingAdapter(List<DingList.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dinglist, parent, false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
         holder.ding_title.setText(list.get(position).getOrderid()+"");
         holder.ding_price.setText(list.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView ding_price;
        private final TextView ding_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            ding_price = itemView.findViewById(R.id.ding_price);
            ding_title = itemView.findViewById(R.id.ding_title);
        }
    }
}
