import java.util.ArrayList;
import java.util.Scanner;

public class PrimeiraAula {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        String nome = scanner.next();

        System.out.println("Digite a data do seu nascimento:");
        int anoNascimento = scanner.nextInt();

        System.out.println("Você já fez aniversário esse ano? [SIM / NAO]");
        String aniversarioFeito = scanner.next();

        int idade = 2018 - anoNascimento;

        if(aniversarioFeito.equals("SIM")){
            idade = idade + 1;
        }

        System.out.println("Bom dia " + nome + " você tem " + idade + " anos");


    }

}
