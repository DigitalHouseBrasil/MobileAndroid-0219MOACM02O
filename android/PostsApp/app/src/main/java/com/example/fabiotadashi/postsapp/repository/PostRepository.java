package com.example.fabiotadashi.postsapp.repository;

import com.example.fabiotadashi.postsapp.model.Post;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class PostRepository {

    public Observable<List<Post>> buscarListPosts(){
        return Observable.create(emitter -> {
            List<Post> postList = new ArrayList<>();
            Post post = new Post();
            post.setTitulo("Novos cursos no segundo semestre");
            post.setDescricao("A Digital House já começou os cursos do segundo semestre.");
            postList.add(post);

            Post post1 = new Post();
            post1.setTitulo("Digital Summit foi um sucesso");
            post1.setDescricao("Muitas palestras no Digital Summit 2019.");
            postList.add(post1);

            Post post2 = new Post();
            post2.setTitulo("Mais mulheres na programação");
            post2.setDescricao("A Digital House disponibiliza 100 bolsas para mulheres nos cursos de programação!!");
            postList.add(post2);

            emitter.onNext(postList);
            emitter.onComplete();
        });
    }

}
