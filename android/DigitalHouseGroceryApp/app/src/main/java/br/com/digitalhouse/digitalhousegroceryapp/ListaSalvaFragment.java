package br.com.digitalhouse.digitalhousegroceryapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.adapter.ListaSalvaAdapter;
import br.com.digitalhouse.digitalhousegroceryapp.model.ListaCompras;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaSalvaFragment extends Fragment {

    private RecyclerView recyclerView;

    public ListaSalvaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_salva, container, false);

        recyclerView = view.findViewById(R.id.lista_salva_recycler_view);

        ListaSalvaAdapter listaSalvaAdapter = new ListaSalvaAdapter(getListaComprasList());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setAdapter(listaSalvaAdapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    private List<ListaCompras> getListaComprasList(){
        List<ListaCompras> listaComprasList = new ArrayList<>();

        ListaCompras listaCompras1 = new ListaCompras();
        listaCompras1.setNome("Compras Super Mercado");
        listaComprasList.add(listaCompras1);

        ListaCompras listaCompras2 = new ListaCompras();
        listaCompras2.setNome("Churrasco fds");
        listaComprasList.add(listaCompras2);

        ListaCompras listaCompras3 = new ListaCompras();
        listaCompras3.setNome("Açougue");
        listaComprasList.add(listaCompras3);

        ListaCompras listaCompras4 = new ListaCompras();
        listaCompras4.setNome("Feira");
        listaComprasList.add(listaCompras4);

        return listaComprasList;
    }

}
