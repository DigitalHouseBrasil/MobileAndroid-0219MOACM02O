package br.com.digitalhouse.comunicaofragmentsapp;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class ComunicacaoFragmentParaActivity extends AppCompatActivity implements Comunicador {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_para);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        MensagemFragment mensagemFragment = new MensagemFragment();
        transaction.replace(R.id.container_id, mensagemFragment);
        transaction.commit();

    }

    @Override
    public void exibirMensagem(String mensagem) {
        TextView mensagemTextView = findViewById(R.id.mensagem_text);
        mensagemTextView.setText(mensagem);
    }
}
