import java.util.Objects;

public class ClubeFutebol {

    private String nome;
    private Integer quantidadeTorcedores;
    private String cidade;

    @Override
    public String toString() {
        return "Nome do clube: " + nome + "\n" +
                "Cidade: " + cidade + "\n" +
                "Qtd. torcedores: " + quantidadeTorcedores;
    }

    @Override
    public boolean equals(Object outroClube) {
        if (this == outroClube) return true;
        if (outroClube == null || getClass() != outroClube.getClass()) return false;
        ClubeFutebol clubeFutebol = (ClubeFutebol) outroClube;
        return Objects.equals(nome, clubeFutebol.nome) &&
                Objects.equals(cidade, clubeFutebol.cidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setQuantidadeTorcedores(Integer quantidadeTorcedores) {
        this.quantidadeTorcedores = quantidadeTorcedores;
    }

    public Integer getQuantidadeTorcedores(){
        return quantidadeTorcedores;
    }
}
