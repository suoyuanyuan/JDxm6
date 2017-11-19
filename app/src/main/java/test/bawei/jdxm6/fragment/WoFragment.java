package test.bawei.jdxm6.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import test.bawei.jdxm6.R;
import test.bawei.jdxm6.activity.LoginActivity;
import test.bawei.jdxm6.activity.PersonActivity;


/**
 * Created by 索园 on 2017/11/13.
 */

public class WoFragment extends Fragment {

    private ImageView img_login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wo_item, null);
        img_login = view.findViewById(R.id.img_login);
        img_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        ImageView set = view.findViewById(R.id.set);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), PersonActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
