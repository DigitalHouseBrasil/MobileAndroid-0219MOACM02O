package br.com.digitalhouse.digitalhousegroceryapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.R;
import br.com.digitalhouse.digitalhousegroceryapp.interfaces.ProdutoListener;
import br.com.digitalhouse.digitalhousegroceryapp.service.model.Promocao;

public class PromocaoAdapter extends RecyclerView.Adapter<PromocaoAdapter.ViewHolder>{

    private List<Promocao> promocaoList;
    private ProdutoListener produtoListener;

    public PromocaoAdapter(){
        this.promocaoList = new ArrayList<>();
    }

    public void atualizarProdutos(List<Promocao> promocaoList){
        this.promocaoList = promocaoList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.promocao_celula, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Promocao promocao = promocaoList.get(position);
        viewHolder.setupPromocao(promocao);
    }

    @Override
    public int getItemCount() {
        return promocaoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView descricaoTextView;
        private TextView precoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            descricaoTextView = itemView.findViewById(R.id.promocao_descricao_text_view_id);
            precoTextView = itemView.findViewById(R.id.promocao_preco_text_view_id);
            imageView = itemView.findViewById(R.id.promocao_image_view_id);
        }

        public void setupPromocao(Promocao promocao){
            descricaoTextView.setText(promocao.getDescricao());
            precoTextView.setText("R$"+promocao.getPreco());

            Picasso.get().load(promocao.getImageUrl()).into(imageView);
        }
    }

}
