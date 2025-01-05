package com.example.collegemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NotificationDataBase extends SQLiteOpenHelper {
    public static final String CreateTableName="NOTI";
    public static final int VERSION=1;
    public NotificationDataBase(@Nullable Context context) {
        super(context,CreateTableName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table noti(id integer primary key autoincrement,name text,course text,year number,phone number)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("drop table if exists noti");
       onCreate(db);
    }

    public boolean InsertDataStudent(String name,String course,String phone,String year){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("course",course);
        contentValues.put("phone",phone);
        contentValues.put("year",year);
        long l = sqLiteDatabase.insert("noti",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
    Cursor GetDataFromStudent(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from noti",null);
        return cursor;
    }
   public void GetDeleteNotificationData(int id){
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
             sqLiteDatabase.delete("noti","id=?",new String[]{String.valueOf(id)});
             sqLiteDatabase.close();
     }
}
