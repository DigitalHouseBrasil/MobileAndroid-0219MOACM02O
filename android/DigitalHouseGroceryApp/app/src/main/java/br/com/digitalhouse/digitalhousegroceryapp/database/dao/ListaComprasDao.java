package br.com.digitalhouse.digitalhousegroceryapp.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.model.ListaCompras;
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