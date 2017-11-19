package test.bawei.jdxm6.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import test.bawei.jdxm6.R;
import test.bawei.jdxm6.activity.DingdanActivity;
import test.bawei.jdxm6.bean.carBean;
import test.bawei.jdxm6.car.presenter.CarPresenter;
import test.bawei.jdxm6.car.presenter.CarPresenterSx;
import test.bawei.jdxm6.car.view.CarView;
import test.bawei.jdxm6.util.Api;


/**
 * Created by 索园 on 2017/11/13.
 */

public class GouFragment extends Fragment implements View.OnClickListener {

    private ExpandableListView ex;

    private List<carBean.DataBean> data;
    private String uid;
    private String token;
    private CheckBox cb_all;
    private Exadapter exadapter;
    private TextView shop_allmoney;
    private TextView shop_count;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gou_item, null);
        ex = view.findViewById(R.id.ex);
        //String uid=getActivity().getSharedPreferences()
        shop_allmoney = view.findViewById(R.id.shop_allmoney);
        shop_count = view.findViewById(R.id.shop_count);
        shop_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), DingdanActivity.class);
                intent.putExtra("price",shop_allmoney.getText().toString());
                startActivity(intent);
            }
        });
        cb_all = view.findViewById(R.id.check_all);
        cb_all.setOnClickListener(this);
        SharedPreferences name = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        uid = name.getString("uid", null);
        token = name.getString("token", null);

        /*new Thread(){
            @Override
            public void run() {*/

                Map<String,String> map=new HashMap<>();
                map.put("uid", uid);
                map.put("token", token);
                OkHttp3Utils.doPost(Api.api_getcar, map, new GsonObjectCallback<carBean>() {

                    @Override
                    public void onUi(carBean bean) {
                        //得到请求过的bean对象
                        data = bean.getData();
                        exadapter = new Exadapter(getActivity());
                        ex.setAdapter(exadapter);
                        for (int i = 0; i < data.size(); i++) {
                            ex.expandGroup(i);
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });
          //  }
       // }.start();
        /*CarPresenter carPresenter=new CarPresenterSx(this);
        carPresenter.passData(uid,);*/
        return view;
    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < data.size(); i++) {
            data.get(i).setGroupSelected(cb_all.isChecked());
            for (int j = 0; j < data.get(i).getList().size(); j++) {
                data.get(i).getList().get(j).setChildSelected(cb_all.isChecked());
            }
        }
         exadapter.MoneyAllAndCountAll();
        exadapter.notifyDataSetChanged();
    }

 /*   @Override
    public void showData(carBean bean) {
        group = bean.getData();

    }*/

    //适配器
    class Exadapter extends BaseExpandableListAdapter{
        private Context context;
        private CheckBox group_check;
        private CheckBox child_check;

        public Exadapter(Context context) {
            this.context = context;
        }

        @Override
        public int getGroupCount() {
            return data.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return data.get(groupPosition).getList().size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return data.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return data.get(groupPosition).getList().get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView = LayoutInflater.from(context).inflate(R.layout.group, null);
            }
            TextView group_name = convertView.findViewById(R.id.group_name);
            group_name.setText(data.get(groupPosition).getSellerName());


            //父级CheckBox
            group_check = convertView.findViewById(R.id.group_check);
            group_check.setChecked(data.get(groupPosition).getGroupSelected());
            group_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (data.get(groupPosition).getGroupSelected()){
                        data.get(groupPosition).setGroupSelected(false);
                        cb_all.setChecked(false);
                        for (int i=0;i<data.get(groupPosition).getList().size();i++){
                            data.get(groupPosition).getList().get(i).setChildSelected(false);
                        }
                    }else {
                        int GroupSum=0;
                        data.get(groupPosition).setGroupSelected(true);
                        for (int i=0;i<data.get(groupPosition).getList().size();i++){
                            data.get(groupPosition).getList().get(i).setChildSelected(true);
                        }
                        for (int j = 0; j < data.size(); j++) {
                            if (data.get(j).getGroupSelected()){
                                GroupSum++;
                            }
                            if (GroupSum==data.size()){
                                cb_all.setChecked(true);
                            }
                        }
                        MoneyAllAndCountAll();
                        notifyDataSetChanged();
                    }
                }
            });
            return convertView;
        }

        @Override
        public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView=  LayoutInflater.from(context).inflate(R.layout.zi,null);
            }
            ImageView child_img = convertView.findViewById(R.id.child_img);
            TextView chidl_price = convertView.findViewById(R.id.chidl_price);
            TextView chidl_title = convertView.findViewById(R.id.chidl_title);

            chidl_price.setText(data.get(groupPosition).getList().get(childPosition).getPrice()+"");
            Picasso.with(context).load(data.get(groupPosition).getList().get(childPosition)
            .getImages()).placeholder(R.mipmap.yue).into(child_img);
            chidl_title.setText(data.get(groupPosition).getList().get(childPosition)
            .getTitle());


            //子级checkbox
            child_check = convertView.findViewById(R.id.child_check);
            child_check.setChecked(data.get(groupPosition).getList().get(childPosition).getChildSelected());
            child_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (data.get(groupPosition).getList().get(childPosition).getChildSelected()){
                        data.get(groupPosition).getList().get(childPosition).setChildSelected(false);
                        cb_all.setChecked(false);
                        data.get(groupPosition).setGroupSelected(false);
                    }else {
                        int childSum=0;
                        int groupSum=0;
                        data.get(groupPosition).getList().get(childPosition).setChildSelected(true);
                        for (int i = 0; i < data.get(groupPosition).getList().size(); i++) {
                            if (data.get(groupPosition).getList().get(i).getChildSelected()){
                                  childSum++;
                            }
                        }
                        if (data.get(groupPosition).getList().size()==childSum){
                            data.get(groupPosition).setGroupSelected(true);
                        }
                        for (int j = 0; j < data.size(); j++) {
                            if (data.get(groupPosition).getGroupSelected()){
                                groupSum++;
                            }
                        }
                        if (data.size()==groupSum){
                            cb_all.setChecked(true);
                        }
                    }
                    MoneyAllAndCountAll();
                    notifyDataSetChanged();
                }
            });
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
        public void MoneyAllAndCountAll(){
            int sum=0;
            double money=0;
            for(carBean.DataBean dataBean:data){
                for (carBean.DataBean.ListBean listBean:dataBean.getList()){
                    if (listBean.getChildSelected()){
                        sum+=Integer.parseInt(listBean.getNum()+"");
                        double aDouble = Double.parseDouble(listBean.getPrice() + "");
                        money+=aDouble;
                    }
                }
            }
            shop_allmoney.setText(money+"");
            shop_count.setText(sum+"");
        }

    }


}
