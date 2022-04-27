package com.example.aps;

public interface Sistema {

    public void listarCursos();
    public void listarAlunos();
    public void limparHist();
    public void listarRel();
    public void addAluno(int id, String nome);
    public void addCurso(String nome, String tipo, int ano);
    public void addRend(Aluno aluno, Curso curso, float np1, float np2, float sub, float ex);

}
