package br.com.digitalhouse.digitalhousegroceryapp.modules.lista.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.database.model.ListaCompras;
import br.com.digitalhouse.digitalhousegroceryapp.repository.GroceryRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ListaComprasViewModel extends AndroidViewModel {

    private MutableLiveData<List<ListaCompras>> listaComprasLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();

    private GroceryRepository groceryRepository = new GroceryRepository();

    public ListaComprasViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<ListaCompras>> getListaComprasLiveData() {
        return listaComprasLiveData;
    }

    public void atualizarLista(){
        disposable.add(
            groceryRepository.getListaCompras(getApplication())
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(listaComprasList -> {
                        listaComprasLiveData.setValue(listaComprasList);
                    }, throwable -> throwable.printStackTrace())
        );
    }

    public void inserirListaCompras(ListaCompras listaCompras){
        disposable.add(
                groceryRepository.inserirListaCompras(listaCompras, getApplication())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(() -> atualizarLista())
        );
    }

}
