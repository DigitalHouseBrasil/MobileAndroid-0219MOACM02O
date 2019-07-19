package br.com.digitalhouse.digitalhousegroceryapp;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.adapter.ProdutoAdapter;
import br.com.digitalhouse.digitalhousegroceryapp.model.ListaCompras;
import br.com.digitalhouse.digitalhousegroceryapp.model.Produto;
import br.com.digitalhouse.digitalhousegroceryapp.util.Constantes;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComprasFragment extends Fragment {

    private FloatingActionButton fab;
    private ProdutoAdapter produtoAdapter;

    public ComprasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compras, container, false);

        fab = view.findViewById(R.id.fab_produto);

        Bundle bundle = getArguments();

        if(bundle != null){
            ListaCompras listaCompras = (ListaCompras) bundle.getSerializable(Constantes.LISTA);
        }

        produtoAdapter = new ProdutoAdapter();

        setupRecyclerView(view);

        return view;
    }

    private void setupRecyclerView(View view) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        RecyclerView recyclerView = view.findViewById(R.id.produtos_recycler_view);

        recyclerView.setAdapter(produtoAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

}
