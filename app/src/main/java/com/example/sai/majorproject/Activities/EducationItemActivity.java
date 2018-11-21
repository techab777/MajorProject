package com.example.sai.majorproject.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.sai.majorproject.Adapter.EducationRecyclerAdapter;
import com.example.sai.majorproject.DataModel.OrganizationMaster;
import com.example.sai.majorproject.R;

import java.util.ArrayList;

public class EducationItemActivity extends AppCompatActivity {
    TextView txt_org_name,txt_org_address;
    ImageView img_org_logo;
    RatingBar rating_org;
    RecyclerView rv_education_item;
    Context context;
    ArrayList<OrganizationMaster> organizationMasters=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.education_recycle_item_layout);

        txt_org_name=(TextView)findViewById(R.id.txt_org_name);
        txt_org_address=(TextView)findViewById(R.id.txt_org_address);
        img_org_logo=(ImageView)findViewById(R.id.img_org_logo);
        rating_org=(RatingBar)findViewById(R.id.rating_org);
        rv_education_item=(RecyclerView)findViewById(R.id.rv_education_item);

        organizationMasters.add(new OrganizationMaster(1,1,"Seva Sadan Hr.Secondary School",
                "Shanwara","School","seva sadan Hr.sec. school","WWW.sevasadan.com",
                "5","1234567890","sevasadanlogo"));

        organizationMasters.add(new OrganizationMaster(2,2,"ThakurShivKumarSingh Engineering College",
                "Shanwara","College","seva sadan Hr.sec. school","WWW.sevasadan.com",
                "5","1234567890","sevasadanlogo"));

        organizationMasters.add(new OrganizationMaster(3,3,"Impassion Technology",
                "Shanwara","Coaching","seva sadan Hr.sec. school","WWW.sevasadan.com",
                "5","1234567890","sevasadanlogo"));

        organizationMasters.add(new OrganizationMaster(4,4,"Nehru Montesary",
                "Shanwara","School","seva sadan Hr.sec. school","WWW.sevasadan.com",
                "5","1234567890","sevasadanlogo"));

        organizationMasters.add(new OrganizationMaster(5,5,"G.N.T Montasary & Primary School",
                "Shanwara","School","seva sadan Hr.sec. school","WWW.sevasadan.com",
                "5","1234567890","sevasadanlogo"));

        EducationRecyclerAdapter educationRecyclerAdapter=new EducationRecyclerAdapter(context,organizationMasters);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        rv_education_item.setLayoutManager(layoutManager);
        rv_education_item.setAdapter(educationRecyclerAdapter);
        educationRecyclerAdapter.notifyDataSetChanged();

    }
}
