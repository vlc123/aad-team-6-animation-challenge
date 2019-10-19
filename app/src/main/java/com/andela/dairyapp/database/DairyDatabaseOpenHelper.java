package com.andela.dairyapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DairyDatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DairyApp.db";
    private static final int DATABASE_VERSION = 1;
    private Context context;

    public DairyDatabaseOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DairyDatabaseContract.NoteEntry.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Context getContext() {
        return context;
    }

}
