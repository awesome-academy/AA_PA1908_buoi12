package vn.sunasterisk.buoi11_implicitintentandmenu.screen.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import vn.sunasterisk.buoi11_implicitintentandmenu.R;
import vn.sunasterisk.buoi11_implicitintentandmenu.base.BaseActivity;
import vn.sunasterisk.buoi11_implicitintentandmenu.screen.main.MainActivity;

public class SplashActivity extends BaseActivity {

    private static final long SPLASH_TIME_DELAY = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_DELAY);
    }

    @Override
    protected void registerListeners() {

    }

    @Override
    protected void initComponents() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }
}
