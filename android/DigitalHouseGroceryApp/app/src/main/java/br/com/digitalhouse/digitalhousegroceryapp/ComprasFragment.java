package br.com.digitalhouse.digitalhousegroceryapp;


import android.app.Dialog;
import android.arch.persistence.room.Room;
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

import br.com.digitalhouse.digitalhousegroceryapp.adapter.ProdutoAdapter;
import br.com.digitalhouse.digitalhousegroceryapp.database.AppDatabase;
import br.com.digitalhouse.digitalhousegroceryapp.interfaces.ProdutoListener;
import br.com.digitalhouse.digitalhousegroceryapp.model.Produto;
import br.com.digitalhouse.digitalhousegroceryapp.util.Constantes;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComprasFragment extends Fragment implements ProdutoListener {

    private ProdutoAdapter produtoAdapter;
    private int listaComprasId;
    private AppDatabase db;
    private FloatingActionButton floatingActionButton;

    public ComprasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compras, container, false);

        Bundle bundle = getArguments();

        produtoAdapter = new ProdutoAdapter(this);

        db = Room.databaseBuilder(getContext(),
                AppDatabase.class, AppDatabase.DATABASE_NAME).build();

        if (bundle != null) {
            listaComprasId = bundle.getInt(Constantes.LISTA_ID);
            exibirListaCompras();
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        RecyclerView recyclerView = view.findViewById(R.id.produtos_recycler_view);

        recyclerView.setAdapter(produtoAdapter);
        recyclerView.setLayoutManager(layoutManager);

        floatingActionButton = view.findViewById(R.id.fab_compras);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirDialog();
            }
        });

        return view;
    }

    private void exibirDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_novo_produto);
        dialog.show();

        Button okDialogButton = dialog.findViewById(R.id.produto_ok_button);

        okDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produto produto = new Produto();

                TextInputEditText nomeTextInputEditText = dialog.findViewById(R.id.descricao_produto_edit_text);
                String descricaoDigitada = nomeTextInputEditText.getEditableText().toString();
                produto.setDescricao(descricaoDigitada);

                TextInputEditText unidadeTextInputEditText = dialog.findViewById(R.id.unidade_produto_edit_text);
                String unidadeDigitada = unidadeTextInputEditText.getEditableText().toString();
                produto.setUnidade(unidadeDigitada);

                TextInputEditText quantidadeTextInputEditText = dialog.findViewById(R.id.quantidade_produto_edit_text);
                String quantidadeDigitada = quantidadeTextInputEditText.getEditableText().toString();
                produto.setQuantidade(Float.parseFloat(quantidadeDigitada));

                produto.setListaComprasId(listaComprasId);

                gravarProduto(produto);

                dialog.dismiss();
            }
        });

    }

    private void gravarProduto(Produto produto) {
        Completable.fromAction(() -> db.produtoDao().insertAll(produto))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> exibirListaCompras());
    }

    private void exibirListaCompras() {
        db.produtoDao()
                .getAllByListaComprasId(listaComprasId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(produtoList -> {
                    produtoAdapter.atulizarLista(produtoList);
                }, throwable -> throwable.printStackTrace());
    }

    @Override
    public void onProdutoSelecionado(Produto produto) {
        Completable.fromAction(() -> db.produtoDao().atualizar(produto))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> exibirListaCompras());
    }

    @Override
    public void deletarProduto(Produto produto) {

    }
}
