package br.com.digitalhouse.digitalhousegroceryapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.digitalhousegroceryapp.R;
import br.com.digitalhouse.digitalhousegroceryapp.interfaces.ListaComprasListener;
import br.com.digitalhouse.digitalhousegroceryapp.model.ListaCompras;

public class ListaSalvaAdapter extends RecyclerView.Adapter<ListaSalvaAdapter.ViewHolder>{

    private List<ListaCompras> listaComprasList;
    private ListaComprasListener listaComprasListener;

    public ListaSalvaAdapter(List<ListaCompras> listaComprasList, ListaComprasListener listaComprasListener){
        this.listaComprasList = listaComprasList;
        this.listaComprasListener = listaComprasListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_salva_celula, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ListaCompras listaCompras = listaComprasList.get(i);
        viewHolder.setupListaCompras(listaCompras);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaComprasListener.onListaComprasClicado(listaCompras);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaComprasList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView listaSalvaTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            listaSalvaTextView = itemView.findViewById(R.id.lista_salva_text_view);
        }

        public void setupListaCompras(ListaCompras listaCompras){
            listaSalvaTextView.setText(listaCompras.getNome());
        }

    }

}
