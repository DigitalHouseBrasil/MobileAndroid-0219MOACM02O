package br.com.digitalhouse.digitalhousegroceryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Pegar a intent
        Intent intent = getIntent();

        // Pegar o bundle da intent
        Bundle bundle = intent.getExtras();

        // Pegar no bundle o valor que está guardado na chave EMAIL
        String email = bundle.getString("EMAIL");

        // Buscar elemento na tela por id
        TextView emailText = findViewById(R.id.email_text);

        // Alterar o texto
        emailText.setText("Usuário: "+email);
    }
}
