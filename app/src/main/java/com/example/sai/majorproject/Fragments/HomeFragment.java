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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.sai.majorproject.Adapter.HomeRecyclerAdapter;
import com.example.sai.majorproject.Adapter.TourismRecyclerAdapter;
import com.example.sai.majorproject.Constants.UrlConstants;
import com.example.sai.majorproject.DataModel.HomeDataModel;
import com.example.sai.majorproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView rv_home;
    Context context;
    ArrayList<HomeDataModel> homeDataModels=new ArrayList<>();
    HomeRecyclerAdapter homeRecyclerAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_home=(RecyclerView)view.findViewById(R.id.rv_home);

        getCategorieList();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        rv_home.setLayoutManager(layoutManager);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_home_fragment_layout,container,false);
    }
    public void getCategorieList(){
        RequestQueue requestQueue= Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, UrlConstants.HomeUrl, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
                        int size = response.length();
                        for (int i = 0; i < size; i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                int homeId = jsonObject.getInt("home_id");
                                String homeCategorie = jsonObject.getString("home_categorie");
                                String homeCategorieImage = jsonObject.getString("home_categorie_image");

                                HomeDataModel homeDataModel = new
                                        HomeDataModel(homeId, homeCategorie, homeCategorieImage);

                                homeDataModels.add(homeDataModel);
                            } catch (JSONException e) {
                                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                        homeRecyclerAdapter=new HomeRecyclerAdapter(context,homeDataModels);
                        rv_home.setAdapter(homeRecyclerAdapter);
                        homeRecyclerAdapter.notifyDataSetChanged();
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

