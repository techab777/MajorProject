package com.example.sai.majorproject.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sai.majorproject.Adapter.ResidentRecyclerAdapter;
import com.example.sai.majorproject.DataModel.ResidentMaster;
import com.example.sai.majorproject.R;

import java.util.ArrayList;

public class ResidentItemActivity extends AppCompatActivity {
    ImageView img_resident;
    TextView txt_resident_name;
    Context context;
    RecyclerView rv_hotel_item;
    ResidentRecyclerAdapter residentRecyclerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotelrestorent_recycle_item_layout);

        rv_hotel_item=(RecyclerView)findViewById(R.id.rv_hotel_item);
        img_resident=(ImageView)findViewById(R.id.img_resident);
        txt_resident_name=(TextView)findViewById(R.id.txt_resident_name);

        ArrayList<ResidentMaster> residentMasters=new ArrayList<>();
        residentMasters.add(new ResidentMaster(1, 1, "TSEC Hostel", "Hostel",
                "Ziri", "1", "1"));

        residentMasters.add(new ResidentMaster(1, 1, "Flat", "Flat",
                "Ziri", "1", "1"));

        residentMasters.add(new ResidentMaster(1, 1, "Apartment", "Apartment",
                "Ziri", "1", "1"));

        residentMasters.add(new ResidentMaster(1, 1, "Plot", "Plot",
                "Ziri", "1", "1"));

        residentMasters.add(new ResidentMaster(1, 1, "Hostel", "Hostel",
                "Ziri", "1", "1"));

         residentRecyclerAdapter = new ResidentRecyclerAdapter(context, residentMasters);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv_hotel_item.setLayoutManager(layoutManager);
        rv_hotel_item.setAdapter(residentRecyclerAdapter);
        residentRecyclerAdapter.notifyDataSetChanged();
    }
}
