public abstract class Pessoa {

    private String nome;
    private Data dataNascimento;

    public void imprimeDados(){
        System.out.println("Nome Completo: " + nome);
        System.out.println("Data de nascimento: " + dataNascimento.getDataFormatada());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
