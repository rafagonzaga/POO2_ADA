package novaAbordagem;

import novaAbordagem.enums.TipoBrinquedo;

public class Brinquedo extends Produto {

    private TipoBrinquedo tipo;

    public Brinquedo(String id, String nome, Double preco, TipoBrinquedo tipo){
        super(id, nome, preco);
        this.tipo = tipo;
    }

    public Brinquedo(String id, String nome, Double preco){
        super(id, nome, preco);
    }

    public Brinquedo(){}

    public TipoBrinquedo getTipo() {
        return tipo;
    }

    public void setTipo(TipoBrinquedo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Brinquedo{" +
                "id='" + super.getId() + '\'' +
                ", nome='" + super.getNome() + '\'' +
                ", preco=" + super.getPreco() +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
