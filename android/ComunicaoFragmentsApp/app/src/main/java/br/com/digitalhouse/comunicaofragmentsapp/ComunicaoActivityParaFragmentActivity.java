package br.com.digitalhouse.comunicaofragmentsapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ComunicaoActivityParaFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunicao_para_fragment);

        Button botaoVerde = findViewById(R.id.verde_button);
        botaoVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarFragment("VERDE");
            }
        });

        Button botaoRosa = findViewById(R.id.rosa_button);
        botaoRosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarFragment("ROSA");
            }
        });
    }

    private void iniciarFragment(String cor) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        CoresFragment coresFragment = new CoresFragment();

        Bundle bundle = new Bundle();
        bundle.putString("COR", cor);

        coresFragment.setArguments(bundle);

        transaction.replace(R.id.container_id, coresFragment);
        transaction.commit();
    }
}
