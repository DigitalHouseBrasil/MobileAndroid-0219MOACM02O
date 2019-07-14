package br.com.digitalhouse.digitalhousegroceryapp;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.adapter.ListaSalvaAdapter;
import br.com.digitalhouse.digitalhousegroceryapp.interfaces.FragmentActionsListener;
import br.com.digitalhouse.digitalhousegroceryapp.interfaces.ListaComprasListener;
import br.com.digitalhouse.digitalhousegroceryapp.interfaces.NovaListaListener;
import br.com.digitalhouse.digitalhousegroceryapp.model.ListaCompras;
import br.com.digitalhouse.digitalhousegroceryapp.model.Produto;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaSalvaFragment extends Fragment implements ListaComprasListener {

    private RecyclerView recyclerView;
    private FragmentActionsListener fragmentActionsListener;
    private FloatingActionButton floatingActionButton;

    public ListaSalvaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_salva, container, false);

        recyclerView = view.findViewById(R.id.lista_salva_recycler_view);

        ListaSalvaAdapter listaSalvaAdapter = new ListaSalvaAdapter(getListaComprasList(), this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setAdapter(listaSalvaAdapter);
        recyclerView.setLayoutManager(layoutManager);

        floatingActionButton = view.findViewById(R.id.fab_lista_salva);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.fragment_nova_lista_compras);
                dialog.show();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.add(R.id.container_id, new NovaListaComprasFragment(), "POPUP_NOVA_LISTA");
//                fragmentTransaction.commit();
            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        fragmentActionsListener = (FragmentActionsListener) context;
    }

    private List<ListaCompras> getListaComprasList() {
        List<ListaCompras> listaComprasList = new ArrayList<>();

        ListaCompras listaCompras1 = new ListaCompras();
        listaCompras1.setNome("Compras Super Mercado");
        listaComprasList.add(listaCompras1);

        Produto produto = new Produto();
        produto.setDescricao("Cebola");
        produto.setQuantidade(3);
        produto.setUnidade("kg");
        listaCompras1.getListaProdutos().add(produto);

        Produto produto2 = new Produto();
        produto2.setDescricao("Sabão em pó");
        produto2.setQuantidade(1);
        produto2.setUnidade("caixa");
        listaCompras1.getListaProdutos().add(produto2);

        ListaCompras listaCompras2 = new ListaCompras();
        listaCompras2.setNome("Churrasco fds");
        listaComprasList.add(listaCompras2);

        Produto produto3 = new Produto();
        produto3.setDescricao("Carvão");
        produto3.setQuantidade(2);
        produto3.setUnidade("pacote");

        listaCompras2.getListaProdutos().add(produto3);

        ListaCompras listaCompras3 = new ListaCompras();
        listaCompras3.setNome("Açougue");
        listaComprasList.add(listaCompras3);

        ListaCompras listaCompras4 = new ListaCompras();
        listaCompras4.setNome("Feira");
        listaComprasList.add(listaCompras4);

        return listaComprasList;
    }

    @Override
    public void onListaComprasClicado(ListaCompras listaCompras) {
        Fragment comprasFragment = new ComprasFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("LISTA", listaCompras);

        comprasFragment.setArguments(bundle);

        fragmentActionsListener.substituirFragment(comprasFragment);
    }


}
