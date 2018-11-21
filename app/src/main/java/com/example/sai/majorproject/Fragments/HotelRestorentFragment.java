package com.example.sai.majorproject.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sai.majorproject.Adapter.HotelRestorentGridRecyclerAdapter;
import com.example.sai.majorproject.Adapter.HotelRestorentRecyclerAdapter;
import com.example.sai.majorproject.DataModel.HotelAndRestorentMaster;
import com.example.sai.majorproject.R;

import java.util.ArrayList;

public class HotelRestorentFragment extends Fragment {
    RecyclerView rv_hotel;
    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_hotel_restorent_fragment_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_hotel=(RecyclerView) view.findViewById(R.id.rv_hotel);

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


        HotelRestorentGridRecyclerAdapter hotelRestorentGridRecyclerAdapter=new HotelRestorentGridRecyclerAdapter(context,hotelAndRestorentMasters);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(context,2);
        rv_hotel.setLayoutManager(layoutManager);
        rv_hotel.setAdapter(hotelRestorentGridRecyclerAdapter);
        hotelRestorentGridRecyclerAdapter.notifyDataSetChanged();
    }
}
