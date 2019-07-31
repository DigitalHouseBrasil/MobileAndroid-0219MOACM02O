package br.com.digitalhouse.digitalhousegroceryapp;

import android.content.Intent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText editTextSenha;
    private TextInputEditText editTextConfirmarSenha;
    private TextInputEditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FloatingActionButton fab = findViewById(R.id.fab_register);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botaoClicado(v);
            }
        });

        editTextSenha = findViewById(R.id.edit_text_password);
        editTextConfirmarSenha = findViewById(R.id.edit_text_confirm_password);
        editTextEmail = findViewById(R.id.edit_text_email);
    }


    public void botaoClicado(View view){
        editTextSenha.setError(null);
        editTextConfirmarSenha.setError(null);
        editTextEmail.setError(null);

        if(!editTextSenha.getEditableText().toString().equals(editTextConfirmarSenha.getEditableText().toString())) {
            editTextSenha.setError("As senhas não conferem");
            editTextConfirmarSenha.setError("As senhas não conferem");
        }else if(editTextSenha.getEditableText().toString().equals("")){
            editTextSenha.setError("Campo obrigatório");
        } else if (editTextEmail.getEditableText().toString().equals("")){
            editTextEmail.setError("Campo obrigatório");
        } else {
            Snackbar.make(view, "Usuário cadastro com sucesso", Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            irParaLogin();
                        }
                    }).setActionTextColor(getResources().getColor(R.color.verde))
                    .show();
        }
    }

    private void irParaLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
