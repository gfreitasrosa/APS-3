package menu;

import interfaces.*;
import csv.ManipularCsv;
import entidades.*;

import java.util.Map;
import java.util.TreeMap;

public class ControllMenu {

    private Sistema interf;
    private ManipularCsv csvDir;
    private Matricula matricula;

    public static Map<Integer, Menu> opcoesByCodigos = new TreeMap<>();
    {
        for(Menu o: Menu.values()){
            opcoesByCodigos.put(o.num, o);
        }
    }

    public ControllMenu(Sistema interf, ManipularCsv csvDir){
        this.interf = interf;
        this.csvDir = csvDir;
    }

    public void iniciar(){
        matricula = csvDir.getMatricula();

        Menu num = null;
        while(num!=Menu.SAIR){
            num = interf.menu();
            switch (num){
                case LISTAR_CURSOS: {listarCursos(); break;}
                case LISTAR_ALUNOS: {listarAlunos(); break;}
                case LISTAR_ALUNOS_FROM_CURSOS: {listarAlunosDoCurso(); break;}
                case LISTAR_CURSOS_FROM_ALUNOS: {listarCursosDoAluno(); break;}
                case ADICIONA_ALUNO: {addAluno(); break;}
                case ADICIONA_CURSO: {addCurso(); break;}
                case ADICIONA_MATRICULA: {addMatricula(); break;}
                case SAIR: {sair(); break;}
            }
        }
    }
    
    private void listarAlunos(){
        interf.listarAlunos(matricula);
    }
    
    private void listarCursos(){
        interf.listarCursos(matricula);
    }
    
    private void addAluno(){
        Aluno aluno = interf.addAluno();
        this.matricula.addAluno(aluno);
    }
    
    private void addCurso(){
        Curso curso = interf.addCurso();
        this.matricula.addCurso(curso);
    }
    
    private void listarAlunosDoCurso(){
        Curso Curso = interf.getCursoFromList(matricula);
        if(Curso==null) return;
        interf.listarAlunosDoCurso(matricula, Curso);
    }

    private void listarCursosDoAluno() {
        Aluno Aluno = interf.getAlunoFromList(matricula);
        if(Aluno==null) return;
        interf.listarCursosDoAluno(matricula, Aluno);
    }

    private void addMatricula() {
        Aluno Aluno = interf.getAlunoFromList(matricula);
        if(Aluno==null) return;
        Curso Curso = interf.getCursoFromList(matricula);
        if(Curso==null) return;
        matricula.addRelacaoAlunoCurso(Aluno, Curso);

    }

    private void sair() {
        csvDir.saveCadastro(matricula);
    }






































}
