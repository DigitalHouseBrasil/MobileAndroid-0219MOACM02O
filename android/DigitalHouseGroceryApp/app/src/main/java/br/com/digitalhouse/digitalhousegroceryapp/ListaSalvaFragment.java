package br.com.digitalhouse.digitalhousegroceryapp;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import br.com.digitalhouse.digitalhousegroceryapp.adapter.ListaSalvaAdapter;
import br.com.digitalhouse.digitalhousegroceryapp.database.AppDatabase;
import br.com.digitalhouse.digitalhousegroceryapp.interfaces.FragmentActionsListener;
import br.com.digitalhouse.digitalhousegroceryapp.interfaces.ListaComprasListener;
import br.com.digitalhouse.digitalhousegroceryapp.model.ListaCompras;
import br.com.digitalhouse.digitalhousegroceryapp.util.Constantes;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaSalvaFragment extends Fragment implements ListaComprasListener {

    private RecyclerView recyclerView;
    private FragmentActionsListener fragmentActionsListener;
    private FloatingActionButton floatingActionButton;
    private AppDatabase db;
    private ListaSalvaAdapter listaSalvaAdapter;
    private ProgressBar progressBar;

    public ListaSalvaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_salva, container, false);

        db = Room.databaseBuilder(getContext(),
                AppDatabase.class, AppDatabase.DATABASE_NAME).build();

        recyclerView = view.findViewById(R.id.lista_salva_recycler_view);
        progressBar = view.findViewById(R.id.progress_bar);

        listaSalvaAdapter = new ListaSalvaAdapter( this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setAdapter(listaSalvaAdapter);
        recyclerView.setLayoutManager(layoutManager);

        floatingActionButton = view.findViewById(R.id.fab_lista_salva);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirDialog();
            }
        });

        exibirListaCompras();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        fragmentActionsListener = (FragmentActionsListener) context;
    }

    @Override
    public void onListaComprasClicado(ListaCompras listaCompras) {
        Fragment comprasFragment = new ComprasFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(Constantes.LISTA, listaCompras);

        comprasFragment.setArguments(bundle);

        fragmentActionsListener.substituirFragment(comprasFragment);
    }

    @Override
    public void deletarListaCompras(ListaCompras listaCompras) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Digital House Grocery App");
        builder.setMessage("Deseja deletar a lista "+listaCompras.getNome()+"?");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Completable.fromAction(() -> db.listaComprasDao().delete(listaCompras))
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe();
                exibirListaCompras();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    private void exibirDialog(){
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.fragment_nova_lista_compras);
        dialog.show();

        Button okDialogButton = dialog.findViewById(R.id.nova_lista_ok_button);

        okDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaCompras listaCompras = new ListaCompras();

                TextInputEditText nomeTextInputEditText = dialog.findViewById(R.id.nome_lista_edit_text);
                String nomeDigitado = nomeTextInputEditText.getEditableText().toString();

                listaCompras.setNome(nomeDigitado);

                gravarListaCompras(listaCompras);

                dialog.dismiss();
            }
        });

    }

    private void gravarListaCompras(ListaCompras listaCompras){
        Completable.fromAction(() -> db.listaComprasDao().insertAll(listaCompras))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> exibirListaCompras());
    }

    private void exibirListaCompras(){
        progressBar.setVisibility(View.VISIBLE);
        db.listaComprasDao()
                .getAll()
                .delaySubscription(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listaComprasList -> {
                    listaSalvaAdapter.atualizarLista(listaComprasList);
                    progressBar.setVisibility(View.GONE);
                }, throwable -> throwable.printStackTrace());

    }

}
