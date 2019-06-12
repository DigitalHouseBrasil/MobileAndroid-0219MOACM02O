package br.com.digitalhouse.fragmentapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        PrimeiroFragment primeiroFragment = new PrimeiroFragment();
        transaction.replace(R.id.container_id, primeiroFragment);

        SegundoFragment segundoFragment = new SegundoFragment();
        transaction.replace(R.id.outro_container_id, segundoFragment);

        transaction.commit();

        Button primeiroButton = findViewById(R.id.primeiro_fragment_button);
        primeiroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirPrimeiroFragment();
            }
        });

    }

    public void exibirPrimeiroFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container_id, new PrimeiroFragment());
        transaction.replace(R.id.outro_container_id, new PrimeiroFragment());
        transaction.commit();
    }

}
