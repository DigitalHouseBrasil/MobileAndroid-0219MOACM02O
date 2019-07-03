package br.com.digitalhouse;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.digitalhouse.digitalhousegroceryapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NovaListaComprasFragment extends Fragment {


    public NovaListaComprasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nova_lista_compras, container, false);
    }

}
