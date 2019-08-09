package br.com.digitalhouse.digitalhousegroceryapp.modules.promocao.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.repository.PromocaoRepository;
import br.com.digitalhouse.digitalhousegroceryapp.service.model.Promocao;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PromocaoViewModel extends AndroidViewModel {

    private MutableLiveData<List<Promocao>> promocaoLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();
    private PromocaoRepository repository = new PromocaoRepository();

    public PromocaoViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Promocao>> getPromocaoLiveData() {
        return promocaoLiveData;
    }

    public void atualizarPromocoes() {
        disposable.add(
                repository.getPromocaoList()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(promocaoList -> promocaoLiveData.setValue(promocaoList),
                                throwable -> throwable.printStackTrace())
        );
    }

}
