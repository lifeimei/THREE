package com.cch.mobileshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cch.mobileshop.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AdActivity extends AppCompatActivity {

    @BindView(R.id.tv_count)
    TextView tv_count;

    @BindView(R.id.iv_image)
    ImageView imageView;

    @BindView(R.id.rl_root)
    RelativeLayout relativeLayout;

    @BindString(R.string.app_name)
    String str;

    @BindColor(R.color.colorAccent)
    int col;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };


    @OnClick({R.id.tv_count, R.id.iv_image})
    public void startMainActivity(View view) {
        if(view.getId()==R.id.tv_count) {
            handler.removeCallbacks(task);
            Intent intent = new Intent(AdActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {

        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);

        ButterKnife.bind(this);


        ImageLoader.getInstance().displayImage("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574141635052&di=7fb8170cf7b4ccb60faef5bd2c222b38&imgtype=0&src=http%3A%2F%2Fpic18.nipic.com%2F20120204%2F4938944_155731011373_2.jpg",imageView);



        tv_count.setBackgroundColor(col);

        tv_count.setText(str);



        count = 5;
        handler.postDelayed(task, 1000);

    }

    int count = 5;
    Runnable task = new Runnable() {
        @Override
        public void run() {
            tv_count.setText("点击跳转 " + count);
            if (count > 0) {
                count--;
                handler.postDelayed(task, 1000);
            } else {
                Intent intent = new Intent(AdActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };


}
