package novaAbordagem;

import novaAbordagem.enums.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static novaAbordagem.Caixa.getSaldo;

public class Livraria {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Map<Categoria, Estoque<? extends Produto>> estoques = new HashMap<>();

        Caixa caixa = new Caixa(5000.);
        System.out.println("Saldo inicial:");
        System.out.println(Caixa.getSaldo());

        Estoque<Livro> livros = new Estoque<>();
        Livro livro1 = new Livro("1", "Comer, rezar, amar", 35.9);
        Livro livro2 = new Livro("2", "Jantar secreto", 50.0);
        livros.adicionarProduto(livro1, 10);

        Estoque<Filme> filmes = new Estoque<>();
        Filme filme1 = new Filme("3", "Tubarão", 20.0);
        Filme filme2 = new Filme("4", "Avatar", 49.90);
        filmes.adicionarProduto(filme1, 5);
        filmes.adicionarProduto(filme2, 12);

        Estoque<Jogo> jogos = new Estoque<>();
        Jogo jogo1 = new Jogo("5", "Mario 3", 379.9);
        Jogo jogo2 = new Jogo("6", "Sonic", 199.9);
        jogos.adicionarProduto(jogo1, 5);
        jogos.adicionarProduto(jogo2, 10);

        Estoque<Brinquedo> brinquedos = new Estoque<>();
        Brinquedo brinquedo1 = new Brinquedo("7", "Carrinho", 40.);
        Brinquedo brinquedo2 = new Brinquedo("8", "Boneca", 22.5);
        brinquedos.adicionarProduto(brinquedo1, 25);
        brinquedos.adicionarProduto(brinquedo2, 30);

        Estoque<AlbumDeMusica> albuns = new Estoque<>();
        AlbumDeMusica album1 = new AlbumDeMusica("9", "Maria Rita", 19.);
        AlbumDeMusica album2 = new AlbumDeMusica("10", "Legião Urbana", 25.);
        albuns.adicionarProduto(album1, 50);
        albuns.adicionarProduto(album2, 18);


        estoques.put(Categoria.LIVRO, livros);
        estoques.put(Categoria.FILME, filmes);
        estoques.put(Categoria.JOGO, jogos);
        estoques.put(Categoria.BRINQUEDO, brinquedos);
        estoques.put(Categoria.ALBUM_DE_MUSICA,albuns);

        System.out.println(estoques.get(Categoria.LIVRO).getProdutos());
        livros.adicionarProduto(livro2, 20);
        System.out.println(estoques.get(Categoria.LIVRO).getProdutos());
//        livros.removerProduto(livro2, 5);

        System.out.println("\nVendendo  unidades do livro2");
        venderProduto(livros, livro2, 5);
        System.out.println("Saldo após a venda: " + Caixa.getSaldo());
        System.out.println();

        System.out.println(estoques.get(Categoria.LIVRO).getProdutos());
        estoques.get(Categoria.LIVRO).listarProdutos();

        for(Categoria categoria : Categoria.values()){
            System.out.println(categoria);
        }

        System.out.println("Saldo inicial:");
        System.out.println(Caixa.getSaldo());

        System.out.println("\n");
        listarTodosProdutos(estoques);
        System.out.println("\n");

        System.out.println("\nExibindo por categoria");
        listarProdutosPorCategoria(estoques, Categoria.FILME);
        System.out.println("\n");

        System.out.println("\nExibindo por categoria");
        listarProdutosPorCategoria(estoques, Categoria.JOGO);
        System.out.println("\n");

        System.out.println();


//        outro.verProduto(livro1);
        System.out.println(livros);

        livros.verProduto(livro1);
        System.out.println("___");
        Livro livro10 = new Livro("22", "Alterado", 15.25);
        System.out.println("Método consultar produto:");
        consultarProduto(livros, livro1);

        System.out.println(livros);
        livros.removerProduto(livro1, 8);
        System.out.println(livros);

        System.out.println("Método alterar produto:");
        System.out.println(livros.alterarProduto(livro2, livro10)); // o id do livro 2 permanecerá como "2"
        System.out.println(livros);


        System.out.println(filmes);
//        cadastrarProduto(filmes, entrada);
        System.out.println(filmes);

        System.out.println(obterTipoEstoque(livros));

        System.out.println("\nListando por categoria");
        listarProdutosPorCategoria(estoques, Categoria.BRINQUEDO);





        System.out.println("Pesquisando por ID:");
        System.out.println(livros.pesquisarPorId("2"));

        System.out.println(Caixa.getSaldo());

        entrada.close();
    }

    public static <T extends Produto> void consultarProduto(Estoque<T> estoque, T produto){
        estoque.verProduto(produto);
    }

    private static void listarTodosProdutos(Map<Categoria, Estoque<? extends Produto>> estoques) {
        for(Map.Entry<Categoria, Estoque<? extends Produto>> lista : estoques.entrySet()){
            System.out.println("Categoria: " + lista.getKey());
            lista.getValue().listarProdutos();
        }
    }

    private static void listarProdutosPorCategoria(Map<Categoria, Estoque<? extends Produto>> estoques, Categoria categoria) {
        for(Map.Entry<Categoria, Estoque<? extends Produto>> lista : estoques.entrySet()){
            if(categoria.equals(lista.getKey())){
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
            System.out.println("Impossível vender a quantidade pretendida.");
            return;
        }
        Integer quantidadeEmEstoque = estoque.produtos.get(produto);
        if (estoque.getProdutos().get(produto) >= quantidade) {
            Double valorDaVenda = produto.getPreco() * quantidade;
            Caixa.setSaldo(getSaldo() + valorDaVenda);
            estoque.removerProduto(produto, quantidade);
        } else {
            System.out.println("Quantidade indisponível para venda.");
            System.out.println("Quantidade em estoque: " + quantidadeEmEstoque);
        }
    }

    public static <T extends Produto> void cadastrarProduto(Estoque<T> estoque, Scanner entrada) {
        switch (obterTipoEstoque(estoque)){
            case "Livro":
                System.out.println("É livro");
                estoque.adicionarProduto((T) Util.cadastrarLivro(entrada), 10);
                break;
            case "Filme":
                System.out.println("É filme");
                estoque.adicionarProduto((T) Util.cadastrarFilme(entrada), 20);
                break;
            case "Jogo":
                System.out.println("É jogo");
                estoque.adicionarProduto((T) Util.cadastrarJogo(entrada), 10);
                break;
            case "Brinquedo":
                System.out.println("É brinquedo");
                estoque.adicionarProduto((T) Util.cadastrarBrinquedo(entrada), 15);
                break;
            case "AlbumDeMusica":
                System.out.println("É música");
                estoque.adicionarProduto((T) Util.cadastrarAlbumDeMusica(entrada), 40);
                break;
        }
    }

    public static <T extends Produto> String obterTipoEstoque(Estoque<T> estoque) {
        if(!estoque.getProdutos().isEmpty()){
            for(T prod : estoque.getProdutos().keySet()){
                return prod.getClass().getSimpleName();
            }
        }
        return null;
    }

}
