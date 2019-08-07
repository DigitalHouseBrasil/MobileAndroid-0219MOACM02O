package br.com.digitalhouse.gamesapp.viewmodel;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import br.com.digitalhouse.gamesapp.model.Game;
import br.com.digitalhouse.gamesapp.repository.GameRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class GameViewModel extends AndroidViewModel {

    private MutableLiveData<List<Game>> gameLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();
    private GameRepository gameRepository = new GameRepository();

    public GameViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Game>> getGameLiveData() {
        return gameLiveData;
    }

    public void atualizarGames(int limit, int offset) {
        disposable.add(
                gameRepository.getGameListApi(limit, offset)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(gameList -> {
                                    List<Game> gameComVogal = new ArrayList<>();
                                    for (Game game : gameList) {

                                        if(game.getTitulo().startsWith("A") ||
                                                game.getTitulo().startsWith("E") ||
                                                game.getTitulo().startsWith("I") ||
                                                game.getTitulo().startsWith("O") ||
                                                game.getTitulo().startsWith("U")){
                                            gameComVogal.add(game);
                                        }

                                    }
                                    gameLiveData.setValue(gameComVogal);
                                },
                                throwable -> throwable.printStackTrace())
        );
    }
}
