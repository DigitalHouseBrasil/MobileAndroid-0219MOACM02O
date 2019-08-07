package br.com.digitalhouse.digitalhousegroceryapp.modules.lista.view;


import android.app.AlertDialog;
import android.app.Dialog;

import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import br.com.digitalhouse.digitalhousegroceryapp.modules.produtos.view.ComprasFragment;
import br.com.digitalhouse.digitalhousegroceryapp.R;
import br.com.digitalhouse.digitalhousegroceryapp.adapter.ListaSalvaAdapter;
import br.com.digitalhouse.digitalhousegroceryapp.database.AppDatabase;
import br.com.digitalhouse.digitalhousegroceryapp.interfaces.FragmentActionsListener;
import br.com.digitalhouse.digitalhousegroceryapp.interfaces.ListaComprasListener;
import br.com.digitalhouse.digitalhousegroceryapp.database.model.ListaCompras;
import br.com.digitalhouse.digitalhousegroceryapp.modules.lista.viewmodel.ListaComprasViewModel;
import br.com.digitalhouse.digitalhousegroceryapp.util.Constantes;
import io.reactivex.Completable;
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
    private ListaComprasViewModel listaComprasViewModel;

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

        listaComprasViewModel = ViewModelProviders.of(this).get(ListaComprasViewModel.class);

        listaComprasViewModel.atualizarLista();

        listaComprasViewModel.getListaComprasLiveData()
                .observe(this, listaCompras -> {
                    listaSalvaAdapter.atualizarLista(listaCompras);
                });

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
        bundle.putInt(Constantes.LISTA_ID, listaCompras.getId());

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
        listaComprasViewModel.inserirListaCompras(listaCompras);
    }


}
