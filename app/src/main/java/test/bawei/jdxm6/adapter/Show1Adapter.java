package test.bawei.jdxm6.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import test.bawei.jdxm6.R;
import test.bawei.jdxm6.bean.FenBean;


/**
 * Created by 大白 on 2017/11/2.
 */

public class Show1Adapter extends RecyclerView.Adapter<Show1Adapter.MyViewHolder> {


    private List<FenBean.DataBean> list;
    private Context context;
    private MyViewHolder holder;

    public Show1Adapter(List<FenBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.fen1_item, parent, false);
        holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Picasso.with(context).load(list.get(position).getIcon()).into(holder.img_fen1);
        holder.tv_fen1.setText(list.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_fen1;
        private final ImageView img_fen1;

        public MyViewHolder(View itemView) {
            super(itemView);

            img_fen1 = itemView.findViewById(R.id.img_fen1);
            tv_fen1 = itemView.findViewById(R.id.tv_fen1);
        }
    }



}
