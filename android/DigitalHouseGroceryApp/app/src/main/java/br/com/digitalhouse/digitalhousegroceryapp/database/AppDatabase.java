package br.com.digitalhouse.digitalhousegroceryapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import br.com.digitalhouse.digitalhousegroceryapp.model.ListaCompras;

@Database(entities = {ListaCompras.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ListaComprasDAO listaComprasDAO();

    public static String DATABASE_NAME = "grocery_db";
}