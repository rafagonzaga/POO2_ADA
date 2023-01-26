package novaAbordagem;

import novaAbordagem.enums.GeneroLiterario;

public class Livro extends Produto {

    private GeneroLiterario genero;
    private String escritor;
    private String editora;

    public Livro(String id, String nome, Double preco, GeneroLiterario genero, String escritor, String editora){
        super(id, nome, preco);
        this.genero = genero;
        this.escritor = escritor;
        this.editora = editora;
    }

    public Livro(String id, String nome, Double preco){
        super(id, nome, preco);
    }

    public Livro(){}

    public GeneroLiterario getGenero() {
        return genero;
    }

    public void setGenero(GeneroLiterario genero) {
        this.genero = genero;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id='" + super.getId() + '\'' +
                ", nome='" + super.getNome() + '\'' +
                ", preco=" + super.getPreco() +
                ", gênero='" + genero + '\'' +
                ", escritor='" + escritor + '\'' +
                ", editora='" + editora + '\'' +
                '}';
    }

}
