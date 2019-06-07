package br.com.digitalhouse.comunicacaoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoPrincipal = findViewById(R.id.botao_main);
        botaoPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaSegundaTela();
            }
        });
    }

    public void irParaSegundaTela(){
        Intent intent = new Intent(this, SegundaActivity.class);

        EditText nomeEditText = findViewById(R.id.nome_edit_text);
        String nome = nomeEditText.getEditableText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("NOME_DIGITADO", nome);

        intent.putExtras(bundle);

        startActivity(intent);
    }

}
