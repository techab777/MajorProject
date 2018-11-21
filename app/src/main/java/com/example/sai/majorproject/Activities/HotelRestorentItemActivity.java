package com.example.sai.majorproject.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.sai.majorproject.Adapter.HotelRestorentRecyclerAdapter;
import com.example.sai.majorproject.DataModel.HotelAndRestorentMaster;
import com.example.sai.majorproject.R;

import java.util.ArrayList;

public class HotelRestorentItemActivity extends AppCompatActivity {
    TextView txt_hotel_name;
    RecyclerView rv_hotel_item;
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotelrestorent_recycle_item_layout);

        txt_hotel_name=(TextView)findViewById(R.id.txt_hotel_name);
        rv_hotel_item=(RecyclerView)findViewById(R.id.rv_hotel_item);

        ArrayList<HotelAndRestorentMaster> hotelAndRestorentMasters=new ArrayList<>();
        hotelAndRestorentMasters.add(new HotelAndRestorentMaster(1,1,"Gurukrupa","1234567890",
                "amrawati road","kncn","5","jska","ad"));
        hotelAndRestorentMasters.add(new HotelAndRestorentMaster(1,1,"Fun & Food","1234567890",
                "amrawati road","kncn","5","jska","ad"));
        hotelAndRestorentMasters.add(new HotelAndRestorentMaster(1,1,"Vrandawan","1234567890",
                "amrawati road","kncn","5","jska","ad"));
        hotelAndRestorentMasters.add(new HotelAndRestorentMaster(1,1,"Ginger Bell","1234567890",
                "amrawati road","kncn","5","jska","ad"));
        hotelAndRestorentMasters.add(new HotelAndRestorentMaster(1,1,"Hariyali","1234567890",
                "amrawati road","kncn","5","jska","ad"));
        hotelAndRestorentMasters.add(new HotelAndRestorentMaster(1,1,"Krishna","1234567890",
                "amrawati road","kncn","5","jska","ad"));

        HotelRestorentRecyclerAdapter hotelRestorentRecyclerAdapter=new HotelRestorentRecyclerAdapter(getBaseContext(),hotelAndRestorentMasters);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        rv_hotel_item.setLayoutManager(layoutManager);
        rv_hotel_item.setAdapter(hotelRestorentRecyclerAdapter);
        hotelRestorentRecyclerAdapter.notifyDataSetChanged();
    }

}
