public class Professor extends Funcionario{

    private String curso;

    @Override
    public void baterPonto(){
        System.out.println("Professor bateu o ponto no app");
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
