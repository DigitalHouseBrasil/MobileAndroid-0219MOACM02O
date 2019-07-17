package br.com.digitalhouse.digitalhousegroceryapp;


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

import br.com.digitalhouse.digitalhousegroceryapp.adapter.ListaSalvaAdapter;
import br.com.digitalhouse.digitalhousegroceryapp.database.AppDatabase;
import br.com.digitalhouse.digitalhousegroceryapp.interfaces.FragmentActionsListener;
import br.com.digitalhouse.digitalhousegroceryapp.interfaces.ListaComprasListener;
import br.com.digitalhouse.digitalhousegroceryapp.model.ListaCompras;
import br.com.digitalhouse.digitalhousegroceryapp.util.Constantes;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaSalvaFragment extends Fragment implements ListaComprasListener {

    private RecyclerView recyclerView;
    private FragmentActionsListener fragmentActionsListener;
    private FloatingActionButton floatingActionButton;
    private ListaSalvaAdapter listaSalvaAdapter;
    private ProgressBar progressBar;

    public ListaSalvaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_salva, container, false);

        recyclerView = view.findViewById(R.id.lista_salva_recycler_view);
        progressBar = view.findViewById(R.id.progress_bar_id);

        listaSalvaAdapter = new ListaSalvaAdapter(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setAdapter(listaSalvaAdapter);
        recyclerView.setLayoutManager(layoutManager);

        floatingActionButton = view.findViewById(R.id.fab_lista_salva);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateListaCompras();
    }

    private void updateListaCompras() {
        AppDatabase db = Room.databaseBuilder(getContext(),
                AppDatabase.class, AppDatabase.DATABASE_NAME).build();

        progressBar.setVisibility(View.VISIBLE);

        db.listaComprasDAO()
                .getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(listaCompras -> {
                            listaSalvaAdapter.updateList(listaCompras);
                            progressBar.setVisibility(View.GONE);
                        },
                        throwable -> throwable.printStackTrace());
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.fragment_nova_lista_compras);
        dialog.show();
        Button okDialogButton = dialog.findViewById(R.id.nova_lista_ok_button);
        okDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AppDatabase db = Room.databaseBuilder(getContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME).build();
                TextInputEditText novaListaNome = dialog.findViewById(R.id.nome_lista_edit_text);
                final ListaCompras listaCompras = new ListaCompras();
                listaCompras.setNome(novaListaNome.getEditableText().toString());

                Completable.fromAction(() -> db.listaComprasDAO().insert(listaCompras))
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onComplete() {
                                updateListaCompras();
                                dialog.dismiss();
                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                            }
                        });

            }
        });
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
    public void deleteListaCompras(ListaCompras listaCompras) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.app_name);
        builder.setMessage("Deseja deletar a lista de compras ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                final AppDatabase db = Room.databaseBuilder(getContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME).build();
                Completable.fromAction(() -> db.listaComprasDAO().delete(listaCompras))
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(() -> updateListaCompras());

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }


}
