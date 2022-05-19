package menu;

import interfaces.*;
import csv.ManipularCsv;
import entidades.*;

import java.util.Map;
import java.util.TreeMap;

public class ControllMenu {

    private final Sistema interf;
    private final ManipularCsv csvDir;

    public static Map<Integer, Menu> opcoesByCodigos = new TreeMap<>();
    static {
        for(Menu o: Menu.values()){
            opcoesByCodigos.put(o.num, o);
        }
    }

    public ControllMenu(Sistema interf, ManipularCsv csvDir){
        this.interf = interf;
        this.csvDir = csvDir;
    }

    public void iniciar(){
        Matricula matricula = csvDir.getMatricula();

        Menu num = null;
        while(num!=Menu.SAIR){
            num = interf.menu();
            switch (num) {
                case LISTAR_CURSOS -> {
                    interf.listarCursos(matricula);
                }
                case LISTAR_ALUNOS -> {
                    interf.listarAlunos(matricula);
                }
                case LISTAR_ALUNOS_FROM_CURSOS -> {
                    Curso Curso = interf.getCursoFromList(matricula);
                    if (Curso == null) return;
                    interf.listarAlunosDoCurso(matricula, Curso);
                }
                case LISTAR_CURSOS_FROM_ALUNOS -> {
                    Aluno Aluno = interf.getAlunoFromList(matricula);
                    if (Aluno == null) return;
                    interf.listarCursosDoAluno(matricula, Aluno);
                }
                case ADICIONA_ALUNO -> {
                    Aluno aluno = interf.addAluno();
                    matricula.addAluno(aluno);
                }
                case ADICIONA_CURSO -> {
                    Curso curso = interf.addCurso();
                    matricula.addCurso(curso);
                }
                case ADICIONA_MATRICULA -> {
                    Aluno Aluno = interf.getAlunoFromList(matricula);
                    if (Aluno == null) return;
                    Curso Curso = interf.getCursoFromList(matricula);
                    if (Curso == null) return;
                    matricula.addRelacaoAlunoCurso(Aluno, Curso);
                }
                case SAIR -> {
                    csvDir.saveCadastro(matricula);
                }
            }
        }
    }





































}
