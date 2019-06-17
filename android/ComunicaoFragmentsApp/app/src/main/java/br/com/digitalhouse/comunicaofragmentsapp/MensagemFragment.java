package br.com.digitalhouse.comunicaofragmentsapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MensagemFragment extends Fragment {

    private Comunicador comunicador;

    public MensagemFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mensagem, container, false);

        final EditText mensagemEditText = view.findViewById(R.id.mensagem_edit_text);

        Button botaoEnviar = view.findViewById(R.id.enviar_button);
        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = mensagemEditText.getText().toString();
                comunicador.exibirMensagem(mensagem);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        comunicador = (Comunicador) context;
    }
}
