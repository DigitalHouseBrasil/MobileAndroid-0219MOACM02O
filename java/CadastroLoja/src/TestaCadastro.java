public class TestaCadastro {

    public static void main(String[] args) {

        // Criar Cliente
        Cliente cliente = new Cliente();
        cliente.setNome("Alberto Silva");
        cliente.setCodigo(1);

        Data dataCliente = new Data(15, 03, 1988);
        cliente.setDataNascimento(dataCliente);

        // Criar Funcionario
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Hero Santos");
        funcionario.setSalario(10000F);

        Data dataFuncionario = new Data(01, 01, 2001);
        funcionario.setDataNascimento(dataFuncionario);

        // Criar Gerente
        Gerente gerente = new Gerente();
        gerente.setNome("Akira Sam");
        gerente.setSalario(12000F);
        gerente.setArea("Depto Super Heróis");

        Data dataGerente = new Data(03,04,1980);
        gerente.setDataNascimento(dataGerente);

        // Criar Cadastro
        CadastraPessoa cadastro = new CadastraPessoa();
        cadastro.cadastrarPessoa(cliente);
        cadastro.cadastrarPessoa(funcionario);
        cadastro.cadastrarPessoa(gerente);

        System.out.println("Quantidade de pessoas cadastradas: "+cadastro.getQuantidadeDePessoas());

        cadastro.imprimeCadastro();
    }

}
