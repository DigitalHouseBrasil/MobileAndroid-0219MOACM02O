package br.com.digitalhouse.bottomnavigationapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tituloTextView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tituloTextView = findViewById(R.id.titulo_text_view);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.compras:
                        tituloTextView.setText("Compras");
                        break;
                    case R.id.listas:
                        tituloTextView.setText("Listas Salvas");
                        break;
                    default:
                        tituloTextView.setText("Promoções");
                        break;
                }

                return true;
            }
        });

    }
}
