package com.example.alan.livro_room.util;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.alan.livro_room.modelo.Livro;

@Dao
public interface LivroDao {

    @Insert
    long inserir(Livro livro);

    @Delete
    long deletar(Livro livro);

    @Query("SELECT * FROM LIVRO")
    Livro[] listall();
}
