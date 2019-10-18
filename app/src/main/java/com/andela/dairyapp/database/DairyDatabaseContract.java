package com.andela.dairyapp.database;

import android.provider.BaseColumns;

public final class DairyDatabaseContract {

    private DairyDatabaseContract() {
    }

    public static final class NoteEntry implements BaseColumns {
        public static final String TABLE_NAME = "dt_note";
        public static final String COLUMN_COLOR_CODE = "dtc_color_code";
        public static final String COLUMN_NOTE_NAME = "dtc_note_name";
        public static final String COLUMN_NOTE_DESCRIPTION = "dtc_note_description";
        public static final String COLUMN_CREATED_AT = "dtc_created_at";

        public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY, " +
                COLUMN_COLOR_CODE + " INTEGER NOT NULL, " +
                COLUMN_NOTE_NAME + " TEXT NOT NULL, " +
                COLUMN_NOTE_DESCRIPTION + " TEXT NOT NULL," +
                COLUMN_CREATED_AT + " TEXT NOT NULL" +
                ")";
    }


}
