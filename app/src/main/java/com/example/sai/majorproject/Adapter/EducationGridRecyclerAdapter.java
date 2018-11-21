package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sai.majorproject.Activities.EducationItemActivity;
import com.example.sai.majorproject.Activities.HotelRestorentItemActivity;
import com.example.sai.majorproject.DataModel.OrganizationMaster;
import com.example.sai.majorproject.DataModel.ServiceMaster;
import com.example.sai.majorproject.R;
import com.example.sai.majorproject.Utilities.UtilityMethods;

import java.util.List;

public class EducationGridRecyclerAdapter extends RecyclerView.Adapter<EducationGridRecyclerAdapter.MyViewHolder> {
    Context context;
    List<OrganizationMaster> organizationMasters;

    public EducationGridRecyclerAdapter(Context context, List<OrganizationMaster> organizationMasters) {
        this.context = context;
        this.organizationMasters = organizationMasters;
    }

    @NonNull
    @Override
    public EducationGridRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.education_grid_item_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EducationGridRecyclerAdapter.MyViewHolder myViewHolder, int position) {
        OrganizationMaster organizationMaster=organizationMasters.get(position);
        myViewHolder.txt_edu_type.setText(organizationMaster.getOrg_type());
    }

    @Override
    public int getItemCount() {
        return organizationMasters.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView edu_cardview;
        ImageView edu_img;
        TextView txt_edu_type;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            edu_cardview=(CardView)itemView.findViewById(R.id.edu_cardview);
            edu_img=(ImageView)itemView.findViewById(R.id.edu_img);
            txt_edu_type=(TextView)itemView.findViewById(R.id.txt_edu_type);

            edu_cardview.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            if (view.getId()==edu_cardview.getId()){
                UtilityMethods.startNewActivity(context,EducationItemActivity.class);
            }
        }
    }
}
