package vn.sunasterisk.buoi11_implicitintentandmenu.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        initComponents();
        registerListeners();
    }

    protected abstract void registerListeners();

    protected abstract void initComponents();

    protected abstract int getLayoutId();
}
