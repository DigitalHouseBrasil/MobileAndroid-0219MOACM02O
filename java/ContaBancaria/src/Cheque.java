import java.util.Date;

public class Cheque {

    private Float valor;
    private String banco;
    private Date dataPagamento;

    public Cheque(Float valor, String banco, Date dataPagamento) {
        this.valor = valor;
        this.banco = banco;
        this.dataPagamento = dataPagamento;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
