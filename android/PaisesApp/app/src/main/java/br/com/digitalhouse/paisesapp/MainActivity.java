package br.com.digitalhouse.paisesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.paisesapp.adapter.PaisesAdapter;
import br.com.digitalhouse.paisesapp.model.Pais;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Pais> listaPaises = new ArrayList<>();
        Pais pais = new Pais();
        pais.setNome("Brasil");
        pais.setIdioma("Português");
        pais.setQuantidadeDeHabitantes(200_000_000);
        listaPaises.add(pais);

        Pais pais1 = new Pais();
        pais1.setNome("China");
        pais1.setIdioma("Mandarim");
        pais1.setQuantidadeDeHabitantes(1_000_000_000);
        listaPaises.add(pais1);

        Pais pais2 = new Pais();
        pais2.setNome("Estados Unidos");
        pais2.setIdioma("Inglês");
        pais2.setQuantidadeDeHabitantes(300_000_000);
        listaPaises.add(pais2);
        listaPaises.add(pais2);
        listaPaises.add(pais2);
        listaPaises.add(pais2);
        listaPaises.add(pais2);
        listaPaises.add(pais2);
        listaPaises.add(pais2);
        listaPaises.add(pais2);
        listaPaises.add(pais2);
        listaPaises.add(pais2);
        listaPaises.add(pais2);
        listaPaises.add(pais2);

        PaisesAdapter paisesAdapter = new PaisesAdapter(listaPaises);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = findViewById(R.id.paises_recycler_view);
        recyclerView.setAdapter(paisesAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }
}
