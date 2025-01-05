package com.example.collegemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.cardview.widget.CardView;

public class StudentCallDataBase extends SQLiteOpenHelper {
    private static final String CreateTableName="STUDENT_PHONE";
    private static final int VERSION=1;
    public StudentCallDataBase(@Nullable Context context) {
        super(context,CreateTableName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table StudentPhone(id integer primary key autoincrement,name text,course text,phone number)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists StudentPhone");
        onCreate(db);
    }
   public boolean InsertDataShowStudent(String name,String course,String phone){
        SQLiteDatabase sqLiteDatabase  = this.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
       contentValues.put("name",name);
       contentValues.put("course",course);
       contentValues.put("phone",phone);
      long l = sqLiteDatabase.insert("StudentPhone",null,contentValues);
      if (l>0){
          return true;
      }else {
          return false;
      }
   }
   Cursor ShowDataGetDetails(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from StudentPhone",null);
        return cursor;
   }
   public boolean TeacherEnterStudentPhoneNumberNotSame(String phone){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from StudentPhone where phone='"+phone+"'",null);
        if (cursor.moveToFirst()){
            return true;
        }else {
            return false;
        }
   }
}
