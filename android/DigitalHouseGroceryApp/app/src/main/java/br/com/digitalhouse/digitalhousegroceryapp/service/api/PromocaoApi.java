package br.com.digitalhouse.digitalhousegroceryapp.service.api;

import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.service.model.Promocao;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PromocaoApi {

    @GET("promocoes")
    public Observable<List<Promocao>> getPromocoes();

}
