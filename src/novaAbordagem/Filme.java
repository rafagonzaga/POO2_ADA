package novaAbordagem;

import novaAbordagem.enums.GeneroFilme;

public class Filme extends Produto {

    private String estudio;
    private String diretores;
    private GeneroFilme genero;
    private String produtores;


    public Filme(String id, String nome, Double preco, String estudio, String diretores, GeneroFilme genero, String produtores) {
        super(id, nome, preco);
        this.estudio = estudio;
        this.diretores = diretores;
        this.genero = genero;
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

    public GeneroFilme getGenero() {
        return genero;
    }

    public void setGenero(GeneroFilme genero) {
        this.genero = genero;
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
                ", genero='" + genero + '\'' +
                ", produtores='" + produtores + '\'' +
                '}';
    }
}