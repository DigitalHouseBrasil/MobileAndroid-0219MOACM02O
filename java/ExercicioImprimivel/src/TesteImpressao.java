public class TesteImpressao {

    public static void main(String[] args) {

        Foto foto = new Foto();
        foto.setNome("foto1");
        foto.setTipo("jpg");

        Contrato contrato = new Contrato();
        contrato.setNome("contrato_da_casa");
        contrato.setTipo("pdf");

        Documento documento = new Documento();
        documento.setNome("documento1_ver_final");
        documento.setTipo("docx");

        Foto fotoNatal = new Foto();
        fotoNatal.setNome("foto_familia");
        fotoNatal.setTipo("png");

        Impressora impressora = new Impressora();

        impressora.adicionarImprimivel(foto);
        impressora.adicionarImprimivel(contrato);
        impressora.adicionarImprimivel(documento);
        impressora.adicionarImprimivel(fotoNatal);

        impressora.imprimirTudo();

    }

}
