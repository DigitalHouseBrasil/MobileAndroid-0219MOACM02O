package br.com.digitalhouse.digitalhousegroceryapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.R;
import br.com.digitalhouse.digitalhousegroceryapp.service.model.Promocao;

public class PromocaoAdapter extends RecyclerView.Adapter<PromocaoAdapter.ViewHolder> {

    private List<Promocao> promocaoList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.promocao_celula, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Promocao promocao = promocaoList.get(position);
        holder.setupPromocao(promocao);
    }

    @Override
    public int getItemCount() {
        return promocaoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagemPromocaoImageView;
        private TextView descricaoTextView;
        private TextView precoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imagemPromocaoImageView = itemView.findViewById(R.id.promocao_image_view_id);
            descricaoTextView = itemView.findViewById(R.id.promocao_descricao_text_view_id);
            precoTextView = itemView.findViewById(R.id.promocao_preco_text_view_id);
        }

        public void setupPromocao(Promocao promocao) {

            descricaoTextView.setText(promocao.getDescricao());
            precoTextView.setText("R$"+promocao.getPreco());

            Picasso.get().load(promocao.getImageUrl()).into(imagemPromocaoImageView);
        }
    }
}
