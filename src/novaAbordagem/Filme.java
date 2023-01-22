package novaAbordagem;

public class Filme extends Produto {

    private String estudio;
    private String diretores;
    private String generos;
    private String produtores;


    public Filme(String id, String nome, Double preco, String estudio, String diretores, String generos, String produtores) {
        super(id, nome, preco);
        this.estudio = estudio;
        this.diretores = diretores;
        this.generos = generos;
        this.produtores = produtores;
    }

    public Filme() {
    }

    public Filme(String id, String nome, Double preco) {
        super(id, nome, preco);
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getDiretores() {
        return diretores;
    }

    public void setDiretores(String diretores) {
        this.diretores = diretores;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    public String getProdutores() {
        return produtores;
    }

    public void setProdutores(String produtores) {
        this.produtores = produtores;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id='" + super.getId() + '\'' +
                ", nome='" + super.getNome() + '\'' +
                ", preco=" + super.getPreco() +
                ", estudio='" + estudio + '\'' +
                ", diretores='" + diretores + '\'' +
                ", generos='" + generos + '\'' +
                ", produtores='" + produtores + '\'' +
                '}';
    }
}