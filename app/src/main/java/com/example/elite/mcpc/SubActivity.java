package com.example.elite.mcpc;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class SubActivity extends AppCompatActivity {
    Toolbar toolbar;

    Fragment_sub1 fragmentsub1;
    Fragment_sub2 fragmentsub2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        fragmentsub1 = new Fragment_sub1();
        fragmentsub2 = new Fragment_sub2();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentsub1).commit();

        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("별점 순"));
        tabs.addTab(tabs.newTab().setText("거리 순"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int postion = tab.getPosition();
                Log.d("SubActivity"," 선택된 탭 : "+postion);

                Fragment selected = null;

                if(postion ==0 ){
                    selected = fragmentsub1;
                }
                else if(postion == 1){
                    selected = fragmentsub2;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
