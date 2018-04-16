package com.example.hppc.saidrycleanersandlaundary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp pc on 4/15/2018.
 */

public class DatabaseHelperMen extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;

    public static final String DATABASE_NAME = "mens.db";
    public static final String TABLE_NAME = "mens_table";
    public static final String COL_ID = "ID";

    public static final String COL_SHIRT = "SHIRT";
    public static final String COL_JEANS = "JEANS";
    public static final String COL_JACKET = "JACKET";

    public DatabaseHelperMen(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,SHIRT TEXT ,JEANS TEXT,JACKET TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String shirt,String jeans,String jacket) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_SHIRT,shirt);
        contentValues.put(COL_JEANS,jeans);
        contentValues.put(COL_JACKET,jacket);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String shirt,String jeans,String jacket) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID,id);

        contentValues.put(COL_SHIRT,shirt);
        contentValues.put(COL_JEANS,jeans);
        contentValues.put(COL_JACKET,jacket);

        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }
    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }


}
