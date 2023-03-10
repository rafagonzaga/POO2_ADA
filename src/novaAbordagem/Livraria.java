package novaAbordagem;

import novaAbordagem.enums.Categoria;

import java.util.Map;
import java.util.Scanner;

import static novaAbordagem.Caixa.getSaldo;

public class Livraria {

    public static <T extends Produto> void consultarProduto(Estoque<T> estoque, T produto) {
        estoque.verProduto(produto);
    }

    public static void listarTodosProdutos(Map<Categoria, Estoque<? extends Produto>> estoques) {
        for (Map.Entry<Categoria, Estoque<? extends Produto>> lista : estoques.entrySet()) {
            System.out.println("Categoria: " + lista.getKey());
            lista.getValue().listarProdutos();
        }
    }

    public static Produto consultarProdutoPorID(Map<Categoria, Estoque<? extends Produto>> estoques, String id) {
        for (Map.Entry<Categoria, Estoque<? extends Produto>> lista : estoques.entrySet()) {
            if(lista.getValue().pesquisarPorId(id) != null){
                Produto produto = lista.getValue().pesquisarPorId(id);
                System.out.print(produto);
                System.out.println(" Em estoque: " + lista.getValue().getProdutos().get(produto));
                return produto;
            }
        }
        return null;
    }

    public static Categoria obterCategoria(Map<Categoria, Estoque<? extends Produto>> estoques, String id) {
        for (Map.Entry<Categoria, Estoque<? extends Produto>> lista : estoques.entrySet()) {
            if(lista.getValue().pesquisarPorId(id) != null){

                return lista.getKey();
            }
        }
        return null;
    }

    public static void listaCategoriasDeProdutos() {
        int index = 1;
        for (Categoria categoria : Categoria.values()) {
            System.out.println(index + " - " + categoria);
            index++;
        }
    }

    public static Integer escolherQuantidade(Scanner entrada){
        System.out.println("Quantos produtos deseja adicionar: ");
        return entrada.nextInt();
    }

    public static Categoria escolherCategoria(Scanner entrada) {
        listaCategoriasDeProdutos();
        System.out.println("Escolha a categoria:");
        Categoria categoria = null;
        int escolha = entrada.nextInt();
        entrada.nextLine();
        switch (escolha) {
            case 1 -> categoria = Categoria.LIVRO;
            case 2 -> categoria = Categoria.FILME;
            case 3 -> categoria = Categoria.JOGO;
            case 4 -> categoria = Categoria.BRINQUEDO;
            case 5 -> categoria = Categoria.ALBUM_DE_MUSICA;
        }
        return categoria;
    }

    public static void listarProdutosPorCategoria(Map<Categoria, Estoque<? extends Produto>> estoques, Categoria categoria) {
        for (Map.Entry<Categoria, Estoque<? extends Produto>> lista : estoques.entrySet()) {
            if (categoria.equals(lista.getKey())) {
                System.out.println("Categoria: " + lista.getKey());
                lista.getValue().listarProdutos();
            }
        }
    }

    public static <T extends Produto> void venderProduto(Estoque<T> estoque, T produto, Integer quantidade) {
        if (!estoque.getProdutos().containsKey(produto)) {
            return;
        }
        if (quantidade < 1) {
            System.out.println("Imposs??vel vender a quantidade pretendida.");
            return;
        }
        Integer quantidadeEmEstoque = estoque.produtos.get(produto);
        if (estoque.getProdutos().get(produto) >= quantidade) {
            Double valorDaVenda = produto.getPreco() * quantidade;
            Caixa.setSaldo(getSaldo() + valorDaVenda);
            estoque.removerProduto(produto, quantidade);
        } else {
            System.out.println("Quantidade indispon??vel para venda.");
            System.out.println("Quantidade em estoque: " + quantidadeEmEstoque);
        }
    }

    public static <T extends Produto> void cadastrarProduto(Estoque<T> estoque, Scanner entrada) {
        switch (obterTipoEstoque(estoque)) {
            case "Livro":
                System.out.println("?? livro");
                estoque.adicionarProduto((T) Util.cadastrarLivro(entrada), Livraria.escolherQuantidade(entrada));
                break;
            case "Filme":
                System.out.println("?? filme");
                estoque.adicionarProduto((T) Util.cadastrarFilme(entrada), Livraria.escolherQuantidade(entrada));
                break;
            case "Jogo":
                System.out.println("?? jogo");
                estoque.adicionarProduto((T) Util.cadastrarJogo(entrada), Livraria.escolherQuantidade(entrada));
                break;
            case "Brinquedo":
                System.out.println("?? brinquedo");
                estoque.adicionarProduto((T) Util.cadastrarBrinquedo(entrada), Livraria.escolherQuantidade(entrada));
                break;
            case "AlbumDeMusica":
                System.out.println("?? m??sica");
                estoque.adicionarProduto((T) Util.cadastrarAlbumDeMusica(entrada), Livraria.escolherQuantidade(entrada));
                break;
        }
    }

    public static <T extends Produto> Estoque<? extends Produto> escolherEstoque(Map<Categoria, Estoque<? extends Produto>> estoques, Categoria categoria){
        return estoques.get(categoria);
    }

    public static <T extends Produto> String obterTipoEstoque(Estoque<T> estoque) {
        if (!estoque.getProdutos().isEmpty()) {
            for (T prod : estoque.getProdutos().keySet()) {
                return prod.getClass().getSimpleName();
            }
        }
        return null;
    }

}
