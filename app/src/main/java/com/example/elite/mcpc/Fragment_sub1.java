package com.example.elite.mcpc;

import android.content.Context;
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
import android.widget.Toast;

import java.util.ArrayList;


public class Fragment_sub1 extends Fragment {
    private static final String TAG = "Fragment_sub1";
    private MyCustomAdapter dataAdapter = null;

    public String resNAME;
    public int BNO;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.activity_fragment_sub1,container,false);
        Log.d(TAG,"Fragment_sub1 실행");

        return rootView;
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("Fragment1","Fragment1 호출");

        ArrayList<food> fodList = new ArrayList<food>();
        food fod;
        Log.d(TAG,"BNO: "+BNO);
        switch (BNO){
            case 1:
                fod = new food(R.drawable.segaandcookolio,"오일파스타","8000원");
                fodList.add(fod);
                fod = new food(R.drawable.segaandcookpasta,"로제파스타","8500원");
                fodList.add(fod);
                fod = new food(R.drawable.segaandcookstake,"스테이크","13000원");
                fodList.add(fod);
                break;
            case 2:
                fod = new food(R.drawable.besnew,"뉴욕치즈","3000원");
                fodList.add(fod);
                fod = new food(R.drawable.besbongbong,"아몬드봉봉","4000원");
                fodList.add(fod);
                fod = new food(R.drawable.besmather,"엄마는외계인","3000원");
                fodList.add(fod);
                break;
            case 3:
                fod = new food(R.drawable.burgerking_main,"3가지 세트","12000원");
                fodList.add(fod);
                fod = new food(R.drawable.monster_x_set,"몬스터 세트","9000원");
                fodList.add(fod);
                fod = new food(R.drawable.burgerking,"와퍼셋트","5000원");
                fodList.add(fod);
                break;
            case 4:
                fod = new food(R.drawable.ttolaeolaehoo,"오곡후라이드","17000원");
                fodList.add(fod);
                fod = new food(R.drawable.ttolaeolae_felf, "반반 치킨","1800원");
                fodList.add(fod);
                fod = new food(R.drawable.ttolaeolaeagoo,"간장 치킨","19000원");
                fodList.add(fod);
                break;
            case 5:
                fod = new food(R.drawable.dominoalroha,"알로피자","19500원");
                fodList.add(fod);
                fod = new food(R.drawable.dominocheese,"치즈피자","20000원");
                fodList.add(fod);
                fod = new food(R.drawable.dominowogu,"오곡피자","19000원");
                fodList.add(fod);
                break;
            case 6:
                fod = new food(R.drawable.hosikganjang,"간장치킨","17000원");
                fodList.add(fod);
                fod = new food(R.drawable.hosikhooraid,"후라이드","16000원");
                fodList.add(fod);
                fod = new food(R.drawable.hosikyangnum,"양념치킨","16500원");
                fodList.add(fod);
                break;
            case 7:
                fod = new food(R.drawable.macbigmak,"빅맥","5000원");
                fodList.add(fod);
                fod = new food(R.drawable.maccheesee,"치즈버거","3000원");
                fodList.add(fod);
                fod = new food(R.drawable.macshanghi,"슈림프버거","4500원");
                fodList.add(fod);
                break;
            case 8:
                fod = new food(R.drawable.newworldgogi3,"열탄불고기","8000원");
                fodList.add(fod);
                fod = new food(R.drawable.newworldgogi5,"목살","9000원");
                fodList.add(fod);
                fod = new food(R.drawable.newworldgogi6,"껍데기","5000원");
                fodList.add(fod);
                break;
            case 9:
                fod = new food(R.drawable.shrimpandhotchickengold,"쉬림프피자","19000원");
                fodList.add(fod);
                fod = new food(R.drawable.superdeluxecombinationpizza,"슈퍼피자","20000원");
                fodList.add(fod);
                fod = new food(R.drawable.sweetpotatogoldpizza,"스위트포테이토","18000원");
                fodList.add(fod);
                break;
            case 10:
                fod = new food(R.drawable.heavenkimbob,"김밥","2000원");
                fodList.add(fod);
                fod = new food(R.drawable.heavenpiggas,"돈까스","5000원");
                fodList.add(fod);
                fod = new food(R.drawable.heavenhotddug,"떡볶이","4000원");
                fodList.add(fod);
                break;
            default:   fod = new food("메뉴가 없습니다","");
                fodList.add(fod);
        }

        /*
        food fod = new food("메뉴 1","1000원");
        fodList.add(fod);
        fod = new food("메뉴 2","2000원");
        fodList.add(fod);
        fod = new food("메뉴 3","3000원");
        fodList.add(fod);
        fod = new food("메뉴 4","4000원");
        fodList.add(fod);
        fod = new food("메뉴 5","5000원");
        fodList.add(fod);
        */

        dataAdapter = new MyCustomAdapter(getActivity(), R.layout.food_list, fodList);
        ListView listView = (ListView)getActivity().findViewById(R.id.fragment_sub_listview);
        //Assign adapter to ListView
        listView.setAdapter(dataAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // When clicked, show a toast with the TextView text
                food fod = (food) parent.getItemAtPosition(position);
             //   Log.d(TAG,"BNO+"+res.getBno()+"\nName: "+res.getName()+", star: "+res.getStar()+", dis: "+res.getDistance());
                Toast.makeText(getContext(),"음식 메뉴: "+fod.getFoodname()+"음식 가격: "+fod.getFoodprice(),Toast.LENGTH_LONG).show();
            }
        });
    }


    private class MyCustomAdapter extends ArrayAdapter<food> {
        private ArrayList<food> foodArrayList;

        public MyCustomAdapter(Context context, int textViewResourceId, ArrayList<food> foodList) {
            super(context, textViewResourceId, foodList);
            this.foodArrayList = new ArrayList<food>();
            this.foodArrayList.addAll(foodList);
        }

        private class ViewHolder1 {
            ImageView img;
            TextView name;
            TextView price;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder1 holder = null;
            if(convertView ==null){
                LayoutInflater vi = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.food_list, null);

                holder = new ViewHolder1();
                holder.img = (ImageView)convertView.findViewById(R.id.food_img);
                holder.name = (TextView)convertView.findViewById(R.id.food_name);
                holder.price = (TextView)convertView.findViewById(R.id.food_price);
                convertView.setTag(holder);

            }
            else{
                holder = (ViewHolder1) convertView.getTag();
            }
            food fod = foodArrayList.get(position);
            holder.img.setImageResource(fod.getFoodimg());
            holder.name.setText(fod.getFoodname());
            holder.price.setText(fod.getFoodprice());

            holder.price.setTag(fod);

            return convertView;
        }
    }
}

