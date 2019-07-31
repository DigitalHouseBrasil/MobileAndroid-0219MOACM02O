package br.com.digitalhouse.digitalhousegroceryapp.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.R;
import br.com.digitalhouse.digitalhousegroceryapp.interfaces.ProdutoListener;
import br.com.digitalhouse.digitalhousegroceryapp.database.model.Produto;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder>{

    private List<Produto> listaProdutos;
    private ProdutoListener produtoListener;

    public ProdutoAdapter(ProdutoListener produtoListener){
        this.produtoListener = produtoListener;
        this.listaProdutos = new ArrayList<>();
    }

    public void atualizarProdutos(List<Produto> listaProdutos){
        this.listaProdutos = listaProdutos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.produto_celula, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Produto produto = listaProdutos.get(position);
        viewHolder.setupProduto(produto);
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView descricaoTextView;
        private TextView quantidadeTextView;
        private TextView unidadeTextView;
        private CheckBox compradoCheckBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            descricaoTextView = itemView.findViewById(R.id.descricao_text_view);
            quantidadeTextView = itemView.findViewById(R.id.quantidade_text_view);
            unidadeTextView = itemView.findViewById(R.id.unidade_text_view);
            compradoCheckBox = itemView.findViewById(R.id.comprado_check_box);
        }

        public void setupProduto(Produto produto){
            descricaoTextView.setText(produto.getDescricao());
            quantidadeTextView.setText(""+produto.getQuantidade());
            unidadeTextView.setText(produto.getUnidade());
            compradoCheckBox.setChecked(produto.isComprado());

            compradoCheckBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    produto.setComprado(isChecked);
                    produtoListener.atualizarProdutoComprado(produto);
                }
            });
        }
    }

}
