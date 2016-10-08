package com.pan.qinzi.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pan.qinzi.myapplication.adapter.MyPagerAdapter;
import com.pan.qinzi.myapplication.fragment.CourseFragment;
import com.pan.qinzi.myapplication.fragment.HomeFragment;
import com.pan.qinzi.myapplication.fragment.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView jilu;
    private FrameLayout cehua;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    private String[] title={"首页","教程","排行榜"};
    private List<Fragment> fragmentList;
    private TabLayout tablayout;
    private LinearLayout cehua_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getData();
        viewPager.setAdapter(myPagerAdapter);
        tablayout.setupWithViewPager(viewPager);
    }

    private void getData() {
        fragmentList=new ArrayList<>();
        HomeFragment homeFragment=new HomeFragment();
        fragmentList.add(homeFragment);
        CourseFragment courseFragment=new CourseFragment();
        fragmentList.add(courseFragment);
        ListFragment listFragment=new ListFragment();
        fragmentList.add(listFragment);
        myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager(),fragmentList,title);
    }
    private MyPagerAdapter myPagerAdapter;
    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_mian);
        jilu = (TextView) findViewById(R.id.txt_jilu);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        cehua = (FrameLayout) findViewById(R.id.ll_cehuo);
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager_main);
        cehua_right = (LinearLayout) findViewById(R.id.cehua_right);
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        ViewGroup.LayoutParams rightParams = cehua_right.getLayoutParams();
        rightParams.width = metric.widthPixels;
        rightParams.height = metric.heightPixels;
        cehua_right.setLayoutParams(rightParams);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,cehua_right);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.txt_jilu:
                jilu.setTextColor(getResources().getColor(R.color.textfalse));
                jilu.setBackgroundColor(getResources().getColor(R.color.textture));
                drawerLayout.openDrawer(cehua_right);
                break;
            case R.id.imageView_cehua:
                drawerLayout.openDrawer(cehua);

                break;
            case R.id.imageView_sousuo:

                break;
            case R.id.button:
                jilu.setTextColor(getResources().getColor(R.color.textture));
                jilu.setBackgroundColor(getResources().getColor(R.color.textfalse));
                drawerLayout.closeDrawer(cehua_right);

                break;
        }
    }
}
