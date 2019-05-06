public class ContaCorrente extends Conta {

    private float limiteChequeEspecial;

    public void depositar(Cheque cheque){
        depositar(cheque.getValor());
    }

    @Override
    public void sacar(Float quantiaDeDinheiro) {
        if ((getSaldo() + limiteChequeEspecial) >= quantiaDeDinheiro) {
            setSaldo(getSaldo() - quantiaDeDinheiro);
            System.out.println("Saque efetuado no valor de " + quantiaDeDinheiro);
            System.out.println("O novo saldo é " + getSaldo());
        } else {
            System.out.println(getTitular().getNome() + " tentou sacar " + quantiaDeDinheiro);
            System.out.println("Saldo Insuficiente: " + getSaldo());
        }
    }

    public float getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(float limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
}
