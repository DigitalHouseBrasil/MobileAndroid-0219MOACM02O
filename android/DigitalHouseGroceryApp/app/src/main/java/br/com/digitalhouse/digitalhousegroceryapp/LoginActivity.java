package br.com.digitalhouse.digitalhousegroceryapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.digitalhouse.digitalhousegroceryapp.util.Constantes;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText emailEditText;
    private TextInputEditText senhaEditText;
    private Button loginButton;
    private TextView registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.login_email_edit_text);
        senhaEditText = findViewById(R.id.login_senha_edit_text);
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.login_register_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logar();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaCadastro();
            }
        });

        SharedPreferences preferences = getSharedPreferences(Constantes.SHARED_PREFERENCES, Context.MODE_PRIVATE);

        if(preferences.contains(Constantes.EMAIL)){
            emailEditText.setText(preferences.getString(Constantes.EMAIL,""));
        }

    }

    private void logar() {

        String emailDigitado = emailEditText.getEditableText().toString();
        String senhaDigitada = senhaEditText.getEditableText().toString();

        emailEditText.setError(null);
        senhaEditText.setError(null);

//        if(emailDigitado.equals("fabio@digitalhouse.com") && senhaDigitada.equals("123456")){

        Intent intent = new Intent(this, HomeActivity.class);

        SharedPreferences preferences = getSharedPreferences(Constantes.SHARED_PREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constantes.EMAIL, emailDigitado);
        editor.commit();

        startActivity(intent);

//        } else {
//            emailEditText.setError("Usuário e/ou senha incorreto(s)");
//            senhaEditText.setError("Usuário e/ou senha incorreto(s)");
//        }
    }

    private void irParaCadastro() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
