package com.example.sai.majorproject.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sai.majorproject.Constants.UrlConstants;
import com.example.sai.majorproject.R;
import com.example.sai.majorproject.Utilities.SharedPreferenceManager;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HotelRegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt_Hotel_name,edt_Hotel_address,edt_Hotel_contactno,
            edt_hotel_roomdetail,edt_Hotel_info,edt_Hotel_website;
    Button btn_submit_hotel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_restorent_registration_form);
        edt_Hotel_name=(EditText)findViewById(R.id.edt_Hotel_name);
        edt_Hotel_address=(EditText)findViewById(R.id.edt_Hotel_address);
        edt_Hotel_contactno=(EditText)findViewById(R.id.edt_Hotel_contactno);
        edt_hotel_roomdetail=(EditText)findViewById(R.id.edt_hotel_roomdetail);
        edt_Hotel_info=(EditText)findViewById(R.id.edt_Hotel_info);
        edt_Hotel_website=(EditText)findViewById(R.id.edt_Hotel_website);
        btn_submit_hotel=(Button)findViewById(R.id.btn_submit_hotel);

        btn_submit_hotel.setOnClickListener(this);
    }
    public void addHotelOnDatabase() {
        Map<String, Object> requestParams = new HashMap<>();
        requestParams.put("hotel_name", edt_Hotel_name.getText().toString());
        requestParams.put("hotel_address", edt_Hotel_address.getText().toString());
        requestParams.put("hotel_contactno", Integer.parseInt(edt_Hotel_contactno.getText().toString()));
        requestParams.put("hotel_roomdetail", edt_hotel_roomdetail.getText().toString());
        requestParams.put("hotel_info", edt_Hotel_info.getText().toString());
        requestParams.put("hotel_website", edt_Hotel_website.getText().toString());
        requestParams.put("hotel_rating","dkllksm");
        requestParams.put("user_id", 1/*SharedPreferenceManager.getUserID(this)*/);

        JSONObject jsonObject = new JSONObject(requestParams);
        Log.d("JSON", jsonObject.toString());

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, UrlConstants.HotelUrl, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(HotelRegistrationActivity.this);
        requestQueue.add(jsonObjectRequest);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==btn_submit_hotel.getId()){
            addHotelOnDatabase();
        }
    }
}
