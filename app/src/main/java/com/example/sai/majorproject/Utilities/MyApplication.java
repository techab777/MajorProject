package com.example.sai.majorproject.Utilities;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.sai.majorproject.Constants.SharedPreferencesKeyConstants;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyApplication extends Application {
    private  static MyApplication myApplication;
    private  SharedPreferences sharedPreferences;
    private FirebaseAuth firebaseAuth;

    public  static synchronized MyApplication getInstance(){
        if (myApplication==null){
            myApplication=new MyApplication();
        }
        return myApplication;
    }

    public SharedPreferences getPreferences(Context context){
        if (sharedPreferences==null){
            sharedPreferences=context.getSharedPreferences(SharedPreferencesKeyConstants.PREF_NAME,0);
        }
        return sharedPreferences;
    }
    public void setFirebaseAuth(FirebaseAuth firebaseAuth)
    {
        this.firebaseAuth=firebaseAuth;
    }
    public FirebaseAuth getFirebaseAuth(){
        if(this.firebaseAuth==null){
            return null;
        }else {
            return this.firebaseAuth;
        }
    }
    public FirebaseUser getCurrentUse(){
        if (getFirebaseAuth()!=null){
            return getFirebaseAuth().getCurrentUser();
        }else {
            return null;
        }
    }
}

