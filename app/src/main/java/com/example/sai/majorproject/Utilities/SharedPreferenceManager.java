package com.example.sai.majorproject.Utilities;

import android.content.Context;

import com.example.sai.majorproject.Constants.SharedPreferencesKeyConstants;

public final class SharedPreferenceManager {
    //userid
    public static boolean setUserID(Context context,int UserID){
        return MyApplication.getInstance().getPreferences(context)
                .edit().putInt(SharedPreferencesKeyConstants.USER_ID,UserID).commit();
    }
    public static int getUserID(Context context){
        return MyApplication.getInstance().getPreferences(context)
                .getInt(SharedPreferencesKeyConstants.USER_ID,0);
    }
    //user register
    public static boolean setIsRegister(Context context,boolean isRegister){
        return MyApplication.getInstance().getPreferences(context)
                .edit().putBoolean(SharedPreferencesKeyConstants.ISREGISTER,isRegister).commit();
    }
    public  static boolean getIsRegister(Context context){
        return MyApplication.getInstance().getPreferences(context)
                .getBoolean(SharedPreferencesKeyConstants.ISREGISTER,false);
    }
    //user login
    public static boolean setIsLogin(Context context,boolean isLogin){
        return MyApplication.getInstance().getPreferences(context)
                .edit().putBoolean(SharedPreferencesKeyConstants.ISLOGIN,isLogin).commit();
    }
    public static boolean getIsLogin(Context context) {
        return MyApplication.getInstance().getPreferences(context)
                .getBoolean(SharedPreferencesKeyConstants.ISLOGIN,false);
    }
    //fullname
    public static boolean setUserFullName(Context context,String userfullname){
        return MyApplication.getInstance().getPreferences(context)
                .edit().putString(SharedPreferencesKeyConstants.USERFULLNAME,userfullname).commit();
    }
    public static String getUserFullName(Context context){
        return MyApplication.getInstance().getPreferences(context)
                .getString(SharedPreferencesKeyConstants.USERFULLNAME,"");
    }
    //mobile number
    public static boolean setMobileNumber(Context context,String MobileNumber){
        return MyApplication.getInstance().getPreferences(context)
                .edit().putString(SharedPreferencesKeyConstants.MOBILENUMBER,MobileNumber).commit();
    }
    public static String getMobileNumber(Context context){
        return MyApplication.getInstance().getPreferences(context)
                .getString(SharedPreferencesKeyConstants.MOBILENUMBER,"");
    }
    //user address
    public static boolean setUserAddress(Context context,String UserAddress){
        return MyApplication.getInstance().getPreferences(context)
                .edit().putString(SharedPreferencesKeyConstants.USERADDRESS,UserAddress).commit();
    }
    public static String getUserAddress(Context context){
        return MyApplication.getInstance().getPreferences(context)
                .getString(SharedPreferencesKeyConstants.USERADDRESS,"");
    }
    //google id
    public static boolean setGoogleId(Context context,String GoogleId){
        return MyApplication.getInstance().getPreferences(context)
                .edit().putString(SharedPreferencesKeyConstants.GOOGLEID,GoogleId).commit();
    }
    public static String getGoogleId(Context context){
        return MyApplication.getInstance().getPreferences(context)
                .getString(SharedPreferencesKeyConstants.GOOGLEID,"");
    }
    // fcm code
    public static boolean setFCMCode(Context context,String fcmcode){
        return MyApplication.getInstance().getPreferences(context)
                .edit().putString(SharedPreferencesKeyConstants.FCMCODE,fcmcode).commit();
    }
    public static String getFCMCode(Context context){
        return MyApplication.getInstance().getPreferences(context)
                .getString(SharedPreferencesKeyConstants.FCMCODE,"");
    }
    //Register with
    public static boolean setRegisterWith(Context context,String registerwith){
        return MyApplication.getInstance().getPreferences(context)
                .edit().putString(SharedPreferencesKeyConstants.REGISTERWITH,registerwith).commit();
    }
    public static String getRegisterWith(Context context){
        return MyApplication.getInstance().getPreferences(context)
                .getString(SharedPreferencesKeyConstants.REGISTERWITH,"");
    }
}
