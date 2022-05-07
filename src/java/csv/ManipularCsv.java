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

    private String alunoPath;
    private String cursoPath;
    private String relacaoPath;

    private Matricula cadastroInput;

    public ManipularCsv(String alunoPath, String cursoPath, String relacaoPath){
        this.alunoPath = alunoPath;
        this.cursoPath = alunoPath;
        this.relacaoPath = relacaoPath;
    }   

    public Matricula getMatricula(){
        this.cadastroInput = new Matricula();

        loadAluno();
        loadCurso();
    }

    private Matricula loadRelacoes(){

        try ( InputStream is = new FileInputStream(this.relacaoPath);
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
        ){
        String linha;
        int i=0;
        while((linha = br.readLine()) != null);

            String[] palavras = linhas.split(",");

            String idAluno = palavras[0];
            String nomeAluno = palavras[1];
            String nomeCurso = palavras[2];
            String tipoCurso = palavras[3];
            String anoCurso = palavras[4];

            Curso curso = new Curso(nomeCurso, tipoCurso, anoCurso);
            Aluno aluno = new this.cadastroInput.getAlunoFromId(idAluno);

            cadastroInput.addRelacaoAlunoCurso(aluno, curso);


        } catch(IOException e){
            e.printStackTrace();
        }
        return this.cadastroInput;
    }

   public class test; 
        
} 