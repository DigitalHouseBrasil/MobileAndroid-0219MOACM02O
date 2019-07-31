package br.com.digitalhouse.gamesapp.service.api;

import br.com.digitalhouse.gamesapp.model.GameResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GamesApi {

    @GET("games")
    Observable<GameResponse> getGames(@Query("api_key") String apiKey,
                                      @Query("format") String format,
                                      @Query("sort") String sort,
                                      @Query("limit") int limit,
                                      @Query("offset") int offset);

}
