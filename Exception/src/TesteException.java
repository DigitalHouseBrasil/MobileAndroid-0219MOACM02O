import java.util.ArrayList;
import java.util.List;

public class TesteException {

    public static void main(String[] args) {

        List<String> listaAnimais = new ArrayList<>();

        try {
            listaAnimais.add("Pato");
            listaAnimais.add("Cachorro");
            listaAnimais.add("Gato");

            System.out.println(listaAnimais.get(2));

            int numero = 10 / 0;
        } catch (NullPointerException nullPointerException){
            System.out.println("O objeto está nulo");
        } catch (IndexOutOfBoundsException indexException){
            System.out.println("O indice buscado está incorreto");
        } catch (Exception exception) {
            System.out.println("Erro desconhecido");
        }

        System.out.println("Programa finalizado");
    }

}
