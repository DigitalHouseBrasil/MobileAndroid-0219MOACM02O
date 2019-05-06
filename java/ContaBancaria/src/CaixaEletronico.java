import java.util.Date;
import java.util.Scanner;

public class CaixaEletronico {

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
        contaCorrente.setLimiteChequeEspecial(200F);

        Scanner scanner = new Scanner(System.in);

        int opcao = -1;
        while (opcao != 0){
            System.out.println("Digite a operação desejada:");
            System.out.println("1 - depositar dinheiro");
            System.out.println("2 - depositar cheque");
            System.out.println("3 - sacar");
            System.out.println("4 - exibir dados da conta");
            System.out.println("0 - sair");

            opcao = scanner.nextInt();

            switch (opcao){
                case 1 :
                    System.out.println("Qual o valor a ser depositado?");
                    float valorParaDepositar = scanner.nextFloat();
                    contaCorrente.depositar(valorParaDepositar);
                    break;
                case 2 :
                    System.out.println("Qual o valor o banco do cheque?");
                    String banco = scanner.next();
                    float valorCheque = scanner.nextFloat();
                    Cheque cheque = new Cheque(valorCheque, banco, new Date());
                    contaCorrente.depositar(cheque);
                    break;
                case 3 :
                    System.out.println("Qual o valor a ser sacado?");
                    float valorParaSacar = scanner.nextFloat();
                    contaCorrente.sacar(valorParaSacar);
                case 4 :
                    contaCorrente.imprimirDados();
                    break;
            }
        }
    }

}
