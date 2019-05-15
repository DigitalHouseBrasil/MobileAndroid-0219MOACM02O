public class Pessoa {

    private String nome;
    private String cpf;

    public String getDigitoCpf() {
        if (cpf.length() != 9) {
            System.out.println("CPF deve ter 9 digitos");
        }

        int total = 0;
        for (int i = 0; i <= 8; i++) {
            String digito = cpf.substring(i, i + 1);
            int fatorMultiplicador = 10 - i;
            total = total + (Integer.parseInt(digito) * fatorMultiplicador);
        }

        int primeiroDigito = (total * 10) % 11;

        total = 0;
        for (int i = 0; i <= 8; i++) {
            String digito = cpf.substring(i, i + 1);
            int fatorMultiplicador = 11 - i;
            total = total + (Integer.parseInt(digito) * fatorMultiplicador);
        }

        total = total + (primeiroDigito * 2);

        int segundoDigito = (total * 10) % 11;

        String digitoCalculado = primeiroDigito + "" + segundoDigito;

        return digitoCalculado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
