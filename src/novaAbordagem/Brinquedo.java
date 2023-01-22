package novaAbordagem;

public class Brinquedo extends Produto {

    private String tipo;

    public Brinquedo(String id, String nome, Double preco, String tipo){
        super(id, nome, preco);
        this.tipo = tipo;
    }

    public Brinquedo(String id, String nome, Double preco){
        super(id, nome, preco);
    }

    public Brinquedo(){}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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
