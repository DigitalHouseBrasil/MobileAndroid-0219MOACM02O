public class Arquivo {
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private String nome;
    private String tipo;

    protected void imprimirDados() {
        System.out.println("Arquivo: "+nome+"."+tipo);
    }
}
