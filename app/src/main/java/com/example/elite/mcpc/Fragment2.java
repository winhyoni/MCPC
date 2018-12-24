package com.example.elite.mcpc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Fragment2 extends Fragment {
    private static final String TAG = "Fragment2";
    private MyCustomAdapter dataAdapter = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.fragment2,container,false);

        return rootView;
    }

    public void onStart(){
        super.onStart();
        Log.d("Fragment2","Fragment2 호출");

        ArrayList<restaurant> resList = new ArrayList<restaurant>();

        restaurant res = new restaurant(R.drawable.pizz,"피자 알볼로", "★★★★☆",37.503367,127.042683,9);
        int distanceMeter = distance(37.504198, 127.047967, res.getX(), res.getY());
        res.setDistance(distanceMeter);
        resList.add(res);
        res = new restaurant(R.drawable.mac,"맥도날드", "★★☆☆☆",37.504697,127.041922,7);
        distanceMeter = distance(37.504198, 127.047967, res.getX(), res.getY());
        res.setDistance(distanceMeter);
        resList.add(res);
        res = new restaurant(R.drawable.chicken,"또래오래", "★★★★☆",37.504382,127.042072,4);
        distanceMeter = distance(37.504198, 127.047967, res.getX(), res.getY());
        res.setDistance(distanceMeter);
        resList.add(res);
        res = new restaurant(R.drawable.kim,"김밥천국", "★★☆☆☆",37.503776,127.042372,10);
        distanceMeter = distance(37.504198, 127.047967, res.getX(), res.getY());
        res.setDistance(distanceMeter);
        resList.add(res);
        res = new restaurant(R.drawable.hosigi,"호식이 두마리", "★★★☆☆",37.504057,127.042243,6);
        distanceMeter = distance(37.504198, 127.047967, res.getX(), res.getY());
        res.setDistance(distanceMeter);
        resList.add(res);

        res = new restaurant(R.drawable.doimno,"도미노피자", "★★★☆☆",37.504944,127.041797,5);
        distanceMeter = distance(37.504198, 127.047967, res.getX(), res.getY());
        res.setDistance(distanceMeter);
        resList.add(res);
        res = new restaurant(R.drawable.newword,"새마을식당", "★★★★☆",37.505039,127.041739,8);
        distanceMeter = distance(37.504198, 127.047967, res.getX(), res.getY());
        res.setDistance(distanceMeter);
        resList.add(res);
        res = new restaurant(R.drawable.seoga,"서가엔쿡", "★★★★☆",37.505533,127.041558,1);
        distanceMeter = distance(37.504198, 127.047967, res.getX(), res.getY());
        res.setDistance(distanceMeter);
        resList.add(res);
        res = new restaurant(R.drawable.br,"베스킨라빈스", "★★★★☆", 37.505839,127.041374, 2);
        distanceMeter = distance(37.504198, 127.047967, res.getX(), res.getY());
        res.setDistance(distanceMeter);
        resList.add(res);
        res = new restaurant(R.drawable.burger,"버거킹", "★★★★★",37.506039,127.041240, 3);
        distanceMeter = distance(37.504198, 127.047967, res.getX(), res.getY());
        res.setDistance(distanceMeter);
        resList.add(res);

        int index, temp;
        for(int x = 0; x<resList.size(); x++){
            index = x;
            for(int y = x+1;y<resList.size();y++){
                if(resList.get(y).getDistance() < resList.get(index).getDistance()){
                    index = y;
                }
            }
            temp = resList.get(index).getDistance();
            resList.get(index).setDistance(resList.get(x).getDistance());
            resList.get(x).setDistance(temp);
        }

        dataAdapter = new MyCustomAdapter(getActivity(), R.layout.restaurant_list, resList);
        ListView listView = (ListView)getActivity().findViewById(R.id.fragment2_listview);
        //Assign adapter to ListView
        listView.setAdapter(dataAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // When clicked, show a toast with the TextView text
                restaurant res = (restaurant) parent.getItemAtPosition(position);
                Log.d(TAG,"BNO+"+res.getBno()+"\nName: "+res.getName()+", star: "+res.getStar()+", dis: "+res.getDistance());
                Intent intent1 = new Intent(getContext(),SubActivity.class);
                intent1.putExtra("BNO",String.valueOf(res.getBno()));
                intent1.putExtra("TITLE",res.getName());
                intent1.putExtra("IMG",String.valueOf(res.getImg()));
                startActivity(intent1);
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
            ImageView img;
            TextView name;
            TextView star;
            TextView dis;
            TextView bno;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Fragment2.MyCustomAdapter.ViewHolder1 holder = null;
            if(convertView ==null){
                LayoutInflater vi = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.restaurant_list, null);

                holder = new Fragment2.MyCustomAdapter.ViewHolder1();
                holder.img = (ImageView)convertView.findViewById(R.id.restaurant_img);
                holder.name = (TextView)convertView.findViewById(R.id.restaurant_name);
                holder.star = (TextView)convertView.findViewById(R.id.restaurant_star);
                holder.dis = (TextView)convertView.findViewById(R.id.restaurant_distance);
                holder.bno = (TextView)convertView.findViewById(R.id.restaurant_bno);
                convertView.setTag(holder);

            }
            else{
                holder = (Fragment2.MyCustomAdapter.ViewHolder1) convertView.getTag();
            }
            restaurant res = resArrayList.get(position);
            holder.img.setImageResource(res.getImg());
            holder.bno.setText(Integer.toString(res.getBno()));
            holder.name.setText(res.getName());
            holder.star.setText(res.getStar());
            holder.dis.setText(Integer.toString(res.getDistance())+"M");

            holder.dis.setTag(res);

            return convertView;
        }
    }

    private static int distance(double lat1, double lon1, double lat2, double lon2) {

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1609.344;

        int result = (int)dist;
        return result;
    }


    // This function converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    // This function converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}

