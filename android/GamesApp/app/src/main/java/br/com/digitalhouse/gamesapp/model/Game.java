package br.com.digitalhouse.gamesapp.model;

import com.google.gson.annotations.SerializedName;

public class Game {

    @SerializedName("name")
    private String titulo;

    @SerializedName("deck")
    private String descricao;

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
