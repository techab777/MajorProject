package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sai.majorproject.DataModel.HotelAndRestorentMaster;
import com.example.sai.majorproject.R;

import java.util.List;

public class HotelRestorentRecyclerAdapter extends RecyclerView.Adapter<HotelRestorentRecyclerAdapter.MyViewHolder> {
  Context context;
  List<HotelAndRestorentMaster> hotelAndRestorentMasters;

    public HotelRestorentRecyclerAdapter(Context context, List<HotelAndRestorentMaster> hotelAndRestorentMasters) {
        this.context = context;
        this.hotelAndRestorentMasters = hotelAndRestorentMasters;
    }

    @NonNull
    @Override
    public HotelRestorentRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.hotel_restorent_item_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelRestorentRecyclerAdapter.MyViewHolder myViewHolder, int position) {

    }

    @Override
    public int getItemCount()
    {
        return hotelAndRestorentMasters.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //TextView txt_hotel;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
        }
    }
}
