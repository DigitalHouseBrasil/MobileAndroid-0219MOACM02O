package br.com.digitalhouse.comunicacaoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String nome = bundle.getString("NOME_DIGITADO");

        TextView saudacaoText = findViewById(R.id.saudacao_text);
        saudacaoText.setText("Olá "+nome);
    }
}
