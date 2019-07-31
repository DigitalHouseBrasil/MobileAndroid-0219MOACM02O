package br.com.digitalhouse.gamesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import br.com.digitalhouse.gamesapp.adapter.GamesAdapter;
import br.com.digitalhouse.gamesapp.viewmodel.GameViewModel;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView gameRecyclerView;
    private GamesAdapter gamesAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout_id);
        gameRecyclerView = findViewById(R.id.games_reycler_view_id);
        gamesAdapter = new GamesAdapter();

        gameRecyclerView.setAdapter(gamesAdapter);
        gameRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        GameViewModel gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);

        gameViewModel.atualizarGames();

        gameViewModel.getGameLiveData()
                .observe(this, gameList -> {
                    gamesAdapter.atualizarGames(gameList);
                    swipeRefreshLayout.setRefreshing(false);
                });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                gameViewModel.atualizarGames();
            }
        });
    }
}
