package br.com.digitalhouse.digitalhousegroceryapp.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.database.model.Produto;
import io.reactivex.Flowable;

@Dao
public interface ProdutoDao {

    @Query("select * from produto where lista_compras_id = :listaComprasId")
    Flowable<List<Produto>> getListaProdutosByListaCompras(int listaComprasId);

    @Insert
    void inserir(Produto produto);

    @Delete
    void delete(Produto produto);

    @Update
    void update(Produto produto);

}
