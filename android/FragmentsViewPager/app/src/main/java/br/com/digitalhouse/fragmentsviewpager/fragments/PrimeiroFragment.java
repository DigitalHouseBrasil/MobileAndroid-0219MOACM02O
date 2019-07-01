package br.com.digitalhouse.fragmentsviewpager.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.digitalhouse.fragmentsviewpager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrimeiroFragment extends Fragment {

    private TextView tituloTextView;

    public PrimeiroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_primeiro, container, false);

        Bundle bundle = getArguments();

        String titulo = bundle.getString("TITULO");

        tituloTextView = view.findViewById(R.id.titulo_text_view);
        tituloTextView.setText(titulo);

        return view;
    }

    public static PrimeiroFragment newInstance(String titulo){
        PrimeiroFragment primeiroFragment = new PrimeiroFragment();

        Bundle bundle = new Bundle();
        bundle.putString("TITULO", titulo);

        primeiroFragment.setArguments(bundle);

        return primeiroFragment;
    }

}
