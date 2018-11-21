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
import com.example.sai.majorproject.Adapter.ResidentGridRecyclerAdapter;
import com.example.sai.majorproject.Adapter.ResidentRecyclerAdapter;
import com.example.sai.majorproject.Adapter.ServiceGridRecyclerAdapter;
import com.example.sai.majorproject.Constants.UrlConstants;
import com.example.sai.majorproject.DataModel.ResidentMaster;
import com.example.sai.majorproject.DataModel.ServiceMaster;
import com.example.sai.majorproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ResidentialFragment extends Fragment {
    RecyclerView rv_resident;
    Context context;
    ArrayList<ResidentMaster> residentMasters = new ArrayList<>();
    ResidentGridRecyclerAdapter residentGridRecyclerAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_residential_fragment_layout, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_resident = (RecyclerView) view.findViewById(R.id.rv_resident);

        getResidentTypeList();
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(context,2);
        rv_resident.setLayoutManager(layoutManager);

    }
     public void getResidentTypeList(){
         RequestQueue requestQueue= Volley.newRequestQueue(context);

         JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, UrlConstants.ResidentUrl, null,
                 new Response.Listener<JSONArray>() {
                     @Override
                     public void onResponse(JSONArray response) {
                         Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                         int size=response.length();
                         for (int i=0;i<size;i++)
                         {
                             try {
                                 JSONObject jsonObject=response.getJSONObject(i);
                                 int residentId=jsonObject.getInt("resident_id");
                                 int userId=jsonObject.getInt("user_id");
                                 String residentName=jsonObject.getString("resident_name");
                                 String residentType=jsonObject.getString("resident_type");
                                 String residentAddress=jsonObject.getString("resident_address");
                                 String residentNumber=jsonObject.getString("resident_number");
                                 String isbathroomattach=jsonObject.getString("isbathroomattach");


                                 ResidentMaster residentMaster=new
                                         ResidentMaster(residentId,userId,residentName,residentType,residentAddress,residentNumber,isbathroomattach);

                                 residentMasters.add(residentMaster);
                             } catch (JSONException e) {
                                 Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                             }
                         }
                         residentGridRecyclerAdapter=new ResidentGridRecyclerAdapter(context,residentMasters);
                         rv_resident.setAdapter(residentGridRecyclerAdapter);
                         residentGridRecyclerAdapter.notifyDataSetChanged();
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