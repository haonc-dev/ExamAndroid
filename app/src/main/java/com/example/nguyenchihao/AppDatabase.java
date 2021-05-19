package com.example.nguyenchihao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.nguyenchihao.model.FeedbackEntity;

@Database(entities = {FeedbackEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public abstract FeebbackDao customerDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class, "Customers").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
