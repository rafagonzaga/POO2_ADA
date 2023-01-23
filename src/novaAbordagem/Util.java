package novaAbordagem;

import novaAbordagem.enums.*;

import java.util.Scanner;

public class Util {

    public static Livro cadastrarLivro(Scanner entrada) {
        Livro livro = new Livro();

        System.out.print("Digite o id: ");
        String id = entrada.next();
        entrada.nextLine();
        livro.setId(id);

        System.out.print("Digite o nome do livro: ");
        String nome = entrada.nextLine();
        livro.setNome(nome);

        System.out.print("Digite o preço: ");
        Double preco = entrada.nextDouble();
        livro.setPreco(preco);
        entrada.nextLine();

        System.out.print("Escolha o gênero: ");
        int index = 1;
        System.out.println();
        for (GeneroLiterario genero : GeneroLiterario.values()) {
            System.out.println(index + " - " + genero);
            index++;
        }
        int escolha = entrada.nextInt();
        entrada.nextLine();
        GeneroLiterario genero = switch (escolha) {
            case 1 -> GeneroLiterario.ROMANCE;
            case 2 -> GeneroLiterario.FICCAO;
            case 3 -> GeneroLiterario.POLICIAL;
            case 4 -> GeneroLiterario.AUTO_AJUDA;
            case 5 -> GeneroLiterario.INFANTIL;
            default -> null;
        };
        livro.setGenero(genero);

        System.out.print("Digite o nome do escritor: ");
        String escritor = entrada.nextLine();
        livro.setEscritor(escritor);

        System.out.print("Digite a editora: ");
        String editora = entrada.nextLine();
        livro.setEditora(editora);

        return livro;
    }

    public static Filme cadastrarFilme(Scanner entrada) {
        Filme filme = new Filme();

        System.out.print("Digite o id: ");
        String id = entrada.next();
        entrada.nextLine();
        filme.setId(id);

        System.out.print("Digite o nome do filme: ");
        String nome = entrada.nextLine();
        filme.setNome(nome);

        System.out.print("Digite o preço: ");
        Double preco = entrada.nextDouble();
        filme.setPreco(preco);
        entrada.nextLine();

        System.out.print("Digite o estúdio: ");
        String estudio = entrada.nextLine();
        filme.setEstudio(estudio);

        System.out.print("Digite os diretores: ");
        String diretores = entrada.nextLine();
        filme.setDiretores(diretores);

        System.out.print("Escolha o gênero: ");
        int index = 1;
        System.out.println();
        for (GeneroFilme genero : GeneroFilme.values()) {
            System.out.println(index + " - " + genero);
            index++;
        }
        int escolha = entrada.nextInt();
        entrada.nextLine();

        GeneroFilme genero = switch (escolha) {
            case 1 -> GeneroFilme.ROMANCE;
            case 2 -> GeneroFilme.COMEDIA;
            case 3 -> GeneroFilme.AVENTURA;
            case 4 -> GeneroFilme.GUERRA;
            case 5 -> GeneroFilme.INFANTIL;
            default -> null;
        };
        filme.setGenero(genero);

        System.out.print("Digite os produtores: ");
        String produtores = entrada.nextLine();
        filme.setProdutores(produtores);

        return filme;
    }

    public static Jogo cadastrarJogo(Scanner entrada) {
        Jogo jogo = new Jogo();

        System.out.print("Digite o id: ");
        String id = entrada.next();
        entrada.nextLine();
        jogo.setId(id);

        System.out.print("Digite o nome do jogo: ");
        String nome = entrada.nextLine();
        jogo.setNome(nome);

        System.out.print("Digite o preço: ");
        Double preco = entrada.nextDouble();
        jogo.setPreco(preco);
        entrada.nextLine();

        System.out.print("Digite a distribuidora: ");
        String distribuidora = entrada.nextLine();
        jogo.setDistribuidora(distribuidora);

        System.out.print("Escolha o gênero: ");
        int index = 1;
        System.out.println();
        for (GeneroJogo genero : GeneroJogo.values()) {
            System.out.println(index + " - " + genero);
            index++;
        }
        String genero = entrada.nextLine();
        jogo.setGenero(genero);

        System.out.print("Digite o estúdio: ");
        String estudio = entrada.nextLine();
        jogo.setEstudio(estudio);

        return jogo;
    }

    public static Brinquedo cadastrarBrinquedo(Scanner entrada) {
        Brinquedo brinquedo = new Brinquedo();

        System.out.print("Digite o id: ");
        String id = entrada.next();
        entrada.nextLine();
        brinquedo.setId(id);

        System.out.print("Digite o nome do brinquedo: ");
        String nome = entrada.nextLine();
        brinquedo.setNome(nome);

        System.out.print("Digite o preço: ");
        Double preco = entrada.nextDouble();
        brinquedo.setPreco(preco);
        entrada.nextLine();

        System.out.print("Escolha o tipo: ");
        int index = 1;
        System.out.println();
        for (TipoBrinquedo tipoBrinquedo : TipoBrinquedo.values()) {
            System.out.println(index + " - " + tipoBrinquedo);
            index++;
        }
        String tipo = entrada.nextLine();
        brinquedo.setTipo(tipo);

        return brinquedo;
    }

    public static AlbumDeMusica cadastrarAlbumDeMusica(Scanner entrada) {
        AlbumDeMusica albumDeMusica = new AlbumDeMusica();

        System.out.print("Digite o id: ");
        String id = entrada.next();
        entrada.nextLine();
        albumDeMusica.setId(id);

        System.out.print("Digite o nome do álbum: ");
        String nome = entrada.nextLine();
        albumDeMusica.setNome(nome);

        System.out.print("Digite o preço: ");
        Double preco = entrada.nextDouble();
        albumDeMusica.setPreco(preco);
        entrada.nextLine();

        System.out.print("Digite os musicos: ");
        String musicos = entrada.nextLine();
        albumDeMusica.setMusicos(musicos);

        System.out.print("Escolha o gênero: ");
        int index = 1;
        System.out.println();
        for (GeneroMusica genero : GeneroMusica.values()) {
            System.out.println(index + " - " + genero);
            index++;
        }
        String genero = entrada.nextLine();
        albumDeMusica.setGenero(genero);

        System.out.print("Digite os selos: ");
        String selos = entrada.nextLine();
        albumDeMusica.setSelos(selos);

        return albumDeMusica;
    }

}
