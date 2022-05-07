package entidades;

public class RendimentoCurso extends Curso {

    // ATRIBUTOS

    private String id;
    private float np1;
    private float np2;
    private float sub;
    private float exame;

    // CONSTRUCTOR

    public RendimentoCurso(String nome, String tipo, String ano, Aluno id, float np1, float np2, float sub, float exame) {
        super(nome, tipo, ano);
        this.id = id.getId();
        this.np1 = np1;
        this.np2 = np2;
        this.sub = sub;
        this.exame = exame;
    }

    // GET E SET

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getNp1() {
        return np1;
    }

    public void setNp1(float np1) {
        this.np1 = np1;
    }

    public float getNp2() {
        return np2;
    }

    public void setNp2(float np2) {
        this.np2 = np2;
    }

    public float getSub() {
        return sub;
    }

    public void setSub(float sub) {
        this.sub = sub;
    }

    public float getExame() {
        return exame;
    }

    public void setExame(float exame) {
        this.exame = exame;
    }

    // TO STRING

    @Override
    public String toString() {
        
        return "RendimentoCurso{" +
                "id=" + id +
                ", np1=" + np1 +
                ", np2=" + np2 +
                ", sub=" + sub +
                ", exame=" + exame +
                '}';
    }
}
