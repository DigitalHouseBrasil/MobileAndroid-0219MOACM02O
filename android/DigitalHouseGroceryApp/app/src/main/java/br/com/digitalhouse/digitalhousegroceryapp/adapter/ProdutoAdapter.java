package br.com.digitalhouse.digitalhousegroceryapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.R;
import br.com.digitalhouse.digitalhousegroceryapp.model.Produto;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder>{

    private List<Produto> listaProdutos;

    public ProdutoAdapter(List<Produto> listaProdutos){
        this.listaProdutos = listaProdutos;
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
        }
    }

}
