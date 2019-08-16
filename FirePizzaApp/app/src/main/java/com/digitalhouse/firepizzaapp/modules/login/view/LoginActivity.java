package com.digitalhouse.firepizzaapp.modules.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.digitalhouse.firepizzaapp.CadastroActivity;
import com.digitalhouse.firepizzaapp.MainActivity;
import com.digitalhouse.firepizzaapp.R;
import com.digitalhouse.firepizzaapp.modules.login.viewmodel.LoginViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private TextInputEditText emailEditText;
    private TextInputEditText senhaEditText;
    private Button loginButton;
    private Button cadastroButton;
    private ProgressBar progressBar;

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.email_edit_text_id);
        senhaEditText = findViewById(R.id.senha_edit_text_id);
        loginButton = findViewById(R.id.login_button_id);
        cadastroButton = findViewById(R.id.cadastrar_button_id);
        progressBar = findViewById(R.id.progressBar);

        loginButton.setOnClickListener( view -> logar());
        cadastroButton.setOnClickListener(view -> LoginActivity.this.irParaCadastro());

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

            loginViewModel.getAutenticadoLiveData()
                .observe(this, autenticado -> {
                    if (autenticado) {
                        irParaMain();
                    } else {
                        Toast.makeText(this, "Falha na autenticação", Toast.LENGTH_SHORT).show();
                    }
                });

        loginViewModel.getLoaderLiveData()
                .observe(this, showLoader -> progressBar.setVisibility(showLoader ? View.VISIBLE : View.GONE));

    }

    private void logar() {
        String email = emailEditText.getEditableText().toString();
        String senha = senhaEditText.getEditableText().toString();

        loginViewModel.autenticarUsuario(email, senha);
    }

    private void irParaMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void irParaCadastro() {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }

}