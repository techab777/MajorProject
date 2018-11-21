package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sai.majorproject.DataModel.ServiceMaster;
import com.example.sai.majorproject.R;

import java.util.List;

public class ServiceRecyclerAdapter extends RecyclerView.Adapter<ServiceRecyclerAdapter.MyViewHolder> {
   Context context;
   List<ServiceMaster> serviceMasters;

    public ServiceRecyclerAdapter(Context context, List<ServiceMaster> serviceMasters) {
        this.context = context;
        this.serviceMasters = serviceMasters;
    }

    @NonNull
    @Override
    public ServiceRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.service_item_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceRecyclerAdapter.MyViewHolder myViewHolder, int position) {
        ServiceMaster serviceMaster=serviceMasters.get(position);
        myViewHolder.txt_service_type.setText(serviceMaster.getService_type());
    }

    @Override
    public int getItemCount() {
        return serviceMasters.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_service_type;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_service_type=(TextView)itemView.findViewById(R.id.txt_service_type);
        }
    }
}
