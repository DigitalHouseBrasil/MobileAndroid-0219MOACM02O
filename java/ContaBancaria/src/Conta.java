public abstract class Conta {

    private String numeroDaConta;
    private Float saldo;
    private Cliente titular;

    public void imprimirDados(){
        System.out.println("*********************");
        System.out.println("Nome do cliente: "+titular.getNome() + " " + titular.getSobrenome());
        System.out.println("RG: "+titular.getRg());
        System.out.println("CPF: "+titular.getCpf());
        System.out.println("Saldo atual: "+saldo);
        System.out.println("Número da conta: "+numeroDaConta);
        System.out.println("*********************");
    }

    public void depositar(Float quantiaDeDinheiro){
        System.out.println("Depósito efetuado");
        saldo = saldo + quantiaDeDinheiro;
        System.out.println("O novo saldo é "+saldo);
    }

    public void sacar(Float quantiaDeDinheiro){
        if(saldo >= quantiaDeDinheiro){
            saldo = saldo - quantiaDeDinheiro;
            System.out.println("Saque efetuado no valor de "+quantiaDeDinheiro);
            System.out.println("O novo saldo é "+saldo);
        } else {
            System.out.println(titular.getNome()+" tentou sacar "+quantiaDeDinheiro);
            System.out.println("Saldo Insuficiente: "+saldo);
        }
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
}
