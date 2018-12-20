package com.example.elite.mcpc;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fragment1 extends Fragment {

    MyCustomAdapter dataAdapter = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.fragment1,container,false);
        Log.d("fragment1","프래그먼트 1 실행");

        return rootView;
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("Fragment1","Fragment1 호출");

        ArrayList<restaurant> resList = new ArrayList<restaurant>();
        restaurant res = new restaurant("가게 1","1점","1km",1);
        resList.add(res);
        res = new restaurant("가게 2","2점","2km",1);
        resList.add(res);
        res = new restaurant("가게 3","3점","3km",1);
        resList.add(res);
        res = new restaurant("가게 4","4점","4km",1);
        resList.add(res);
        res = new restaurant("가게 5","5점","5km",1);
        resList.add(res);
        res = new restaurant("가게 6","6점","6km",1);
        resList.add(res);
        res = new restaurant("가게 7","7점","7km",1);
        resList.add(res);
        res = new restaurant("가게 8","8점","8km",1);
        resList.add(res);
        res = new restaurant("가게 9","9점","9km",1);
        resList.add(res);

        dataAdapter = new MyCustomAdapter(getActivity(), R.layout.restaurant_list, resList);
        ListView listView = (ListView)getActivity().findViewById(R.id.fragment1_listview);
        //Assign adapter to ListView
        listView.setAdapter(dataAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // When clicked, show a toast with the TextView text
                restaurant res = (restaurant) parent.getItemAtPosition(position);
                Toast.makeText(getActivity(), "BNO+"+res.getBno()+"\nName: "+res.getName()+", star: "+res.getStar()+", dis: "+res.getDistance(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private class MyCustomAdapter extends ArrayAdapter<restaurant> {
        private ArrayList<restaurant> resArrayList;

        public MyCustomAdapter(Context context, int textViewResourceId, ArrayList<restaurant> resList) {
            super(context, textViewResourceId, resList);
            this.resArrayList = new ArrayList<restaurant>();
            this.resArrayList.addAll(resList);
        }

        private class ViewHolder1 {
          TextView name;
          TextView star;
          TextView dis;
          TextView bno;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder1 holder = null;
            if(convertView ==null){
                LayoutInflater vi = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.restaurant_list, null);

                holder = new ViewHolder1();
                holder.name = (TextView)convertView.findViewById(R.id.restaurant_name);
                holder.star = (TextView)convertView.findViewById(R.id.restaurant_star);
                holder.dis = (TextView)convertView.findViewById(R.id.restaurant_distance);
                holder.bno = (TextView)convertView.findViewById(R.id.restaurant_bno);
                convertView.setTag(holder);

            }
            else{
                holder = (ViewHolder1) convertView.getTag();
            }
            restaurant res = resArrayList.get(position);
            holder.bno.setText(Integer.toString(res.getBno()));
            holder.name.setText(res.getName());
            holder.star.setText(res.getStar());
            holder.dis.setText(res.getDistance());

            holder.dis.setTag(res);

            return convertView;
        }
    }


}
