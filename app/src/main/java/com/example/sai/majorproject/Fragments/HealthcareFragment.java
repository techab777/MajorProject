package com.example.sai.majorproject.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sai.majorproject.Adapter.HealthcareRecyclerAdapter;
import com.example.sai.majorproject.DataModel.OrganizationMaster;
import com.example.sai.majorproject.R;

import java.util.ArrayList;

public class HealthcareFragment extends Fragment {
    RecyclerView rv_heathcare;
    Context context;
    ArrayList<OrganizationMaster> organizationMasters=new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_heathcare=(RecyclerView) view.findViewById(R.id.rv_healthcare);

        organizationMasters.add(new OrganizationMaster(1,1,"Apple Hospital",
                "Shanwara","Hospital","seva sadan Hr.sec. school","WWW.sevasadan.com",
                "5","1234567890","sevasadanlogo"));

        organizationMasters.add(new OrganizationMaster(1,1,"Apple Hospital",
                "Shanwara","Hospital","seva sadan Hr.sec. school","WWW.sevasadan.com",
                "5","1234567890","sevasadanlogo"));

        organizationMasters.add(new OrganizationMaster(1,1,"Apple Hospital",
                "Shanwara","Hospital","seva sadan Hr.sec. school","WWW.sevasadan.com",
                "5","1234567890","sevasadanlogo"));

        organizationMasters.add(new OrganizationMaster(1,1,"Apple Hospital",
                "Shanwara","Hospital","seva sadan Hr.sec. school","WWW.sevasadan.com",
                "5","1234567890","sevasadanlogo"));

        organizationMasters.add(new OrganizationMaster(1,1,"Apple Hospital",
                "Shanwara","Hospital","seva sadan Hr.sec. school","WWW.sevasadan.com",
                "5","1234567890","sevasadanlogo"));

        HealthcareRecyclerAdapter healthcareRecyclerAdapter=new HealthcareRecyclerAdapter(context,organizationMasters);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        rv_heathcare.setLayoutManager(layoutManager);
        rv_heathcare.setAdapter(healthcareRecyclerAdapter);
        healthcareRecyclerAdapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_healthcare_fragment_layout,container,false);
    }
}
