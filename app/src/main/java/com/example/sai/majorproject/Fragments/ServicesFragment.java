package com.example.sai.majorproject.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.sai.majorproject.Adapter.ServiceGridRecyclerAdapter;
import com.example.sai.majorproject.Adapter.ServiceRecyclerAdapter;
import com.example.sai.majorproject.Constants.UrlConstants;
import com.example.sai.majorproject.DataModel.ServiceMaster;
import com.example.sai.majorproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ServicesFragment extends Fragment {
    RecyclerView rv_service;
    Context context;
    ArrayList<ServiceMaster> serviceMasters=new ArrayList<>();
    ServiceGridRecyclerAdapter serviceGridRecyclerAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_services_fragment_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_service=(RecyclerView) view.findViewById(R.id.rv_service);
        getServiceTypeList();
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(context,2);
        rv_service.setLayoutManager(layoutManager);
    }
    public void getServiceTypeList(){
        RequestQueue requestQueue= Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, UrlConstants.ServiceTypeUrl, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                        int size=response.length();
                        for (int i=0;i<size;i++)
                        {
                            try {
                                JSONObject jsonObject=response.getJSONObject(i);
                                int serviceId=jsonObject.getInt("service_id");
                                int serviceIcon=jsonObject.getInt("service_icon");
                                String serviceType=jsonObject.getString("service_type");
                                String serviceIcBgColor=jsonObject.getString("service_ic_bg_color");


                                ServiceMaster serviceMaster=new
                                        ServiceMaster(serviceId,serviceIcon,serviceType,serviceIcBgColor);

                                serviceMasters.add(serviceMaster);
                            } catch (JSONException e) {
                                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                        serviceGridRecyclerAdapter=new ServiceGridRecyclerAdapter(context,serviceMasters);
                        rv_service.setAdapter(serviceGridRecyclerAdapter);
                        serviceGridRecyclerAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
