package csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import java.util.Set;

import entidades.Aluno;
import entidades.Curso;
import entidades.Matricula;

public class ManipularCsv {
  private String saveAluno;

  private void saveAlunos(Set<Aluno> alunoOutput){
    try (
      OutputStream outputSream = new FileOutputStream(this.saveAluno);
      OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputSream, StandardCharsets.UTF_8);
      PrintWriter printWriter = new PrintWriter(outputStreamWriter, true);
      ){
          for (Aluno aluno : alunoOutput) {
            printWriter.println(aluno.getId() + "," + aluno.getNome());
          }

    } catch(IOException error){
      error.printStackTrace();
    }
  }

}
