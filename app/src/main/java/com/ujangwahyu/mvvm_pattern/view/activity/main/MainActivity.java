package com.ujangwahyu.mvvm_pattern.view.activity.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import com.ujangwahyu.mvvm_pattern.BR;
import com.ujangwahyu.mvvm_pattern.R;
import com.ujangwahyu.mvvm_pattern.base.BaseActivity;
import com.ujangwahyu.mvvm_pattern.databinding.ActivityMainBinding;
import com.ujangwahyu.mvvm_pattern.view.adapter.main.MainAdapter;
import com.ujangwahyu.mvvm_pattern.viewmodel.main.MainView;
import com.ujangwahyu.mvvm_pattern.viewmodel.main.MainViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainView {

    private MainAdapter mainAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public int getBindingVariable() {
        return BR.vm_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setElevation(0);
        initData();
        initViews();
    }

    public void initData() {
        mainAdapter = new MainAdapter(this, getSupportFragmentManager());
    }

    public void initViews() {
        dataBinding.viewPager.setAdapter(mainAdapter);
        dataBinding.tabs.setupWithViewPager(dataBinding.viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void showMessage(String msg) {

    }
}
