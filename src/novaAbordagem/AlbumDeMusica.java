package novaAbordagem;

import novaAbordagem.enums.GeneroMusica;

public class AlbumDeMusica extends Produto {

    private String musicos;
    private GeneroMusica genero;
    private String selos;


    public AlbumDeMusica(String id, String nome, Double preco, String selos, String musicos, GeneroMusica genero) {
        super(id, nome, preco);
        this.musicos = musicos;
        this.selos = selos;
        this.genero = genero;
    }

    public AlbumDeMusica() {
    }

    public AlbumDeMusica(String id, String nome, Double preco) {
        super(id, nome, preco);
    }

    public String getSelos() {
        return selos;
    }

    public void setSelos(String selos) {
        this.selos = selos;
    }

    public String getMusicos() {
        return musicos;
    }

    public void setMusicos(String musicos) {
        this.musicos = musicos;
    }

    public GeneroMusica getGenero() {
        return genero;
    }

    public void setGenero(GeneroMusica genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Album de Música{" +
                "id='" + super.getId() + '\'' +
                ", nome='" + super.getNome() + '\'' +
                ", preco=" + super.getPreco() +
                ", músicos='" + musicos + '\'' +
                ", gênero='" + genero + '\'' +
                ", selos='" + selos + '\'' +
                '}';
    }
}