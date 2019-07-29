package br.com.digitalhouse.gamesapp.model;

import java.util.List;

public class GameResponse {

    private String error;

    private List<Game> results;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Game> getResults() {
        return results;
    }

    public void setResults(List<Game> results) {
        this.results = results;
    }
}
