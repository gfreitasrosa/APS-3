package csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCSV {
    public static void main(String args[]) {

        String aluno = "files/alunos.csv";
        String curso = "files/crusos.csv";
        String matricula ="files/matricula.csv";

        ManipularCsv csv = new ManipularCsv(aluno, curso, matricula);

        csv.getMatricula();

        System.out.println((csv.getMatricula()));







    }
}
