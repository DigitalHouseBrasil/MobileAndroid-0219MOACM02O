package br.com.digitalhouse.digitalhousegroceryapp.interfaces;

import br.com.digitalhouse.digitalhousegroceryapp.database.model.ListaCompras;

public interface ListaComprasListener {

    void onListaComprasClicado(ListaCompras listaCompras);
    void deletarListaCompras(ListaCompras listaCompras);

}
