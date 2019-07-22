package com.example.fabiotadashi.postsapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fabiotadashi.postsapp.R;
import com.example.fabiotadashi.postsapp.model.Post;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Post> postList = new ArrayList<>();

    public void updatePostList(List<Post> postList) {
        this.postList = postList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView postImageView;
        private TextView tituloTextView;
        private TextView descricaoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            postImageView = itemView.findViewById(R.id.post_image_id);
            tituloTextView = itemView.findViewById(R.id.post_titulo_text_view_id);
            descricaoTextView = itemView.findViewById(R.id.post_descricao_text_view_id);
        }

        public void bind(Post post) {
            tituloTextView.setText(post.getTitulo());
            descricaoTextView.setText(post.getDescricao());
        }
    }
}
