package br.com.digitalhouse.digitalhousegroceryapp.modules.lista.repository;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.database.AppDatabase;
import br.com.digitalhouse.digitalhousegroceryapp.database.model.ListaCompras;
import io.reactivex.Completable;
import io.reactivex.Flowable;

public class ListaComprasRepository {

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

}
