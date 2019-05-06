import java.util.ArrayList;
import java.util.List;

public class Impressora {

    private List<Imprimivel> filaDeImpressao = new ArrayList<>();

    public void imprimirTudo(){
        for(Imprimivel imprimivel: filaDeImpressao){
            imprimivel.imprimir();
        }
    }

    public void adicionarImprimivel(Imprimivel imprimivel){
        filaDeImpressao.add(imprimivel);
    }

}
