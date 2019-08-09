package br.com.digitalhouse.digitalhousegroceryapp.repository;

import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.service.RetrofitService;
import br.com.digitalhouse.digitalhousegroceryapp.service.model.Promocao;
import io.reactivex.Observable;

public class PromocaoRepository {

    private RetrofitService retrofitService = new RetrofitService();

    public Observable<List<Promocao>> getPromocaoLista(){
        return retrofitService.getPromocaoApi().getPromocoes();
    }

}
