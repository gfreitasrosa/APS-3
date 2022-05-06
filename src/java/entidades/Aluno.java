package entidades;


public class Aluno {

    // ATRIBUTOS

    private String id;
    private String nome;

    // CONSTRUCTOR

    public Aluno(String id, String nome) {

        this.id = id;
        this.nome = nome;
    }

    // GET E SET

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // TO STRING

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

}
