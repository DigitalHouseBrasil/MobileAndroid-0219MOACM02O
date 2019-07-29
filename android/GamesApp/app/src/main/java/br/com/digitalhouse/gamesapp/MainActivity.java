package br.com.digitalhouse.gamesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.digitalhouse.gamesapp.adapter.GamesAdapter;
import br.com.digitalhouse.gamesapp.viewmodel.GameViewModel;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView gameRecyclerView;
    private GamesAdapter gamesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameRecyclerView = findViewById(R.id.games_reycler_view_id);
        gamesAdapter = new GamesAdapter();

        gameRecyclerView.setAdapter(gamesAdapter);
        gameRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        GameViewModel gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);

        gameViewModel.atualizarGames();

        gameViewModel.getGameLiveData()
                .observe(this, gameList -> gamesAdapter.atualizarGames(gameList));
    }
}
