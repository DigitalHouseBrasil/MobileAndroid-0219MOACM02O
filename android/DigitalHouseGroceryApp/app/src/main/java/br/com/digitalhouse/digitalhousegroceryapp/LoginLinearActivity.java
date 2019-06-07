package br.com.digitalhouse.digitalhousegroceryapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginLinearActivity extends AppCompatActivity {

    private TextInputEditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_linear);

        emailEditText = findViewById(R.id.login_email_edit_text);

        Button botaoLogin = findViewById(R.id.login_button);
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaLogin();
            }
    });

        Button botaoCadastro = findViewById(R.id.cadastro_button);
        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaCadastro();
            }
        });
    }

    private void irParaLogin() {

        // Criar a intenção
        Intent intent = new Intent(this, MainActivity.class);

        // Criar o pacote
        Bundle bundle = new Bundle();

        // Buscar o que o usuario digitou
        String email = emailEditText.getEditableText().toString();

        // Adicionar valores ao pacote
        bundle.putString("EMAIL", email);

        // Colocar o bundle na intent
        intent.putExtras(bundle);

        // Iniciar activity do intent
        startActivity(intent);
    }

    private void irParaCadastro(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
