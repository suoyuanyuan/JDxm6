package test.bawei.jdxm6.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import test.bawei.jdxm6.R;
import test.bawei.jdxm6.registr.presenter.RegPresenter;
import test.bawei.jdxm6.registr.presenter.RegPresenterSx;
import test.bawei.jdxm6.registr.view.RegView;

public class RegisterActivity extends BaseActivity implements RegView {

    private EditText et_regMobile;
    private EditText et_regPwd;
    private RegPresenter regPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_regMobile = (EditText) findViewById(R.id.et_regMobile);
        et_regPwd = (EditText) findViewById(R.id.et_regPwd);
        Button bt_regCommit = (Button) findViewById(R.id.bt_regCommit);
        regPresenter = new RegPresenterSx(this);
        bt_regCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regPresenter.getData(RegisterActivity.this, et_regMobile.getText().toString(), et_regPwd.getText().toString());
            }
        });
    }

    @Override
    public void onRegModile() {
        et_regMobile.setError("手机号不能为空");
    }

    @Override
    public void onRegPwd() {
       et_regPwd.setError("密码不能为空");
    }

    @Override
    public void onSuccess() {
        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFail() {
        Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
    }
}
