package com.example.sai.majorproject.Utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sai.majorproject.MainActivity;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.List;

public class UtilityMethods {
    public static String getDeviceMacAddress(Context context) {
        try {
            String iterfaceName = "wlan0";
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());

            for (NetworkInterface intf : interfaces) {

                if (!intf.getName().equalsIgnoreCase(iterfaceName)) {
                    continue;
                }
                byte[] mac = intf.getHardwareAddress();
                if (mac == null) {
                    return "";
                }
                StringBuilder buf = new StringBuilder();
                for (byte aMac : mac) {
                    buf.append(String.format("%02x:", aMac));
                }
                if (buf.length() > 0) {
                    buf.deleteCharAt(buf.length() - 1);
                }
                return buf.toString();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean CheckWifiEnable(Context context) {
        WifiManager wifi = (WifiManager) context.getSystemService(context.WIFI_SERVICE);

        if (wifi.isWifiEnabled()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean CheckInternetConnection(Context context) {
        ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = mgr.getActiveNetworkInfo();

        if (netInfo != null) {
            if (netInfo.isConnected()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public static void setGooglePlusButtonText(SignInButton signInButton,String buttonText){
        //find the textbview that is inside of the signInButton and set its text
        for (int i=0;i<signInButton.getChildCount();i++){
            View v=signInButton.getChildAt(i);

            if (v instanceof TextView){
                TextView tv=(TextView) v;
                tv.setText(buttonText);
                return;
            }
        }
    }
    public static void firebaseAuthWithGoogle(final GoogleSignInAccount acct,
                                              final FirebaseAuth firebaseAuth,
                                              final Activity context){
        AuthCredential credential= GoogleAuthProvider.getCredential(acct.getIdToken(),null);

        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                    MyApplication.getInstance().setFirebaseAuth(firebaseAuth);
                    Toast.makeText(context, "Login Successfull", Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context, MainActivity.class));
                    SharedPreferenceManager.setIsRegister(context,true);
                    SharedPreferenceManager.setRegisterWith(context,"Gamil");
                    SharedPreferenceManager.setIsLogin(context,true);
                }
                else{

                }
            }

    });
    }
    public static String splitEmail(String email){
        int index=email.indexOf('@');
        String user_name=email.substring(0,index);
        return user_name;
    }

    public static void startNewActivity(Context context,Class<?> clss)
    {
        Intent intent=new Intent(context,clss);
        context.startActivity(intent);
    }
}
