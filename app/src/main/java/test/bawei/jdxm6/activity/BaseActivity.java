package test.bawei.jdxm6.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import test.bawei.jdxm6.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
    }
}
