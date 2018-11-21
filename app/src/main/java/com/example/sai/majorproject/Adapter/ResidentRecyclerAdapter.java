package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sai.majorproject.DataModel.ResidentMaster;
import com.example.sai.majorproject.R;

import java.util.List;

public class ResidentRecyclerAdapter extends RecyclerView.Adapter<ResidentRecyclerAdapter.MyViewHolder> {
    Context context;
    List<ResidentMaster> residentMasters;

    public ResidentRecyclerAdapter(Context context, List<ResidentMaster> residentMasters) {
        this.context = context;
        this.residentMasters = residentMasters;
    }

    @NonNull
    @Override
    public ResidentRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.residential_item_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResidentRecyclerAdapter.MyViewHolder myViewHolder, int position) {
         ResidentMaster residentMaster=residentMasters.get(position);
         myViewHolder.txt_resident_name.setText(residentMaster.getResident_name());
    }

    @Override
    public int getItemCount() {
        return residentMasters.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_resident_name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_resident_name=(TextView)itemView.findViewById(R.id.txt_resident_name);
        }
    }
}
