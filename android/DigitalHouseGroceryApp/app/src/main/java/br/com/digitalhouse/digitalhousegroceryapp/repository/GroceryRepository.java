package br.com.digitalhouse.digitalhousegroceryapp.repository;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.database.AppDatabase;
import br.com.digitalhouse.digitalhousegroceryapp.database.model.ListaCompras;
import br.com.digitalhouse.digitalhousegroceryapp.database.model.Produto;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GroceryRepository {

    public Flowable<List<ListaCompras>> getListaCompras(Context context) {
        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        return db.listaComprasDao()
                .getAll();
    }

    public Completable inserirListaCompras(ListaCompras listaCompras, Context context) {
        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        return Completable.fromAction(() -> db.listaComprasDao()
                .insertAll(listaCompras));
    }

    public Flowable<List<Produto>> getListProdutos(Context context, int listaComprasId){
        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        return db.produtoDao()
                .getListaProdutosByListaCompras(listaComprasId);
    }
    public Completable gravarProduto(Context context,Produto produto){
        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        return Completable.fromAction(() -> db.produtoDao().inserir(produto))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread());
    }


    public Completable atualizarProduto(Context context,Produto produto){
        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        return Completable.fromAction(() -> db.produtoDao().update(produto))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread());
    }

}
