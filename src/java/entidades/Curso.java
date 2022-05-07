package entidades;

public class Curso {

    // ATRIBUTOS

    private String nome;
    private String tipo;
    private String ano;

    // CONSTRUCTOR

    public Curso(String nome, String tipo, int ano) {
        this.nome = nome;
        this.tipo = tipo;
        this.ano = ano;
    }

    // GET E SET

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    // TO STRING

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", ano=" + ano +
                '}';
    }
}
