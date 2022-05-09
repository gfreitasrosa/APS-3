package entidades;

public class Curso {

    // ATRIBUTOS

    private String nome;
    private String tipo;
    private String ano;

    // CONSTRUCTOR

    public Curso(String nome, String tipo, String ano) {
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
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

    // HASH CODE

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ano == null) ? 0 : ano.hashCode());
        return result;
    }

    // EQUALS
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Curso other = (Curso) obj;
        if ((ano == null) || (tipo == null) || (nome == null)) {
            if ((other.ano != null) && (other.tipo != null) & (other.nome != null))
                return false;
        } else if (!ano.equals(other.ano) && (!tipo.equals(other.tipo)) && (!nome.equals(other.tipo)))
            return false;
        return true;
    }
    
}
