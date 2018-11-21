package com.example.sai.majorproject.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sai.majorproject.Constants.UrlConstants;
import com.example.sai.majorproject.R;
import com.example.sai.majorproject.Utilities.SharedPreferenceManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ServiceRegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt_service_type,edt_service_coast;
    Button btn_submit_service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_registration_form_layout);

        edt_service_type=(EditText)findViewById(R.id.edt_service_type);
        edt_service_coast=(EditText)findViewById(R.id.edt_service_coast);
        btn_submit_service=(Button)findViewById(R.id.btn_submit_service);

        btn_submit_service.setOnClickListener(this);

    }
    public void addServiceOnDatabase(){
        Map<String,Object> requestParams= new HashMap<>();
        requestParams.put("service_type",edt_service_type.getText().toString());
        requestParams.put("service_coast",Integer.parseInt(edt_service_coast.getText().toString()));
        requestParams.put("user_id", SharedPreferenceManager.getUserID(this));

        JSONObject jsonObject=new JSONObject(requestParams);
        Log.d("JSON",jsonObject.toString());

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, UrlConstants.ServiceRegistrationUrl,
                jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String msg="";
                try {
                    msg=response.getString("message");
                } catch (JSONException e) {
                    Toast.makeText(ServiceRegistrationActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(ServiceRegistrationActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ServiceRegistrationActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(ServiceRegistrationActivity.this);
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==btn_submit_service.getId()){
            addServiceOnDatabase();
        }
    }
}
