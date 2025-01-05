package com.example.collegemanagement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SessionManagerSharePreference {
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SessionManagerSharePreference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void CreateSharePreference(String name,String email,String password,String gender,String phone,String location){
        editor.putString("name",name);
        editor.putString("email",email);
        editor.putString("password",password);
        editor.putString("gender",gender);
        editor.putString("location",location);
        editor.putString("phone",phone);
        editor.apply();
    }
    public boolean CheckRecordExists(){
        if (sharedPreferences.contains("name")||sharedPreferences.contains("email")){
            return true;
        }else {
            return false;
        }
    }
    public void LogoutData(){
        editor.clear();
        editor.apply();
    }


    public String GetDetail(String key){
        String values = sharedPreferences.getString(key,null);
        return values;
    }
}
