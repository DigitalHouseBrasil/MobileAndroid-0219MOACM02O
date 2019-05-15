import java.util.Scanner;

public class TesteCpf {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fábio Tadashi");

        System.out.println("Digite seu cpf sem o digito:");
        Scanner scanner = new Scanner(System.in);
        String cpf = scanner.next();

        pessoa.setCpf(cpf);

        System.out.println("O CPF completo é: " + pessoa.getCpf() + "-" + pessoa.getDigitoCpf());

    }

}
