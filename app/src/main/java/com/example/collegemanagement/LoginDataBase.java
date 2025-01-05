package com.example.collegemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class LoginDataBase extends SQLiteOpenHelper {
    private static final String CreateTableName="LOGIN";
    private static final int VERSION=1;
    public LoginDataBase(Context context) {
        super(context,CreateTableName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1="create table login(id integer primary key autoincrement,name text,email text,password text,gender text,location text,phone number)";
        db.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists login");
            onCreate(db);
    }
    public boolean PressEnterButtonInsertData(String name,String email,String password,String gender,String location,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("gender",gender);
        contentValues.put("location",location);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.insert("login",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
  public boolean PressEnterButtonLoginValidation(String email,String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
       Cursor cursor = sqLiteDatabase.rawQuery("select * from login where email='"+email+"'AND password='"+password+"'",null);
       if (cursor.moveToFirst()){
           return true;
       }else {
           return false;
       }
    }

    public boolean PressEnterButtonAlreadyExistsData(String phone){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from login where phone='"+phone+"'",null);
         if (cursor.moveToFirst()){
             return true;
         }else {
             return false;
         }
    }
    public boolean PressEnterButtonOpenAdminPanel(String email,String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from login where email='"+email+"'and password='"+password+"'",null);
        if (cursor.moveToFirst()){
            return true;
        }else {
            return false;
        }
    }
    public boolean PressForgetPasswordButtonUpdatedPassword(String email,String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password",password);
        long l  = sqLiteDatabase.update("login",contentValues,"email=?",new String[]{email});
        if (l==-1){
            return false;
        }else {
            return true;
        }
    }
}
