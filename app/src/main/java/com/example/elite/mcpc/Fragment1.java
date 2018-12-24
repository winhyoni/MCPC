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

public class Fragment1 extends Fragment {
    private static final String TAG = "Fragment1";
    private MyCustomAdapter dataAdapter = null;

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
        /*
        restaurant res = new restaurant("가게 1","1점","1km",1);
        resList.add(res);
        res = new restaurant("가게 2","2점","2km",2);
        resList.add(res);
        res = new restaurant("가게 3","3점","3km",3);
        resList.add(res);
        res = new restaurant("가게 4","4점","4km",4);
        resList.add(res);
        res = new restaurant("가게 5","5점","5km",5);
        resList.add(res);
        res = new restaurant("가게 6","6점","6km",6);
        resList.add(res);
        res = new restaurant("가게 7","7점","7km",7);
        resList.add(res);
        res = new restaurant("가게 8","8점","8km",8);
        resList.add(res);
        res = new restaurant("가게 9","9점","9km",9);
        resList.add(res);
*/

        restaurant res = new restaurant(R.drawable.seoga,"서가앤쿡", "★★★★★","331m",1); resList.add(res);
        res = new restaurant(R.drawable.burger,"버거킹", "★★★★★","20m",3); resList.add(res);
        res = new restaurant(R.drawable.br,"베스킨라빈스", "★★★★☆","200m",2); resList.add(res);
        res = new restaurant(R.drawable.newword,"새마을식당", "★★★★☆","420m",8); resList.add(res);
        res = new restaurant(R.drawable.pizz,"피자 알볼로", "★★★★☆","990m",9); resList.add(res);
        res = new restaurant(R.drawable.chicken,"또래오래", "★★★★☆","620m",4); resList.add(res);
        res = new restaurant(R.drawable.doimno,"도미노피자", "★★★☆☆","550m",5); resList.add(res);
        res = new restaurant(R.drawable.hosigi,"호식이 두마리", "★★★☆☆","780m",6); resList.add(res);
        res = new restaurant(R.drawable.mac,"맥도날드", "★★☆☆☆","600m",7); resList.add(res);
        res = new restaurant(R.drawable.kim,"김밥천국", "★★☆☆☆","950m",10); resList.add(res);


        dataAdapter = new MyCustomAdapter(getActivity(), R.layout.restaurant_list, resList);
        ListView listView = (ListView)getActivity().findViewById(R.id.fragment1_listview);
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
            ViewHolder1 holder = null;
            if(convertView ==null){
                LayoutInflater vi = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.restaurant_list, null);

                holder = new ViewHolder1();
                holder.img = (ImageView)convertView.findViewById(R.id.restaurant_img);
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
            holder.img.setImageResource(res.getImg());
            holder.bno.setText(Integer.toString(res.getBno()));
            holder.name.setText(res.getName());
            holder.star.setText(res.getStar());
            holder.dis.setText(res.getDistance());

            holder.dis.setTag(res);

            return convertView;
        }
    }


}
