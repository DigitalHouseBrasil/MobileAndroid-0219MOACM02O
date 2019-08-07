package br.com.digitalhouse.gamesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import br.com.digitalhouse.gamesapp.adapter.GamesAdapter;
import br.com.digitalhouse.gamesapp.adapter.listener.GameListListener;
import br.com.digitalhouse.gamesapp.model.Game;
import br.com.digitalhouse.gamesapp.viewmodel.GameViewModel;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements GameListListener {

    public static final int LIMIT = 20;
    private int offset;

    private RecyclerView gameRecyclerView;
    private GamesAdapter gamesAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout_id);
        gameRecyclerView = findViewById(R.id.games_reycler_view_id);
        gamesAdapter = new GamesAdapter(this);

        gameRecyclerView.setAdapter(gamesAdapter);
        gameRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        GameViewModel gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);

        gameViewModel.atualizarGames(LIMIT, offset);

        gameViewModel.getGameLiveData()
                .observe(this, gameList -> {
                    gamesAdapter.adicionarGames(gameList);
                    swipeRefreshLayout.setRefreshing(false);
                });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                gameViewModel.atualizarGames(LIMIT, offset);
            }
        });

        gameRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(gameRecyclerView.canScrollVertically(1)){

                    offset += LIMIT;

                    gameViewModel.atualizarGames(LIMIT, offset);

                }

            }

        });
    }

    @Override
    public void onGameClick(Game game) {
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_SUBJECT, game.getTitulo());

        intent.putExtra(Intent.EXTRA_TEXT, game.getTitulo() + ": "+game.getDescricao());

        startActivity(Intent.createChooser(intent,  "Compatilhar"));

    }

}
