package br.com.digitalhouse.digitalhousegroceryapp.modules.promocao.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.com.digitalhouse.digitalhousegroceryapp.R;
import br.com.digitalhouse.digitalhousegroceryapp.adapter.PromocaoAdapter;
import br.com.digitalhouse.digitalhousegroceryapp.modules.promocao.viewmodel.PromocaoViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class PromocaoFragment extends Fragment {

    private PromocaoAdapter adapter;

    public PromocaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_promocao, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.promocao_recycler_view_id);
        adapter = new PromocaoAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        PromocaoViewModel promocaoViewModel = ViewModelProviders.of(this).get(PromocaoViewModel.class);

        promocaoViewModel.atualizarPromocoes();

        promocaoViewModel.getPromocaoLiveData()
                .observe(this, promocaoList -> adapter.atualizarPromocoes(promocaoList));

        return view;
    }

}
