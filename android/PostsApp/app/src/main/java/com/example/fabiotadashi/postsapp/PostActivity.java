package com.example.fabiotadashi.postsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fabiotadashi.postsapp.adapter.PostAdapter;
import com.example.fabiotadashi.postsapp.viewmodel.PostViewModel;

public class PostActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter postAdapter = new PostAdapter();
    private PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        recyclerView = findViewById(R.id.posts_recycler_view_id);
        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);

        postViewModel.atualizarPosts();

        postViewModel.getPostLiveData()
                .observe(this, postList -> {
                    postAdapter.updatePostList(postList);
                });
    }
}
