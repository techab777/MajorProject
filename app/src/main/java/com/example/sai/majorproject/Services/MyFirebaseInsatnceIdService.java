package com.example.sai.majorproject.Services;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.widget.Toast;

import com.example.sai.majorproject.Utilities.SharedPreferenceManager;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInsatnceIdService extends FirebaseInstanceIdService
{
    private static final String TAG = "MyFirebaseInstanceIdService";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        SharedPreferenceManager.setFCMCode(this,refreshedToken);
        Toast.makeText(this, refreshedToken, Toast.LENGTH_SHORT).show();
    }
}
