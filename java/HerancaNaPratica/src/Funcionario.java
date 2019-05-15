public abstract class Funcionario {

    private String nome;
    private Float salario;

    public abstract void baterPonto();

    public boolean baterMeta(){
        return true;
    }

    public boolean baterMeta(int pontos){
        return pontos >= 10;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }
}
