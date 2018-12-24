package com.example.elite.mcpc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

public class Fragment_sub2 extends Fragment {
    private static final String TAG = "Fragment_sub2";
    public int Imgid;
    Button btn1;
    RatingBar rb;
    ImageView imv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.activity_fragment_sub2,container,false);
        Log.d(TAG,"Fragment_sub2 실행");


        imv = (ImageView)rootView.findViewById(R.id.sub2_restImg);
        imv.setImageResource(Imgid);
        rb = (RatingBar)rootView.findViewById(R.id.ratingBar1);
        btn1 = (Button)rootView.findViewById(R.id.f_sub2_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"선택한 별점: "+String.valueOf(rb.getRating()));
                Toast.makeText(getContext(),String.valueOf(rb.getRating()) + "등록했습니다.!!",Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }
}

