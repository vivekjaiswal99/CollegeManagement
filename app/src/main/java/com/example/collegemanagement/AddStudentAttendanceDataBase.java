package com.example.collegemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class AddStudentAttendanceDataBase extends SQLiteOpenHelper {
    private static final String CreateTableTame="ATTENDANCES";
    private static final int  VERSION=1;
    public AddStudentAttendanceDataBase(@Nullable Context context) {
        super(context,CreateTableTame,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY="create table attendances(id integer primary key autoincrement,name text,father text,phone number,present number,absent number)";
        db.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("drop table if exists attendances");
       onCreate(db);
    }

    public boolean PressSubmitButtonInsertData(String name,String father,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("father",father);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.insert("attendances",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
    Cursor AttendanceShowTeacherStudentData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from attendances",null);
        return cursor;
    }
    public boolean StudentAttendanceNumberValidation(String phone) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from attendances where phone='"+phone+"'", null);
        if (cursor.moveToFirst()){
            return true;
        }else {
            return false;
        }
    }
    public void GetDeleteAttendanceData(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("attendances","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
}
