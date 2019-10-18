package com.andela.dairyapp;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.andela.dairyapp.database.DairyDatabaseOpenHelper;
import com.andela.dairyapp.database.repositories.NoteRepositoryImpl;


public class DairyApplication extends Application {

    private final String TAG = getClass().getSimpleName();

    private DairyDatabaseOpenHelper mDatabaseHelper;
    private NoteRepositoryImpl mNoteRepository;

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate(): Application");
        super.onCreate();

        initRepositories();
    }

    private void initRepositories() {
        if (mDatabaseHelper == null) {
            Log.d(TAG, "init database helper and repositories");
            mDatabaseHelper = new DairyDatabaseOpenHelper(this);
            mNoteRepository = new NoteRepositoryImpl(mDatabaseHelper);
        }
    }

    @NonNull
    public NoteRepositoryImpl getNoteRepository() {
        initRepositories();
        return mNoteRepository;
    }

}
