package test.bawei.jdxm6.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import test.bawei.jdxm6.R;
import test.bawei.jdxm6.adapter.ShowAdapter;


/**
 * Created by 索园 on 2017/11/13.
 */

public class ShouFragment extends Fragment {

    private View view;
    private RecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shou_item, null);
        initView();
        return view;
    }

    private void initView() {
        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        ShowAdapter adapter=new ShowAdapter(getActivity());
        recycler.setAdapter(adapter);
        ImageView img_find = view.findViewById(R.id.img_find);
    }
}
