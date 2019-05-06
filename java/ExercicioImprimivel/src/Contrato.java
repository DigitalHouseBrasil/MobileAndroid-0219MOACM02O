public class Contrato extends Arquivo implements Imprimivel{

    @Override
    public void imprimir() {
        System.out.println("Sou um contrato muito legal");
        super.imprimirDados();
    }

}
