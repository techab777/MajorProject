package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sai.majorproject.Activities.ServiceItemActivity;
import com.example.sai.majorproject.DataModel.ServiceMaster;
import com.example.sai.majorproject.R;
import com.example.sai.majorproject.Utilities.UtilityMethods;

import java.util.List;

public class ServiceGridRecyclerAdapter extends RecyclerView.Adapter<ServiceGridRecyclerAdapter.MyViewHolder> {
    Context context;
    List<ServiceMaster> serviceMasters;

    public ServiceGridRecyclerAdapter(Context context, List<ServiceMaster> serviceMasters) {
        this.context = context;
        this.serviceMasters = serviceMasters;
    }

    @NonNull
    @Override
    public ServiceGridRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.service_grid_item_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceGridRecyclerAdapter.MyViewHolder myViewHolder, int position) {

        ServiceMaster serviceMaster=serviceMasters.get(position);
        myViewHolder.txt_grid.setText(serviceMaster.getService_type());
        myViewHolder.img_grid.setImageBitmap(BitmapFactory.decodeResource
                (context.getResources(),serviceMaster.getService_icon()));
        myViewHolder.relativeLayout.setBackgroundColor(Color.parseColor(serviceMaster.getService_ic_bg_color()));
    }

    @Override
    public int getItemCount()
    {
        return serviceMasters.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RelativeLayout relativeLayout;
        ImageView img_grid;
        TextView txt_grid;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout=(RelativeLayout)itemView.findViewById(R.id.relativeLayout);
            img_grid=(ImageView)itemView.findViewById(R.id.img_grid);
            txt_grid=(TextView)itemView.findViewById(R.id.txt_grid);

            relativeLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId()==relativeLayout.getId()){
                UtilityMethods.startNewActivity(context,ServiceItemActivity.class);
            }
        }
    }
}
