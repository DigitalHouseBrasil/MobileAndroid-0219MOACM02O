package br.com.digitalhouse.digitalhousegroceryapp.modules.produtos.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.database.model.Produto;
import br.com.digitalhouse.digitalhousegroceryapp.repository.GroceryRepository;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ComprasViewModel extends AndroidViewModel {

    MutableLiveData<List<Produto>> listaProdutoLiveData = new MutableLiveData<>();
    MutableLiveData<Produto> produtoAtualizadoLiveData = new MutableLiveData<>();

    CompositeDisposable disposable = new CompositeDisposable();

    GroceryRepository repository = new GroceryRepository();

    public ComprasViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Produto>> getListaProdutoLiveData() {
        return listaProdutoLiveData;
    }

    public MutableLiveData<Produto> getProdutoAtualizadoLiveData() {
        return produtoAtualizadoLiveData;
    }

    public void atualizarProdutos(int listaComprasId){
        disposable.add(
            repository.getListProdutos(getApplication(), listaComprasId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(listaProdutos -> listaProdutoLiveData.setValue(listaProdutos),
                        throwable -> throwable.printStackTrace())
        );
    }

    public void gravarProduto(Produto produto){
        disposable.add(
                repository.gravarProduto(getApplication(), produto)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(() -> produtoAtualizadoLiveData.setValue(produto),
                                throwable -> throwable.printStackTrace())
        );
    }

    public void atualizarProduto(Produto produto){
        disposable.add(
                repository.atualizarProduto(getApplication(), produto)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(() -> produtoAtualizadoLiveData.setValue(produto),
                                throwable -> throwable.printStackTrace())
        );
    }

}
