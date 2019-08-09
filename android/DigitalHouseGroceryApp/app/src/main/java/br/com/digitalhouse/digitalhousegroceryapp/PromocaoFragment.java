package br.com.digitalhouse.digitalhousegroceryapp;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.digitalhouse.digitalhousegroceryapp.adapter.PromocaoAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PromocaoFragment extends Fragment {


    public PromocaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_promocao, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.promocao_recycler_view_id);
        recyclerView.setAdapter(new PromocaoAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

         return view;
    }

}
