public class Foto extends Arquivo implements Imprimivel{

    @Override
    public void imprimir() {
        System.out.println("Sou uma selfie");
        super.imprimirDados();
    }

}
