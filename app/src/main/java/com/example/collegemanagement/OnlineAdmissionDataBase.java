package com.example.collegemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class OnlineAdmissionDataBase extends SQLiteOpenHelper{
    private static final String CreateTableName="ADMISSION";
    private static final int VERSION=1;
    public OnlineAdmissionDataBase(Context context) {
        super(context,CreateTableName, null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY="create table admission(id integer primary key autoincrement,Name text,Email text,Gender text,Father text,Course text,Location text,Number number)";
        db.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists admission");
        onCreate(db);
    }
    public boolean PressButtonSubmitInsertData(String Name,String  Email,String Gender,String Father,String Course,String Location,String Number){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",Name);
        contentValues.put("Email",Email);
        contentValues.put("Gender",Gender);
        contentValues.put("Father",Father);
        contentValues.put("Course",Course);
        contentValues.put("Location",Location);
        contentValues.put("Number",Number);
        long l = sqLiteDatabase.insert("admission",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
    Cursor GetOnlineAdmissionData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from admission",null);
        return cursor;
    }
    public boolean AdmissionStudentNumberValidationNumberNotSame(String Number){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from admission where Number='"+Number+"'",null);
        if (cursor.moveToFirst()){
            return true;
        }else {
            return false;
        }
    }
    public void GetDeleteAdmissionData(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("admission","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
}
