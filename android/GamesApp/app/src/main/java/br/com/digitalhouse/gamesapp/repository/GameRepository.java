package br.com.digitalhouse.gamesapp.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.gamesapp.model.Game;
import br.com.digitalhouse.gamesapp.service.RetrofitService;
import io.reactivex.Observable;

public class GameRepository {

    private RetrofitService retrofitService = new RetrofitService();

    private static final String API_KEY = "cd082d3569e02515658088a4f8aa64df053d3ed8";
    private static final String FORMAT = "json";
    private static final String SORT = "id:desc";

    public Observable<List<Game>> getGameList(){
        return Observable.create(emitter -> {
            List<Game> gameList = new ArrayList<>();

            Game game = new Game();
            game.setTitulo("God of War 4");
            game.setDescricao("Game of the year - 2018.");

            gameList.add(game);

            emitter.onNext(gameList);
            emitter.onComplete();

        });
    }

    public Observable<List<Game>> getGameListApi(){
        return retrofitService.getGamesApi()
                .getGames(API_KEY, FORMAT, SORT)
                .map(gameResponse -> gameResponse.getResults());
    }

}
