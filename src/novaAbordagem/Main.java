package novaAbordagem;

import novaAbordagem.enums.Categoria;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Map<Categoria, Estoque<? extends Produto>> estoques = new HashMap<>();

        Caixa caixa = new Caixa(5000.);
//        System.out.println("Saldo inicial:");
//        System.out.println(Caixa.getSaldo());

        Estoque<Livro> livros = new Estoque<>();
        Livro livro1 = new Livro("1", "Comer, rezar, amar", 35.9);
        Livro livro2 = new Livro("2", "Jantar secreto", 50.0);
        livros.adicionarProduto(livro1, 10);
        livros.adicionarProduto(livro2, 20);

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


//        System.out.println("Saldo final do caixa:");



        System.out.println("\nBem-vindo ao sistema da Livraria.");

        Boolean ativo = true;


        do {

            System.out.println("\nEssas são as suas opções iniciais:");
            System.out.println("1 - Ver todos os produtos");
            System.out.println("2 - Listar produto por categoria");
            System.out.println("3 - Consultar produto por id");
            System.out.println("4 - Adicionar um produto");
            System.out.println("5 - Vender um produto");
            System.out.println("9 - Ver o saldo do caixa");
            System.out.println("0 - Sair do sistema");


            System.out.print("\nO que deseja fazer: ");
            int escolha = entrada.nextInt();
            entrada.nextLine();
            switch (escolha) {
                case 1:
                    Livraria.listarTodosProdutos(estoques);
                    break;
                case 2:
                    Livraria.listarProdutosPorCategoria(estoques, Livraria.escolherCategoria(entrada));
                    break;
                case 3:
                    System.out.print("Digite o ID para pesquisar: ");
                    String idProcurado = entrada.next();
                    entrada.nextLine();
                    Livraria.consultarProdutoPorID(estoques, idProcurado);
                    break;
                case 4:
                    System.out.println("Essas são as categorias de produtos.");
                    Categoria categoria = Livraria.escolherCategoria(entrada);
                    Livraria.cadastrarProduto(Livraria.escolherEstoque(estoques, categoria), entrada);
                    break;
                case 5:
//                    System.out.println("Essas são as categorias de produtos.");
//                    categoria = Livraria.escolherCategoria(entrada);
                    System.out.print("Digite o ID para pesquisar: ");
                    idProcurado = entrada.next();
                    entrada.nextLine();
                    Produto produto = Livraria.consultarProdutoPorID(estoques, idProcurado);
                    categoria = Livraria.obterCategoria(estoques, idProcurado);
                    Estoque estoqueEspecifico = Livraria.escolherEstoque(estoques, categoria);
                    System.out.print("Vender quantos itens: ");
                    int quantidade = entrada.nextInt();
                    entrada.nextLine();
                    Livraria.venderProduto(estoqueEspecifico, produto, quantidade);

                    //Livraria.cadastrarProduto(Livraria.escolherEstoque(estoques, categoria), entrada);
                    break;
                case 9:
                    System.out.println("Saldo do caixa: " + Caixa.getSaldo());
                    break;
                case 0:
                    ativo = false;
                    break;


            }
            System.out.println("\n'ENTER' para exibir o menu inicial ou '0' para sair");
            String controle = entrada.nextLine();
            if(controle.equals("0"))break;

        } while (ativo);


        entrada.close();
        System.out.println("Saldo final do caixa:" + Caixa.getSaldo());
    }
}
