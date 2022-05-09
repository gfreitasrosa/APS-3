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
  
    private String alunoDir;
    private String cursoDir;
    private String relacaoDir;

    private Matricula cadastroInput;

    public ManipularCsv(String alunoDir, String cursoDir, String relacaoDir){
        this.alunoDir = alunoDir;
        this.cursoDir = alunoDir;
        this.relacaoDir = relacaoDir;
    }   

    public Matricula getMatricula(){
        this.cadastroInput = new Matricula();


        return loadRelacoes();
    }

    private Matricula loadRelacoes(){

        try ( InputStream is = new FileInputStream(this.relacaoDir);
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
        ){
            String linha;
            int i=0;
            while((linha = br.readLine()) != null) {

                String[] palavras = linha.split(",");

                String idAluno = palavras[0];
                String nomeAluno = palavras[1];
                String nomeCurso = palavras[2];
                String tipoCurso = palavras[3];
                String anoCurso = palavras[4];

                Curso curso = new Curso(nomeCurso, tipoCurso, anoCurso);
                Aluno aluno = this.cadastroInput.getAlunoFromId(idAluno);

                cadastroInput.addRelacaoAlunoCurso(aluno, curso);
            }

        } catch(IOException e){
            e.printStackTrace();
        }
        return this.cadastroInput;
    }
        
  private void saveAlunos(Set<Aluno> alunoOutput){
    try (
      OutputStream outputSream = new FileOutputStream(this.alunoDir);
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


