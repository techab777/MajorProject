package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sai.majorproject.Activities.ResidentItemActivity;
import com.example.sai.majorproject.Activities.ServiceItemActivity;
import com.example.sai.majorproject.DataModel.ResidentMaster;
import com.example.sai.majorproject.DataModel.ServiceMaster;
import com.example.sai.majorproject.R;
import com.example.sai.majorproject.Utilities.UtilityMethods;

import java.util.List;

public class ResidentGridRecyclerAdapter extends RecyclerView.Adapter<ResidentGridRecyclerAdapter.MyViewHolder> {
   Context context;
   List<ResidentMaster> residentMasters;

    public ResidentGridRecyclerAdapter(Context context, List<ResidentMaster> residentMasters) {
        this.context = context;
        this.residentMasters = residentMasters;
    }

    @NonNull
    @Override
    public ResidentGridRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.hotel_restorent_grid_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResidentGridRecyclerAdapter.MyViewHolder myViewHolder, int position) {
        ResidentMaster residentMaster=residentMasters.get(position);
        myViewHolder.hotel_txt_grid.setText((residentMaster.getResident_type()));
      //  myViewHolder.hotel_img_grid.setImageBitmap(BitmapFactory.decodeResource(context.getResources(),residentMaster.getResident_image()));
    }

    @Override
    public int getItemCount() {
        return residentMasters.size();
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
                UtilityMethods.startNewActivity(context,ResidentItemActivity.class);
            }
        }
    }
}
