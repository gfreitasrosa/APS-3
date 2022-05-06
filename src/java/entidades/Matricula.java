package entidades;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Matricula {
    
        Map<Aluno, Set<Curso>> Alunos = new TreeMap<>();
        Map<Curso, Set<Aluno>> Cursos = new TreeMap<>();

        Map<String, Aluno> AlunosById = new TreeMap<>();

        public Aluno getAlunoFromId(String id) {
            return AlunosById.get(id);
        }

        public Set<Aluno> getAlunos() {
            return Alunos.keySet();
        }
        public void addAluno(Aluno Aluno) {
            this.Alunos.put(Aluno, new TreeSet<>());
            this.AlunosById.put(Aluno.getId(), Aluno);
        }

        public Set<Curso> getCursos() {
            return Cursos.keySet();
        }
        public void addCurso(Curso Curso) {
            this.Cursos.put(Curso, new TreeSet<>());
        }

        public Set<Curso> getCursosFromAluno(String id) {
            return Alunos.get(new Aluno(id, ""));
        }
        public Set<Aluno> getAlunosFromCurso(Curso Curso) {
            return Cursos.get(Curso);
        }

        public void addRelacaoAlunoCurso(Aluno Aluno, Curso Curso) {
            this.Cursos.get(Curso).add(Aluno);
            this.Alunos.get(Aluno).add(Curso);
        }

}

