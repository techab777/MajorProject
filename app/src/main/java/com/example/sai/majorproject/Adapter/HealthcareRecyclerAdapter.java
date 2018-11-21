package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sai.majorproject.DataModel.OrganizationMaster;
import com.example.sai.majorproject.R;

import java.util.List;

public class HealthcareRecyclerAdapter extends RecyclerView.Adapter<HealthcareRecyclerAdapter.MyViewHolder> {
    Context context;
    List<OrganizationMaster> organizationMasters;

    public HealthcareRecyclerAdapter(Context context, List<OrganizationMaster> organizationMasters) {
        this.context = context;
        this.organizationMasters = organizationMasters;
    }

    @NonNull
    @Override
    public HealthcareRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.healthcare_item_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthcareRecyclerAdapter.MyViewHolder myViewHolder, int position) {
        OrganizationMaster organizationMaster=organizationMasters.get(position);
        myViewHolder.txt_org_hospital_type.setText(organizationMaster.getOrg_type());
    }

    @Override
    public int getItemCount() {
        return organizationMasters.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_org_hospital_type;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_org_hospital_type=(TextView)itemView.findViewById(R.id.txt_org_hospital_type);
        }
    }
}
