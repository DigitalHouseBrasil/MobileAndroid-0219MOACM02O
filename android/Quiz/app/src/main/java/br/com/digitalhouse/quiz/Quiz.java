package br.com.digitalhouse.quiz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Quiz implements Serializable {

    private int percentual;
    private String caminhao;
    private List<String> cores = new ArrayList<>();

    public int getPercentual() {
        return percentual;
    }

    public void setPercentual(int percentual) {
        this.percentual = percentual;
    }

    public String getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(String caminhao) {
        this.caminhao = caminhao;
    }

    public List<String> getCores() {
        return cores;
    }

    public void setCores(List<String> cores) {
        this.cores = cores;
    }
}
