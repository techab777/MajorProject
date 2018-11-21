package com.example.sai.majorproject.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.example.sai.majorproject.Adapter.TourismRecyclerAdapter;
import com.example.sai.majorproject.Constants.UrlConstants;
import com.example.sai.majorproject.DataModel.TourismPlaceMaster;
import com.example.sai.majorproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TourismFragment extends Fragment {
    RecyclerView rv;
   Context context;
    ArrayList<TourismPlaceMaster> tourismPlaceMasters=new ArrayList<>();
    TourismRecyclerAdapter tourismRecyclerAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv=(RecyclerView)view.findViewById(R.id.rv);

        getTourismPlaceList();

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(layoutManager);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tab_tourism_fragment_layout,container,false);
    }


    public void getTourismPlaceList(){

        RequestQueue requestQueue=Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET,
                UrlConstants.TourismUrl, null,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(context,response.toString(),Toast.LENGTH_LONG).show();
                int size=response.length();
                for (int i=0;i<size;i++)
                {
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                         int placeId=jsonObject.getInt("place_id");
                        String placeName=jsonObject.getString("place_name");
                        String placeAddress=jsonObject.getString("place_address");
                        String placeInfo=jsonObject.getString("place_info");
                        String placeHistory=jsonObject.getString("place_history");
                        String placeHeaderImage=jsonObject.getString("place_header_image");

                        TourismPlaceMaster tourismPlaceMaster=new
                                TourismPlaceMaster(placeId,placeName,placeAddress,placeInfo,placeHistory,placeHeaderImage);

                        tourismPlaceMasters.add(tourismPlaceMaster);
                    } catch (JSONException e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                tourismRecyclerAdapter=new TourismRecyclerAdapter(context,tourismPlaceMasters);
                rv.setAdapter(tourismRecyclerAdapter);
                tourismRecyclerAdapter.notifyDataSetChanged();
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
