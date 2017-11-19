package test.bawei.jdxm6.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import test.bawei.jdxm6.R;
import test.bawei.jdxm6.bean.LoginBean;
import test.bawei.jdxm6.login.presenter.LogPresenter;
import test.bawei.jdxm6.login.presenter.LogPresenterSx;
import test.bawei.jdxm6.login.view.LogView;

public class Login2Activity extends BaseActivity implements LogView{

    private LogPresenter logPresenter;
    private EditText et_mobile;
    private EditText et_pwd;
    private Button bt_commit;
    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        et_mobile = (EditText) findViewById(R.id.et_mobile);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        bt_commit = (Button) findViewById(R.id.bt_commit);
        logPresenter = new LogPresenterSx(this);
        bt_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logPresenter.getData(Login2Activity.this, et_mobile.getText().toString(), et_pwd.getText().toString());
            }
        });
    }

    @Override
    public void onLogMobile() {
        et_mobile.setError("手机号不能为空");
    }

    @Override
    public void onLogPwd() {
           et_pwd.setError("密码不能为空");
    }

    @Override
    public void onSuccess(LoginBean bean) {
        String s=bean.getMsg();
        int i=bean.getData().getUid();
        String uid=i+"";
        String token = bean.getData().getToken();

        preferences = getSharedPreferences("name", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("uid",uid);
        editor.putString("token",token);
        //System.out.println(token+"==============");
        //editor.putString("createtime",createtime);
        editor.commit();
        Toast.makeText(Login2Activity.this,s, Toast.LENGTH_SHORT).show();
        // Api.edit.putBoolean("isLogin",true).commit();
        setResult(2);
        finish();
       /* Toast.makeText(Login2Activity.this,"登录成功",Toast.LENGTH_SHORT).show();
        Api.edit.putBoolean("isLogin",true).commit();
        setResult(2);
        finish();*/
    }

    @Override
    public void onFial() {
        Toast.makeText(Login2Activity.this,"登录失败",Toast.LENGTH_SHORT).show();
    }
}
