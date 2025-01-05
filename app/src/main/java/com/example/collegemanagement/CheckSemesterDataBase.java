package com.example.collegemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class CheckSemesterDataBase extends SQLiteOpenHelper {
    private static final String CreateTableName="SEMESTER";
    private static final int VERSION=1;
    public CheckSemesterDataBase(@Nullable Context context) {
        super(context,CreateTableName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table semester(id integer primary key autoincrement,CourseName text,subone text,tecone text,subtwo text,tectwo text," +
                "subthree text,tecthree text,subfour text,tecfour text,subfive text,tecfive text,subsix text,tecsix text"+")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists semester");
        onCreate(db);
    }
    public boolean EnterButtonInsertData(String CourseName,String subone,String tecone,String subtwo,String tectwo, String subthree,String tecthree,
                                         String subfour,String tecfour,String subfive,String tecfive,String subsix,String tecsix) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("CourseName",CourseName);
        contentValues.put("subone",subone);
        contentValues.put("tecone",tecone);
        contentValues.put("subtwo",subtwo);
        contentValues.put("tectwo",tectwo);
        contentValues.put("subthree",subthree);
        contentValues.put("tecthree",tecthree);
        contentValues.put("subfour",subfour);
        contentValues.put("tecfour",tecfour);
        contentValues.put("subfive",subfive);
        contentValues.put("tecfive",tecfive);
        contentValues.put("subsix",subsix);
        contentValues.put("tecsix",tecsix);
        long l = sqLiteDatabase.insert("semester",null,contentValues);
        if(l>0){
            return true;
        }else {
            return false;
        }
    }
    Cursor GetSemesterDetailShow(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from semester",null);
        return cursor;
    }
    public void GetDeleteSemesterData(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("semester","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
}
