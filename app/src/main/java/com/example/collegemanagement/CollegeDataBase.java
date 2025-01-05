package com.example.collegemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Currency;

public class CollegeDataBase extends SQLiteOpenHelper {
    private static final String CreateTableName="COLLEGE";
    private static final int VERSION=1;
    public CollegeDataBase(@Nullable Context context) {
        super(context,CreateTableName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table COLLEGE(id integer primary key autoincrement,CollegeName text,CollegeEstablished text,CollegeRanking text,CollegePass text,Placement text,CollegeLocation text,Number number)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists COLLEGE");
        onCreate(db);
    }
    public boolean EnterButtonInsertDatas(String CollegeName,String CollegeEstablished,String CollegeRanking,String CollegePass,String Placement,String CollegeLocation,String Number) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("CollegeName", CollegeName);
        contentValues.put("CollegeEstablished", CollegeEstablished);
        contentValues.put("CollegeRanking", CollegeRanking);
        contentValues.put("CollegePass", CollegePass);
        contentValues.put("Placement",Placement);
        contentValues.put("CollegeLocation", CollegeLocation);
        contentValues.put("Number", Number);
        long l = sqLiteDatabase.insert("COLLEGE", null, contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
     Cursor GetCollegeDetailShow(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from COLLEGE",null);
        return cursor;
     }
     public boolean CollegeNumberValidationNotSame(String Number){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from COLLEGE where Number='"+Number+"'",null);
        if (cursor.moveToFirst()){
            return true;
        }else {
            return false;
        }
     }
     public void GetDeleteCollegeData(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("COLLEGE","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();;
     }
}
