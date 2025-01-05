package com.example.collegemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class CollegeReviewDataBase extends SQLiteOpenHelper {
    private static final String CreateTableName="REVIEW";
    private static final int VERSION=1;
    public CollegeReviewDataBase(Context context) {
        super(context,CreateTableName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY="create table review(id integer primary key autoincrement,StudentName text,CourseName text,StudentSemester text,StudentReview text)";
        db.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("drop table if exists review");
          onCreate(db);
    }
    public boolean PressSubmitButtonInsertData(String StudentName,String CourseName,String StudentSemester,String StudentReview){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("StudentName",StudentName);
        contentValues.put("CourseName",CourseName);
        contentValues.put("StudentSemester",StudentSemester);
        contentValues.put("StudentReview",StudentReview);
        long l = sqLiteDatabase.insert("review",null,contentValues);
         if (l>0){
             return true;
         }else {
             return false;
         }
    }

    Cursor GetCollegeReviewData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from review",null);
        return cursor;
    }
    public void GetDeleteCollegeReview(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("review","id=?",new String[]{String.valueOf(id)});
    }
}
