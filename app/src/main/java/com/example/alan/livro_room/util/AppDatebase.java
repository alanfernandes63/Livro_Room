package com.example.alan.livro_room.util;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.alan.livro_room.modelo.Livro;

@Database(entities = {Livro.class},version = 1)
abstract class AppDatabase extends RoomDatabase {

    public abstract LivroDao livroDao();

    private static AppDatabase INSTANCE;

    static AppDatabase getDatabase(final Context contexto){
        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(contexto.getApplicationContext(),
                            AppDatabase.class,"livro_database").allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
