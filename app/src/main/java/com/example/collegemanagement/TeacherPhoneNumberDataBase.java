package com.example.collegemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class TeacherPhoneNumberDataBase extends SQLiteOpenHelper {
    private static final String CreateTableName="TEACHER_PHONE";
    private static final int VERSION=1;
    public TeacherPhoneNumberDataBase(@Nullable Context context) {
        super(context,CreateTableName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table phone(id integer primary key autoincrement,name text,phone number,department)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("drop table if exists phone");
     onCreate(db);
    }
    public boolean InsertDataBase(String name,String phone,String department){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        contentValues.put("department",department);
        long l = sqLiteDatabase.insert("phone",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
    Cursor ShowData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from phone",null);
        return cursor;
    }
    public boolean TeacherNumberValidationNumber(String phone){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from phone where phone='"+phone+"'",null);
        if (cursor.moveToFirst()){
            return true;
        }else {
            return false;
        }
    }
}
