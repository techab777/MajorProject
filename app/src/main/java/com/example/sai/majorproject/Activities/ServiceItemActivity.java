package com.example.sai.majorproject.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.sai.majorproject.Adapter.ServiceRecyclerAdapter;
import com.example.sai.majorproject.DataModel.ServiceMaster;
import com.example.sai.majorproject.R;

import java.util.ArrayList;

public class ServiceItemActivity extends AppCompatActivity {
    Context context;
    TextView txt_service_type;
    RecyclerView rv_service_item;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_recycle_item_layout);

        rv_service_item=(RecyclerView)findViewById(R.id.rv_service_item);
        txt_service_type=(TextView)findViewById(R.id.txt_service_type);

        ArrayList<ServiceMaster> serviceMasters=new ArrayList<>();

        //serviceMasters.add(new ServiceMaster("1","1","1000","Plumber",));
        serviceMasters.add(new ServiceMaster(2,R.drawable.ic_ro,"user","#fff"));
        serviceMasters.add(new ServiceMaster(2,R.drawable.ic_refregeration,"user","#fff"));
        serviceMasters.add(new ServiceMaster(2,R.drawable.ic_painter,"user","#fff"));
        serviceMasters.add(new ServiceMaster(2,R.drawable.ic_plumber,"user","#fff"));
        serviceMasters.add(new ServiceMaster(2,R.drawable.ic_carpenter,"user","#fff"));

        ServiceRecyclerAdapter serviceRecyclerAdapter=new ServiceRecyclerAdapter(getBaseContext(),serviceMasters);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        rv_service_item.setLayoutManager(layoutManager);
        rv_service_item.setAdapter(serviceRecyclerAdapter);
        serviceRecyclerAdapter.notifyDataSetChanged();

    }
}
