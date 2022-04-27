package com.example.aps;


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class TesteSistema {

    public static void lerCSV(ArrayList<Aluno> lista){


        String path = "alunos.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            line = br.readLine();
            while (line != null){

                String[] vect = line.split(",");
                String id = vect[0];
                String name = vect[1];

                lista.add(new Aluno(id, name));

                line = br.readLine();

            }

            for (Aluno aluno : lista) {
                System.out.println(aluno);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void escreverCSV(ArrayList<Aluno> lista){

        String path = "alunos.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path)) ; BufferedWriter bw = new BufferedWriter(new FileWriter(path, true)); PrintWriter pw = new PrintWriter(bw);) {
            String line = br.readLine();

                for (Aluno aluno : lista) {

                    pw.println(aluno.getId() + "," + aluno.getNome());
                    pw.flush();

                }
                pw.close();

            JOptionPane.showMessageDialog(null, "Chamado salvo com sucesso !");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void main(String[] args) {

        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        alunos.add(new Aluno("w2322", "eeee"));



        escreverCSV(alunos);


    }
}
