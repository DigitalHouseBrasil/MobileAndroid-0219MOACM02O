package com.digitalhouse.firepizzaapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalhouse.firepizzaapp.R;
import com.digitalhouse.firepizzaapp.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> {

    private List<Pizza> pizzaList = new ArrayList<>();

    public void atualizarPizzas(List<Pizza> pizzaList){
        this.pizzaList = pizzaList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_celula, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pizza pizza = pizzaList.get(position);
        holder.setupPizza(pizza);
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView descricaoTextView;
        private TextView precoTextView;
        private TextView entregueTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            descricaoTextView = itemView.findViewById(R.id.descricao_text_view_id);
            precoTextView = itemView.findViewById(R.id.preco_text_view_id);
            entregueTextView = itemView.findViewById(R.id.entregue_text_view_id);
        }

        public void setupPizza(Pizza pizza) {
            descricaoTextView.setText(pizza.getDescricao());
            precoTextView.setText("R$"+pizza.getPreco());
            entregueTextView.setText(pizza.isEntregue() ? "entregue" : "aguarde");
            if(pizza.isEntregue()){
                entregueTextView.setText("entregue");
                entregueTextView.setTextColor(ContextCompat.getColor(entregueTextView.getContext(), R.color.verde));
            } else {
                entregueTextView.setText("aguarde");
                entregueTextView.setTextColor(ContextCompat.getColor(entregueTextView.getContext(), R.color.vermelho));
            }
        }
    }
}
