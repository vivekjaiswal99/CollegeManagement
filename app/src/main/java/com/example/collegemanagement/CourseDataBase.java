package com.example.collegemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CourseDataBase extends SQLiteOpenHelper {
    private static final String CreateTableName="COURSE";
    private static final int VERSION=1;
    public CourseDataBase(Context context) {
        super(context,CreateTableName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY="create table course(id integer primary key autoincrement,CourseName text,CourseDuration text,CourseEligibility text,CourseFess text,CoursePercentage text)";
        db.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists course");
        onCreate(db);
    }
    public boolean PressButtonSubmitInsertData(String CourseName,String  CourseDuration,String CourseEligibility,String  CourseFess,String CoursePercentage){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("CourseName",CourseName);
        contentValues.put("CourseDuration",CourseDuration);
        contentValues.put("CourseFess",CourseFess);
        contentValues.put("CourseEligibility",CourseEligibility);
        contentValues.put("CoursePercentage",CoursePercentage);
        long l = sqLiteDatabase.insert("course",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
    Cursor GETCourseDetailShow(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from course",null);
        return cursor;
    }
    public void GetDeleteCourseData(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("course","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
}
