package interfaces;

import entidades.*;
import menu.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cli implements Sistema{


    @Override
    public Menu menu() {
        try {

            System.out.println("Entre com uma das opcoes:");
            for(Menu o: Menu.values()) {
                System.out.println("" + o.num + " - " + o.funcao);
            }

            @SuppressWarnings("resource")
            Scanner in = new Scanner(System.in);
            try {
                String entrada = in.nextLine();
                int opcaoCodigo = Integer.parseInt(entrada);

                if(!ControllMenu.opcoesByCodigos.containsKey(opcaoCodigo)) {
                    throw new InputMismatchException("Opcao nao corresponde a nenhum codigo listado");
                }
                return ControllMenu.opcoesByCodigos.get(opcaoCodigo);

            }catch(NumberFormatException e) {
                throw new InputMismatchException("Opcao entrada nao eh um numero inteiro");
            }
        }catch(InputMismatchException e) {
            System.out.println(e.getMessage());
            menu();
        }
        return null;

    }

    @Override
    public void listarAlunos(Matricula matricula) {
        System.out.println("Todos os alunos:");
        for(Aluno aluno: matricula.getAlunos()) {
            System.out.println(aluno);
        }
    }


    @Override
    public void listarCursos(Matricula matricula) {
        System.out.println("Todos os cursos:");
        for(Curso curso: matricula.getCursos()) {
            System.out.println(curso);
        }
    }

    @Override
    public void listarAlunosDoCurso(Matricula matricula, Curso curso) {
        System.out.println("Todos os alunos do curso " + curso + ":");
        for(Aluno aluno: matricula.getAlunosFromCurso(curso)) {
            System.out.println(aluno);
        }
    }

    @Override
    public void listarCursosDoAluno(Matricula matricula, Aluno aluno) {
        System.out.println("Todos os cursos do aluno " + aluno + ":");
        for(Curso curso: matricula.getCursosFromAluno(aluno.getId())) {
            System.out.println(curso);
        }
    }

    @Override
    public Curso addCurso() {
        System.out.println("Entre com os dados do curso");
        System.out.println("Digite o nome do curso");
        String nome = getString();
        System.out.println("Digite o tipo do curso");
        String tipo = getString();
        System.out.println("Digite o ano do curso");
        String ano = getString();
        return new Curso(nome, tipo, ano);
    }

    @Override
    public Aluno addAluno() {
        System.out.println("Entre com os dados do aluno");
        System.out.println("Digite o id do aluno");
        String id = getString();
        System.out.println("Digite o nome do aluno");
        String nome = getString();
        return new Aluno(id, nome);
    }

    public String getString() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        return str.trim();
    }

    @Override
    public Curso getCursoFromList(Matricula matricula) {
        System.out.println("Digite o nome do curso");
        String nome = getString();
        System.out.println("Digite o tipo do curso");
        String tipo = getString();
        System.out.println("Digite o ano do curso");
        String ano = getString();
        Curso curso = new Curso(nome, tipo, ano);
        if(!matricula.getCursos().contains(curso)) {
            System.out.println("Não existe nenhum curso lecionado na faculdade com essas informações");
            return null;
        }

        return curso;
    }

    @Override
    public Aluno getAlunoFromList(Matricula matricula) {
        listarAlunos(matricula);
        System.out.println("Digite o id do aluno escolhido:");
        String id = getString();

        Aluno aluno = matricula.getAlunoFromId(id);
        if(aluno==null) {
            System.out.println("Não existe aluno cadastrado na faculdade com esse id");
        }

        return aluno;
    }

}
