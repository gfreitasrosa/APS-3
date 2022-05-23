package interfaces;

import entidades.*;

import menu.Menu;



public interface Sistema {

    Menu menu();

    public void listarCursos(Matricula matricula);
    public void listarAlunos(Matricula matricula);

    public void listarAlunosDoCurso(Matricula matricula, Curso curso);
    public void listarCursosDoAluno(Matricula matricula, Aluno aluno);

    public Aluno addAluno();
    public Curso addCurso();

    public Curso getCursoFromList(Matricula matricula);
    public Aluno getAlunoFromList(Matricula matricula);

}
