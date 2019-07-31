package br.com.digitalhouse.digitalhousegroceryapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.com.digitalhouse.digitalhousegroceryapp.database.dao.ListaComprasDao;
import br.com.digitalhouse.digitalhousegroceryapp.database.dao.ProdutoDao;
import br.com.digitalhouse.digitalhousegroceryapp.database.model.ListaCompras;
import br.com.digitalhouse.digitalhousegroceryapp.database.model.Produto;

@Database(entities = {ListaCompras.class, Produto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static String DATABASE_NAME = "digitalgrocerydb";

    public abstract ListaComprasDao listaComprasDao();
    public abstract ProdutoDao produtoDao();
}