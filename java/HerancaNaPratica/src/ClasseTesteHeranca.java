public class ClasseTesteHeranca {

    public static void main(String[] args) {
        Funcionario funcionario = new Professor();
        Professor professor = new Professor();

        funcionario.setNome("Tadashi");
        funcionario.setSalario(1000F);

        professor.setNome("Gui");
        professor.setSalario(1000F);
        professor.setCurso("Mobile Android");

        System.out.println("Nome: "+funcionario.getNome()+" recebe "+funcionario.getSalario() + " reais" );
        System.out.println("Nome: "+professor.getNome()+" recebe "+professor.getSalario() + " reais no curso de "+professor.getCurso() );

        funcionario.baterPonto();
        professor.baterPonto();

        professor.baterMeta();
        professor.baterMeta(5);

        if(professor.baterMeta(15)){
            System.out.println("Meta atingida");
        }else{
            System.out.println("Meta não atingida");
        }
    }

}
