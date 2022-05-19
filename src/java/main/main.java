package main;

import interfaces.*;
import entidades.*;
import csv.*;
import menu.*;

public class main {
    public static void main(String[] args) {

        String alunoDir = "files/alunos.csv";
        String cursoDir = "files/cursos.csv";
        String matriculaDir = "files/matricula.csv";

        Sistema sistema = new Cli();
        ManipularCsv csv = new ManipularCsv(alunoDir, cursoDir, matriculaDir);
        new ControllMenu(sistema,csv).iniciar();

    }
}
