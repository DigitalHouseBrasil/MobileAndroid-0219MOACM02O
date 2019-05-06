import java.io.Serializable;

public class Documento extends Arquivo implements Imprimivel, Serializable {

    @Override
    public void imprimir() {
        System.out.println("Sou um documento do Word");
        super.imprimirDados();
    }

}
