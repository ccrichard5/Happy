package company.com.happy.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import company.com.happy.R;
import company.com.happy.config.Constant;
import company.com.happy.util.SPUtil;

public class SplashActivity extends Activity {


    SPUtil spUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        spUtil=new SPUtil(this);
        //界面停留几秒钟
        //是否第一次使用进行相应的界面跳转
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //读取偏好设置中的值
                //根据是否第一次进行
                Intent intent;
                if (spUtil.isFirst()){
                    //新手知道页跳转
                    intent = new Intent(SplashActivity.this,GuideActivity.class);
                   spUtil.setFirst(false);
                }else{
                    //向主页面跳转
                    intent = new Intent(SplashActivity.this,MainActivity.class);


                }
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
