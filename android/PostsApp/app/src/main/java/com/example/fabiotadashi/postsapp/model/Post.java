package com.example.fabiotadashi.postsapp.model;

public class Post {

    private String urlImagem;
    private String titulo;
    private String descricao;

    public Post(){}

    public Post(String urlImagem, String titulo, String descricao) {
        this.urlImagem = urlImagem;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
