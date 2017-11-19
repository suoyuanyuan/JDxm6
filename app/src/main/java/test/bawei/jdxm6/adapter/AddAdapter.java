package test.bawei.jdxm6.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import test.bawei.jdxm6.R;
import test.bawei.jdxm6.bean.addList;

/**
 * Created by 索园 on 2017/11/17.
 */

public class AddAdapter extends RecyclerView.Adapter<AddAdapter.MyViewHolder>{
    private List<addList.DataBean> list;
    private Context context;

    public AddAdapter(List<addList.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adds, parent, false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.add_add.setText(list.get(position).getAddr());
        holder.add_mobile.setText(list.get(position).getMobile()+"");
        holder.add_name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView add_add;
        private final TextView add_name;
        private final TextView add_mobile;

        public MyViewHolder(View itemView) {
            super(itemView);
            add_add = itemView.findViewById(R.id.add_add);
            add_name = itemView.findViewById(R.id.add_name);
            add_mobile = itemView.findViewById(R.id.add_mobile);
        }
    }
}
