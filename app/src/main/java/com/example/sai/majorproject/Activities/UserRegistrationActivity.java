package com.example.sai.majorproject.Activities;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.example.sai.majorproject.Utilities.MyApplication;
import com.example.sai.majorproject.Utilities.SharedPreferenceManager;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserRegistrationActivity extends AppCompatActivity implements View.OnClickListener {
   EditText edt_fullname,edt_mobileno,edt_email,edt_password;
   Button btn_user_registration;
   private FirebaseAuth auth;
   GoogleSignInClient googleSignInClient;
   private static final int RC_Sign_IN=234;
    SignInButton signInButton;

   @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration_layout);
        auth=FirebaseAuth.getInstance();

        edt_fullname=(EditText)findViewById(R.id.edt_fullname);
        edt_mobileno=(EditText)findViewById(R.id.edt_mobileno);
        edt_email=(EditText)findViewById(R.id.edt_email);
        edt_password=(EditText)findViewById(R.id.edt_password);
        btn_user_registration=(Button) findViewById(R.id.btn_user_registration);

        btn_user_registration.setOnClickListener(this);
        signInButton=findViewById(R.id.signInButton);

        signInButton.setOnClickListener(this);

        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.WEBID))
                .requestEmail().build();

        googleSignInClient=GoogleSignIn.getClient(this,googleSignInOptions);
   }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_Sign_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                //Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                //authenticating with firebase
                firebaseAuthWithGoogle(account);
                //SharedPreferanceManager.setPhotoUri(this,account.getPhotoUrl().toString());

            } catch (ApiException e) {
                //Toast.makeText(RegisteredActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void signIn() {
        //getting the google signin intent
        Intent signInIntent = googleSignInClient.getSignInIntent();
        //starting the activity for result
        startActivityForResult(signInIntent, RC_Sign_IN);
    }

    public void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        Toast.makeText(this, account.getId(), Toast.LENGTH_SHORT).show();
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            MyApplication.getInstance().setFirebaseAuth(auth);

                            addGoogleOnDatabase(firebaseUser);
                            // Uri url=firebaseUser.getPhotoUrl();


                        }
                    }
                });
    }



    private void addGoogleOnDatabase(FirebaseUser firebaseUser)
    {
        Map<String,Object> requestParams=new HashMap<>();

        requestParams.put("user_name",edt_fullname.getText().toString());
        requestParams.put("user_mobileno",edt_mobileno.getText().toString());
        requestParams.put("user_email",firebaseUser.getEmail());
        requestParams.put("user_password",edt_password.getText().toString());
        requestParams.put("user_googleid",firebaseUser.getUid());
        requestParams.put("fcm_tocken", SharedPreferenceManager.getFCMCode(this));
        requestParams.put("user_profilepic","jk.jpg");


        JSONObject requestObject=new JSONObject(requestParams);
        Log.d("Json",requestObject.toString());

        JsonObjectRequest addUser=new JsonObjectRequest(Request.Method.POST, UrlConstants.RegistrationUrl,
                requestObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(UserRegistrationActivity.this, "message", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UserRegistrationActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(UserRegistrationActivity.this);
        requestQueue.add(addUser);
    }

    private void addJsonOnDatabase()
    {
        Map<String,Object> requestParams=new HashMap<>();
        requestParams.put("user_name",edt_fullname.getText().toString());
        requestParams.put("user_mobileno",edt_mobileno.getText().toString());
        requestParams.put("user_email",edt_email.getText().toString());
        requestParams.put("user_password",edt_password.getText().toString());
        requestParams.put("user_googleid","12345googleid");
        requestParams.put("fcm_tocken", SharedPreferenceManager.getFCMCode(this));
        requestParams.put("user_profilepic","jk.jpg");


        JSONObject requestObject=new JSONObject(requestParams);
        Log.d("Json",requestObject.toString());

        JsonObjectRequest addUser=new JsonObjectRequest(Request.Method.POST, UrlConstants.RegistrationUrl,
                requestObject, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(UserRegistrationActivity.this, "done", Toast.LENGTH_SHORT).show();
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UserRegistrationActivity.this, (CharSequence) error.getCause(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(UserRegistrationActivity.this);
        requestQueue.add(addUser);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==btn_user_registration.getId()){
            addJsonOnDatabase();
        }
        if (view.getId()==signInButton.getId())
        {
            signIn();
        }
    }
}
