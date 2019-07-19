package br.com.digitalhouse.digitalhousegroceryapp.interfaces;

import br.com.digitalhouse.digitalhousegroceryapp.model.Produto;

public interface ProdutoListener {

    void onProdutoSelecionado(Produto produto);
    void deletarProduto(Produto produto);

}
