package br.com.digitalhouse.primeiroapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void botaoApertado(View view){
        System.out.println("O botão foi apertado");
        TextView respostaTextView = findViewById(R.id.texto_reposta_id);
        EditText textoDigitado = findViewById(R.id.text_digitado_id);
        respostaTextView.setText("A idade é "+textoDigitado.getText());

        Log.i(MainActivity.class.toString() , "botao foi apertado");

        Toast.makeText(this, "Eu sou um toast!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(MainActivity.class.toString(), "método onStart");
        Toast.makeText(this, "método onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(MainActivity.class.toString(), "método onStop");
        Toast.makeText(this, "método onStart", Toast.LENGTH_SHORT).show();
    }
}
