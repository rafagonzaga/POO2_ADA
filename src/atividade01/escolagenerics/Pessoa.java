package atividade01.escolagenerics;

public class Pessoa implements Comparable<Pessoa>{

    private String nome;

    public Pessoa(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int compareTo(Pessoa other) {
        return nome.toLowerCase().compareTo(other.getNome().toLowerCase());
    }
}
