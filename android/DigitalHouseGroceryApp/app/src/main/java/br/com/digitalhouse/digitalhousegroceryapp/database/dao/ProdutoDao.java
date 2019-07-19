package br.com.digitalhouse.digitalhousegroceryapp.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.model.Produto;
import io.reactivex.Flowable;

@Dao
public interface ProdutoDao {

    @Query("SELECT * FROM produto where lista_compras_id = :listaComprasId")
    Flowable<List<Produto>> getAllByListaComprasId(int listaComprasId);

    @Insert
    void insertAll(Produto... produto);

    @Delete
    void delete(Produto produto);

    @Update
    void atualizar(Produto produto);
}