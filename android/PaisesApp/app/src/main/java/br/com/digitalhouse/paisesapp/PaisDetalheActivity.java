package br.com.digitalhouse.paisesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.digitalhouse.paisesapp.model.Pais;

public class PaisDetalheActivity extends AppCompatActivity {

    private TextView nomePaisTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais_detalhe);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        Pais pais = (Pais)bundle.getSerializable("PAIS");

        nomePaisTextView = findViewById(R.id.nome_pais_text_view);

        nomePaisTextView.setText(pais.getNome());

    }
}
