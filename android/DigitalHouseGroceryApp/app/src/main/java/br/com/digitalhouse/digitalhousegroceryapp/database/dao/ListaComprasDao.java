package br.com.digitalhouse.digitalhousegroceryapp.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.database.model.ListaCompras;
import io.reactivex.Flowable;

@Dao
public interface ListaComprasDao {

    @Query("SELECT * FROM listacompras")
    Flowable<List<ListaCompras>> getAll();

    @Insert
    void insertAll(ListaCompras... listaCompras);

    @Delete
    void delete(ListaCompras listaCompras);

}