package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.sai.majorproject.DataModel.OrganizationMaster;
import com.example.sai.majorproject.R;

import java.util.List;

public class EducationRecyclerAdapter extends RecyclerView.Adapter<EducationRecyclerAdapter.MyViewHolder> {
    Context context;
    List<OrganizationMaster> organizationMasters;

    public EducationRecyclerAdapter(Context context, List<OrganizationMaster> organizationMasters) {
        this.context = context;
        this.organizationMasters = organizationMasters;
    }

    @NonNull
    @Override
    public EducationRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.education_item_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EducationRecyclerAdapter.MyViewHolder myViewHolder, int position) {
         OrganizationMaster organizationMaster=organizationMasters.get(position);
        myViewHolder.img_org_logo.setImageBitmap(BitmapFactory.decodeResource(context.getResources(),Integer.parseInt(organizationMaster.getOrg_logo())));
         myViewHolder.txt_org_name.setText(organizationMaster.getOrg_name());
         myViewHolder.txt_org_address.setText(organizationMaster.getOrg_address());
         myViewHolder.rating_org.setRating(Integer.parseInt(organizationMaster.getOrg_rating()));
    }

    @Override
    public int getItemCount() {
        return organizationMasters.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView edu_item_cardview;
        ImageView img_org_logo;
        TextView txt_org_name,txt_org_address;
        RatingBar rating_org;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            edu_item_cardview=(CardView)itemView.findViewById(R.id.edu_item_cardview);
            img_org_logo=(ImageView)itemView.findViewById(R.id.img_org_logo);
            txt_org_name=(TextView)itemView.findViewById(R.id.txt_org_name);
            txt_org_address=(TextView)itemView.findViewById(R.id.txt_org_address);
            rating_org=(RatingBar)itemView.findViewById(R.id.rating_org);
        }
    }
}
