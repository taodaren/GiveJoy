package com.atmhls.global;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.atmhls.givejoy.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private EditText editPhone, editInviteCode, editPhoneCode;
    private Button btnRegister, btnCancel, btnGetCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setToolbar();
        initView();
        setClickListener();
    }

    private void initView() {
        editPhone = (EditText) findViewById(R.id.edit_phone);
        editInviteCode = (EditText) findViewById(R.id.edit_invite_code);
        editPhoneCode = (EditText) findViewById(R.id.edit_phone_code);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnCancel = (Button) findViewById(R.id.btn_cancel_register);
        btnGetCode = (Button) findViewById(R.id.btn_get_code);
    }

    private void setClickListener() {
        //注册
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        //取消
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //获取验证码
        btnGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_register);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //设置左上角后退按钮
            actionBar.setDisplayHomeAsUpEnabled(true);
            //设置导航按钮图标
            actionBar.setHomeAsUpIndicator(R.drawable.back_title);
            //隐藏 Toolbar 自带标题栏
            actionBar.setDisplayShowTitleEnabled(false);
        }

        //设置标题
        TextView textTitle = (TextView) findViewById(R.id.title_toolbar);
        textTitle.setVisibility(View.VISIBLE);
        textTitle.setText("注册");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    public void register() {
//        Log.d(TAG, "Signup");

        if (!validate()) {
            onRegisterFailed();
            return;
        }

        btnRegister.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("创建帐户...");
        progressDialog.show();

        String phone = editPhone.getText().toString();
        String inviteCode = editInviteCode.getText().toString();
        String phoneCode = editPhoneCode.getText().toString();

        // TODO: 在这里实现你自己的注册逻辑

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        //完全调用 onRegisterSuccess 或 onRegisterFailed
                        //这里取决于成功
                        onRegisterSuccess();
                        // onRegisterFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    public void onRegisterSuccess() {
        btnRegister.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onRegisterFailed() {
        Toast.makeText(getBaseContext(), "登录失败", Toast.LENGTH_LONG).show();

        btnRegister.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String phone = editPhone.getText().toString();
//        String inviteCode = editInviteCode.getText().toString();
        String phoneCode = editPhoneCode.getText().toString();

        //判断手机号
        if (phone.isEmpty() || !(phone.length() == 11) || !(isMobileNO(phone))) {
            editPhone.setError("请输入一个有效的手机号");
            valid = false;
        } else {
            editPhone.setError(null);
        }

        //判断邀请码（可以不用邀请码登陆）
//        if (inviteCode.isEmpty() || !(inviteCode.length() == 6)) {
//            editInviteCode.setError("请输入6位邀请码");
//            valid = false;
//        } else {
//            editInviteCode.setError(null);
//        }

        //判断验证码
        if (phoneCode.isEmpty() || !(phoneCode.length() == 6)) {
            editPhoneCode.setError("请输入6位手机验证码");
            valid = false;
        } else {
            editPhoneCode.setError(null);
        }

        return valid;
    }

    //验证手机号是否为正确手机号
    public static boolean isMobileNO(String mobiles) {

        Pattern p = Pattern
                .compile("^(0|86|17951)?(13[0-9]|15[0-9]|17[0-9]|18[0-9]|14[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);

        return m.matches();
    }
}
