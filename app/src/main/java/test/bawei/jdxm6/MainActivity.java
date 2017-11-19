package test.bawei.jdxm6;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import test.bawei.jdxm6.activity.BaseActivity;
import test.bawei.jdxm6.fragment.Fen2Fragment;
import test.bawei.jdxm6.fragment.GouFragment;
import test.bawei.jdxm6.fragment.ShouFragment;
import test.bawei.jdxm6.fragment.WoFragment;

public class MainActivity extends BaseActivity {

    private ViewPager vp;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment=null;
                switch (position){
                    case 0:
                        fragment=new ShouFragment();
                        break;
                    case 1:
                        fragment=new Fen2Fragment();
                        break;
                    case 2:
                        fragment=new GouFragment();
                        break;
                    case 3:
                        fragment=new WoFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.bt1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.bt5:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.bt3:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.bt4:
                        vp.setCurrentItem(3);
                        break;
                }
            }
        });
    }
}
