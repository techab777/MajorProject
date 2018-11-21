package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sai.majorproject.Activities.HotelRestorentItemActivity;
import com.example.sai.majorproject.Activities.ServiceItemActivity;
import com.example.sai.majorproject.DataModel.HotelAndRestorentMaster;
import com.example.sai.majorproject.R;
import com.example.sai.majorproject.Utilities.UtilityMethods;

import java.util.ArrayList;
import java.util.List;

public class HotelRestorentGridRecyclerAdapter extends RecyclerView.Adapter<HotelRestorentGridRecyclerAdapter.MyViewHolder> {
   Context context;
   List<HotelAndRestorentMaster> hotelAndRestorentMasters;

    public HotelRestorentGridRecyclerAdapter(Context context, List<HotelAndRestorentMaster> hotelAndRestorentMasters) {
        this.context = context;
        this.hotelAndRestorentMasters = hotelAndRestorentMasters;
    }

    @NonNull
    @Override
    public HotelRestorentGridRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.hotel_restorent_grid_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelRestorentGridRecyclerAdapter.MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return hotelAndRestorentMasters.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout hotel_linearLayout;
        ImageView hotel_img_grid;
        TextView hotel_txt_grid;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            hotel_linearLayout=(LinearLayout)itemView.findViewById(R.id.hotel_linearLayout);
            hotel_img_grid=(ImageView)itemView.findViewById(R.id.hotel_img_grid);
            hotel_txt_grid=(TextView)itemView.findViewById(R.id.hotel_txt_grid);

            hotel_linearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId()==hotel_linearLayout.getId()){
                UtilityMethods.startNewActivity(context,HotelRestorentItemActivity.class);
            }
        }
    }
}
