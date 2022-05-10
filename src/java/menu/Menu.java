package menu;

public enum Menu {

    LISTA_CURSOS(1, "Listar todos os cursos dados"),
    LISTA_ALUNOS(2, "Listar todos os alunos inscritos"),
    LISTA_ALUNOS_FROM_CURSOS(3, "Listar os cursos que um determinado aluno está cadastrado"),
    LISTA_CURSOS_FROM_ALUNOS(4, "Listar os aluns que estão matriculados em um determinado curso"),
    ADICIONA_ALUNO(5, "Incluir um novo aluno"),
    ADICIONA_CURSO(6, "Incluir um novo curso"),
    ADICIONA_MATRICULA(7, "Matricular um aluno já existente em um curso já existente"),
    SAIR(0, "Sair do programa e salvar os dados");

    public final int num;
    public final String funcao;


    private Menu(int num, String funcao) {
        this.num = num;
        this.funcao = funcao;
    }
}
