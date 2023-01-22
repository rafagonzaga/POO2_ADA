package novaAbordagem;

public class Jogo extends Produto {

    private String distribuidora;
    private String genero;
    private String estudio;


    public Jogo(String id, String nome, Double preco, String estudio, String distribuidora, String genero) {
        super(id, nome, preco);
        this.distribuidora = distribuidora;
        this.estudio = estudio;
        this.genero = genero;
    }

    public Jogo() {
    }

    public Jogo(String id, String nome, Double preco) {
        super(id, nome, preco);
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "id='" + super.getId() + '\'' +
                ", nome='" + super.getNome() + '\'' +
                ", preco=" + super.getPreco() +
                ", distribuidora='" + distribuidora + '\'' +
                ", genero='" + genero + '\'' +
                ", estudio='" + estudio + '\'' +
                '}';
    }
}