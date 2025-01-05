package com.example.collegemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SetTeacherDataBase extends SQLiteOpenHelper {
    private static final String CreateTableName="TEACHERS";
    private static final int VERSION=1;
    public SetTeacherDataBase(Context context) {
        super(context,CreateTableName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY="create table Teachers(id integer primary key autoincrement,name text,email text,department text,qualification text,experience text,call number)";
        db.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("drop table if exists Teachers");
         onCreate(db);
    }
   public boolean PressButtonSubmitInsertData(String name,String email,String department,String qualification,String experience,String call){
           SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
           ContentValues contentValues = new ContentValues();
           contentValues.put("name",name);
           contentValues.put("email",email);
           contentValues.put("department",department);
           contentValues.put("qualification",qualification);
           contentValues.put("experience",experience);
           contentValues.put("call",call);
       long l = sqLiteDatabase.insert("Teachers",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
     Cursor GetTeacherData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
       Cursor cursor  = sqLiteDatabase.rawQuery("select * from Teachers",null);
        return cursor;
    }
    public boolean TeacherNumberValidationNotSame(String call){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Teachers where call='"+call+"'",null);
        if (cursor.moveToFirst()){
            return true;
        }else {
            return false;
        }
    }
    public void Deletes(int id){
     SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
     sqLiteDatabase.delete("Teachers","id=?",new String[]{String.valueOf(id)});
     sqLiteDatabase.close();
    }
}
