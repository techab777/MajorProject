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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.sai.majorproject.Adapter.EducationGridRecyclerAdapter;
import com.example.sai.majorproject.Constants.UrlConstants;
import com.example.sai.majorproject.DataModel.OrganizationMaster;
import com.example.sai.majorproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EducationFragment extends Fragment {
    RecyclerView rv_education;
    Context context;
    ArrayList<OrganizationMaster> organizationMasters=new ArrayList<>();
    EducationGridRecyclerAdapter educationGridRecyclerAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_education_fragment_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_education=(RecyclerView)view.findViewById(R.id.rv_education);

        getOrgTypeList();

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        rv_education.setLayoutManager(layoutManager);


    }
     public void getOrgTypeList(){
         RequestQueue requestQueue= Volley.newRequestQueue(context);

         JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, UrlConstants.OrgTypeUrl, null,
                 new Response.Listener<JSONArray>() {
                     @Override
                     public void onResponse(JSONArray response) {
                         Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                         int size=response.length();
                         for (int i=0;i<size;i++)
                         {
                             try {
                                 JSONObject jsonObject=response.getJSONObject(i);
                                 int orgId=jsonObject.getInt("org_id");
                                 int ownerId=jsonObject.getInt("owner_id");
                                 String orgName=jsonObject.getString("org_name");
                                 String orgAddress=jsonObject.getString("org_address");
                                 String orgType=jsonObject.getString("org_type");
                                 String orgInfo=jsonObject.getString("org_info");
                                 String orgRating=jsonObject.getString("org_rating");
                                 String orgContactinfo=jsonObject.getString("org_contactinfo");
                                 String orgWebsite=jsonObject.getString("org_website");
                                 String orgLogo=jsonObject.getString("org_logo");


                                 OrganizationMaster organizationMaster=new
                                         OrganizationMaster(orgId,ownerId,orgName,orgAddress,orgType,orgInfo,orgRating,orgContactinfo,orgWebsite,orgLogo);

                                 organizationMasters.add(organizationMaster);
                             } catch (JSONException e) {
                                 Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                             }
                         }
                         educationGridRecyclerAdapter=new EducationGridRecyclerAdapter(context,organizationMasters);
                         rv_education.setAdapter(educationGridRecyclerAdapter);
                         educationGridRecyclerAdapter.notifyDataSetChanged();
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
