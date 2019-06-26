package br.com.digitalhouse.digitalhousegroceryapp.model;

import java.util.List;

public class ListaCompras {

    private String nome;
    private List<Produto> listaProdutos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
