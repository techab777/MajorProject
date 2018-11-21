package com.example.sai.majorproject.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ResidentRegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt_resident_name,edt_resident_type,edt_resident_address,edt_resident_no;
    CheckBox checkbox_isbathroomattach;
    Button btn_submit_resident;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resident_registration_form);

        edt_resident_name=(EditText)findViewById(R.id.edt_resident_name);
        edt_resident_type=(EditText)findViewById(R.id.edt_resident_type);
        edt_resident_address=(EditText)findViewById(R.id.edt_resident_address);
        edt_resident_no=(EditText)findViewById(R.id.edt_resident_no);
        checkbox_isbathroomattach=(CheckBox)findViewById(R.id.checkbox_isbathroomattach);
        btn_submit_resident=(Button)findViewById(R.id.btn_submit_resident);

        btn_submit_resident.setOnClickListener(this);
    }
    public void addResidentOnDatabase(){
        Map<String,Object> requestParams=new HashMap<>();
        requestParams.put("reident_name",edt_resident_name.getText().toString());
        requestParams.put("resident_type",edt_resident_type.getText().toString());
        requestParams.put("resident_address",edt_resident_address.getText().toString());
        requestParams.put("resident_number",edt_resident_no.getText().toString());
        requestParams.put("isbathroomattach","yes"/*selectIsBathroomAttached()*/);
        requestParams.put("user_id",1 /*SharedPreferenceManager.getUserID(this)*/);

        JSONObject jsonObject=new JSONObject(requestParams);
        Log.d("JSON",jsonObject.toString());
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, UrlConstants.ResidentRegistrationUrl, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(ResidentRegistrationActivity.this, "Submited Successfully", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ResidentRegistrationActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(ResidentRegistrationActivity.this);
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==btn_submit_resident.getId()){
            addResidentOnDatabase();
        }
    }
    private String selectIsBathroomAttached(){
        StringBuilder stringBuilder=new StringBuilder();
        if (checkbox_isbathroomattach.isChecked()==true){
            stringBuilder.append(checkbox_isbathroomattach.getText().toString()+" ");
        }
        return  stringBuilder.toString();
    }
}
