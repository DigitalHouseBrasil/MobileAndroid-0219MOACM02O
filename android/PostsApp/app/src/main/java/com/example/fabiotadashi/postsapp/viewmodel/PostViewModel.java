package com.example.fabiotadashi.postsapp.viewmodel;

import android.app.Application;

import com.example.fabiotadashi.postsapp.model.Post;
import com.example.fabiotadashi.postsapp.repository.PostRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends AndroidViewModel {

    private MutableLiveData<List<Post>> postsLiveData = new MutableLiveData<>();

    private PostRepository repository = new PostRepository();
    private CompositeDisposable disposable = new CompositeDisposable();

    public PostViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Post>> getPostLiveData() {
        return postsLiveData;
    }

    public void atualizarPosts() {
        disposable.add(
                repository.buscarListPosts()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(postList -> postsLiveData.setValue(postList))
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
