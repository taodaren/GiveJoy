package com.atmhls.global;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.atmhls.givejoy.R;
import com.atmhls.global.bean.LoginBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int DEFAULT_TIMEOUT = 5;
    private static final int REQUEST_SIGNUP = 0;

    private static final int TYPE_SUCCESS = 0;
    private static final int TYPE_ERROR = 1;

    private static final String KEY_JSON = "key_json";
    private static final String KEY_ERROR = "key_json";

    private EditText editAccount, editPassword;
    private Button btnLogin, btnCancel;
    private ProgressDialog progressDialog;
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.arg1) {
                case TYPE_SUCCESS:
                    progressDialog.dismiss();
                    Bundle bundle1 = (Bundle) msg.obj;
                    String json = bundle1.getString(KEY_JSON);
                    parseJSONWithGSON(json);
                    break;
                case TYPE_ERROR:
                    Bundle bundle2 = (Bundle) msg.obj;
                    String errorMsg = bundle2.getString(KEY_ERROR);
                    onLoginFailed();
                    progressDialog.dismiss();
                    Log.e(TAG, "errorMsg:" + errorMsg);
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setToolbar();
        initView();
        setClickListener();
    }

    private void initView() {
        editAccount = (EditText) findViewById(R.id.edit_account);
        editPassword = (EditText) findViewById(R.id.edit_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
    }

    private void setClickListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_login);
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
        textTitle.setText("登陆");
    }

    /**
     * 创建选项菜单
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        //显示需要菜单项，隐藏多余菜单项
        menu.findItem(R.id.menu_qr_code).setVisible(false);
        menu.findItem(R.id.menu_star).setVisible(false);
        menu.findItem(R.id.menu_change).setVisible(false);
        menu.findItem(R.id.menu_more).setVisible(false);
        menu.findItem(R.id.menu_register).setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    public void login() {
//        Log.d(TAG, "Login");

        //如果没有验证成功，登录失败
        if (!validate()) {
            onLoginFailed();
            return;
        }

        btnLogin.setEnabled(false);

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("登录中...");
        progressDialog.show();

        String account = editAccount.getText().toString();
        String password = editPassword.getText().toString();

        //发送网络请求
        sendRequestWithOkHttp(account, password);

//        new android.os.Handler().postDelayed(
//                new Runnable() {
//                    public void run() {
//                        //完成调用 onLoginSuccess 或 onLoginFailed
//                        onLoginSuccess();
//                        // onLoginFailed();
//                        progressDialog.dismiss();
//                    }
//                }, 3000);
    }

    /**
     * 发送网络请求
     *
     * @param account  手机号
     * @param password 该手机号收到的验证码
     */
    private void sendRequestWithOkHttp(final String account, final String password) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient()
                            .newBuilder()
                            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .retryOnConnectionFailure(true)
                            .build();

                    RequestBody requestBody = new FormBody.Builder()
                            .add("phone", account)
                            .add("validCode", password)
                            .build();
                    Request request = new Request.Builder()
                            .url(I.URL_LOGIN)
                            .post(requestBody)
                            .build();

                    Log.e(TAG, "request: " + request);
                    Response response = client.newCall(request).execute();

                    //判断请求数据
                    if (response.isSuccessful()) {
                        Log.e(TAG, "请求数据成功: " + response.body().string());
                        Message message = Message.obtain();
                        message.arg1 = TYPE_SUCCESS;
                        Bundle bundle = new Bundle();
                        bundle.putString(KEY_JSON, response.body().string());
                        message.obj = bundle;
                        handler.sendMessage(message);
                    } else {
                        throw new IOException(response.message());
                    }
                } catch (Exception e) {
                    Message message = Message.obtain();
                    message.arg1 = TYPE_ERROR;
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_ERROR, e.getMessage());
                    message.obj = bundle;
                    handler.sendMessage(message);
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        List<LoginBean> beanList = gson.fromJson(jsonData,
                new TypeToken<List<LoginBean>>() {
                }.getType());
        for (LoginBean loginBean : beanList) {
            Log.e(TAG, "parseJSONWithGSON: phone is " + loginBean.getPhone());
            Log.e(TAG, "parseJSONWithGSON: validCode is " + loginBean.getValidCode());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: 在这里实现成功的注册逻辑
                //默认情况下，我们刚刚完成活动并自动登录
                this.finish();
            }
        }
    }

//    @Override
//    public void onBackPressed() {
//        //禁用返回到MainActivity
//        moveTaskToBack(true);
//    }

    public void onLoginSuccess() {
        btnLogin.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "登录失败", Toast.LENGTH_LONG).show();
        btnLogin.setEnabled(true);
    }

    /**
     * 验证用户信息
     *
     * @return 验证结果
     */
    public boolean validate() {
        //是否有效
        boolean valid = true;

        String account = editAccount.getText().toString();
        String password = editPassword.getText().toString();

        //判断手机号
        if (account.isEmpty() || !(account.length() == 11) || !(isMobileNO(account))) {
            editAccount.setError("请输入一个有效的手机号");
            valid = false;
        } else {
            editAccount.setError(null);
        }

        //判断密码
        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            editPassword.setError("4到10个字母、数字或字符");
            valid = false;
        } else {
            editPassword.setError(null);
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
