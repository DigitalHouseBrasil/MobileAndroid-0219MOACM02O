package com.digitalhouse.firepizzaapp.modules.login.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.digitalhouse.firepizzaapp.repository.FirebaseRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends AndroidViewModel {

    MutableLiveData<Boolean> autenticadoLiveData = new MutableLiveData<>();
    MutableLiveData<Boolean> loaderLiveData = new MutableLiveData<>();

    CompositeDisposable disposable = new CompositeDisposable();
    FirebaseRepository repository = new FirebaseRepository();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Boolean> getAutenticadoLiveData() {
        return autenticadoLiveData;
    }

    public MutableLiveData<Boolean> getLoaderLiveData() {
        return loaderLiveData;
    }

    public void autenticarUsuario(String email, String senha) {
        loaderLiveData.setValue(true);
        disposable.add(
                repository.autenticar(email, senha)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .doOnTerminate(() -> loaderLiveData.setValue(false))
                        .subscribe(() -> autenticadoLiveData.setValue(true),
                                throwable -> autenticadoLiveData.setValue(false))
        );
    }

}
