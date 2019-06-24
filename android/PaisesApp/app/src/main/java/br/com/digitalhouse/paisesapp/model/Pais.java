package br.com.digitalhouse.paisesapp.model;

public class Pais {

    private String nome;
    private int quantidadeDeHabitantes;
    private String bandeira;
    private String idioma;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeDeHabitantes() {
        return quantidadeDeHabitantes;
    }

    public void setQuantidadeDeHabitantes(int quantidadeDeHabitantes) {
        this.quantidadeDeHabitantes = quantidadeDeHabitantes;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
