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
import test.bawei.jdxm6.bean.FenBeanList;

/**
 * Created by 索园 on 2017/11/14.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    private List<FenBeanList.DataBean> list;
    private Context context;

    public DataAdapter(List<FenBeanList.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.data, parent, false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       holder.data_price.setText(list.get(position).getPrice()+"");
        holder.data_title.setText(list.get(position).getTitle());
        Picasso.with(context).load(list.get(position).getImages())
                .placeholder(R.mipmap.yue)
                .into(holder.data_img);
        final FenBeanList.DataBean dataBean = list.get(position);
        holder.data_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    listener.onItemClick(dataBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView data_img;
        private final TextView data_price;
        private final TextView data_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            data_img = itemView.findViewById(R.id.img_data);
            data_price = itemView.findViewById(R.id.price_data);
            data_title = itemView.findViewById(R.id.title_data);
        }
    }
    //接口回调
    private OnItemClickListener listener;
    public interface OnItemClickListener{
        void onItemClick(FenBeanList.DataBean bean);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }
}
