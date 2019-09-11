package com.example.tugas_kelompok_sql_lite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Mahasiswa";
    private static final String TABLE_NAME = "tbl_mahasiswa";
    private static final String KEY_NUMBER = "number";
    private static final String KEY_NAME = "name";
    private static final String KEY_DATE = "date";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_LOCATION = "location";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createUserTable = "Create Table " + TABLE_NAME + " ( " + KEY_NUMBER + " INTEGER PRIMARY KEY , " + KEY_NAME + " TEXT , " + KEY_DATE + " TEXT , " + KEY_GENDER + " TEXT , " + KEY_LOCATION + " TEXT )";
        sqLiteDatabase.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String sql = ("drop table if exists" + TABLE_NAME);
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public void insert(Mahasiswa mahasiswa) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NUMBER,mahasiswa.getNumber());
        values.put(KEY_NAME, mahasiswa.getName());
        values.put(KEY_DATE, mahasiswa.getDate());
        values.put(KEY_GENDER, mahasiswa.getGender());
        values.put(KEY_LOCATION, mahasiswa.getLocation());

        sqLiteDatabase.insert(TABLE_NAME, null, values);
    }

    public List<Mahasiswa> selectUserData() {
        ArrayList<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String[] columns = {KEY_NUMBER, KEY_NAME, KEY_DATE, KEY_GENDER, KEY_LOCATION};

        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, columns, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int number = cursor.getInt(0);
            String name = cursor.getString(1);
            String date = cursor.getString(2);
            String gender = cursor.getString(3);
            String location = cursor.getString(4);

            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNumber(number);
            mahasiswa.setName(name);
            mahasiswa.setDate(date);
            mahasiswa.setGender(gender);
            mahasiswa.setLocation(location);

            mahasiswaList.add(mahasiswa);
        }
        return mahasiswaList;
    }

    public void delete(Integer number) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String whereClause = KEY_NUMBER + "='" + number + "'";
        sqLiteDatabase.delete(TABLE_NAME, whereClause, null);
    }

    public void update(Mahasiswa mahasiswa) {

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, mahasiswa.getName());
        values.put(KEY_DATE, mahasiswa.getDate());
        values.put(KEY_GENDER, mahasiswa.getGender());
        values.put(KEY_LOCATION, mahasiswa.getLocation());
        String whereClause = KEY_NUMBER + " = '" + mahasiswa.getNumber() + "'";
        sqLiteDatabase.update(TABLE_NAME, values, whereClause, null);
    }
}

