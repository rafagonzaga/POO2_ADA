package novaAbordagem;

import java.util.HashMap;
import java.util.Map;

public class Estoque<T extends Produto> {

    Map<T, Integer> produtos = new HashMap<>();

    public void adicionarProduto(T produto, Integer quantidade) {
        if (produtos.containsKey(produto)) {
            Integer qtd = produtos.get(produto);
            produtos.put(produto, qtd + quantidade);
        } else {
            produtos.put(produto, quantidade);
        }
        System.out.println("Produto cadastrado:");
        System.out.println(produto);
    }

    public void removerProduto(T produto, Integer quantidade) {
        if (!produtos.containsKey(produto)) {
            return;
        }
        if (quantidade < 1) {
            System.out.println("Impossível remover a quantidade pretendida.");
            return;
        }
        Integer quantidadeEmEstoque = produtos.get(produto);
        if (produtos.get(produto) > quantidade) {
            produtos.put(produto, quantidadeEmEstoque - quantidade);
        } else if(produtos.get(produto) == quantidade){
          produtos.remove(produto);
        } else {
            System.out.println("Impossível remover a quantidade pretendida.");
            System.out.println("Quantidade em estoque: " + quantidadeEmEstoque);
        }
    }


    public void listarProdutos() {
        for (Map.Entry<T, Integer> pair : produtos.entrySet()) {
            System.out.println(pair.getKey() + ": Em estoque: " + pair.getValue());
            //System.out.println(" : " + pair.getValue());
        }
    }

    public T alterarProduto(T produtoAtual, T produtoAlterado){
        if(produtos.containsKey(produtoAtual)){
            Integer quantidade = produtos.get(produtoAtual);
            produtoAlterado.setId(produtoAtual.getId()); // Para manter o id do produto alterado
            produtos.remove(produtoAtual);
            produtos.put(produtoAlterado, quantidade);

            return produtoAtual;
        }
        return null;
    }

    public T pesquisarPorId(String id) {
        for (Map.Entry<T, Integer> pair : produtos.entrySet()) {
            if (pair.getKey().getId().equals(id)) {
                return pair.getKey();
            }
        }
        return null;
    }

//    public T pesquisarPorId(String id) {
//        for (Map.Entry<T, Integer> pair : produtos.entrySet()) {
//            if (pair.getKey().getId().equals(id)) {
//                return pair.getKey();
//            }
//        }
//        return null;
//    }

    public void verProduto(T produto) {
        if (!produtos.containsKey(produto)) {
            System.out.println("Livro não consta na base de dados");
            return;
        }
        System.out.println("Exibindo o produto...");
        System.out.println(produto);
    }

    public Map<T, Integer> getProdutos() {
        return produtos;
    }

    public void setProdutos(Map<T, Integer> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "produtos=" + produtos +
                '}';
    }
}
