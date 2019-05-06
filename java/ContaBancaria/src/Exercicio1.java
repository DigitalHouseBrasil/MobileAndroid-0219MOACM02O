public class Exercicio1 {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Jorge");
        cliente1.setSobrenome("Osiro");
        cliente1.setCpf("123.456.312-12");
        cliente1.setRg("32.123.532-X");

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setNumeroDaConta("1234-5");
        contaCorrente.setSaldo(0F);
        contaCorrente.setTitular(cliente1);

        contaCorrente.imprimirDados();

        contaCorrente.depositar(500F);
        contaCorrente.sacar(10000000000000000F);
        contaCorrente.sacar(90F);

        contaCorrente.imprimirDados();
    }

}
