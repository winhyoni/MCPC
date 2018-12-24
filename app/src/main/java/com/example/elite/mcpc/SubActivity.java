package com.example.elite.mcpc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    private static final String TAG = "SubActivity";
    Toolbar toolbar;

    Fragment_sub1 fragmentsub1;
    Fragment_sub2 fragmentsub2;

    private TextView mTexttitle;
    private String resBNO;
    private String resTITLE;
    private int IMG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Log.d(TAG, "SubActivity 실행");

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        Intent intent = getIntent();
        resBNO = intent.getStringExtra("BNO");
        resTITLE = intent.getStringExtra("TITLE");
        IMG = Integer.parseInt(intent.getStringExtra("IMG"));

        mTexttitle = (TextView)findViewById(R.id.subtitleText);
        mTexttitle.setText(resTITLE);

        fragmentsub1 = new Fragment_sub1();
        fragmentsub2 = new Fragment_sub2();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentsub1).commit();
        fragmentsub1.resNAME = resTITLE;
        fragmentsub1.BNO = Integer.parseInt(resBNO);
        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("상세 보기"));
        tabs.addTab(tabs.newTab().setText("평가 하기"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int postion = tab.getPosition();
                Log.d("SubActivity"," 선택된 탭 : "+postion);

                Fragment selected = null;

                if(postion ==0 ){
                    Log.d(TAG,"SUB BNO: "+resBNO);
                    fragmentsub1.resNAME = resTITLE;
                    fragmentsub1.BNO = Integer.parseInt(resBNO);
                    selected = fragmentsub1;
                }
                else if(postion == 1){
                    fragmentsub2.Imgid = IMG;
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
