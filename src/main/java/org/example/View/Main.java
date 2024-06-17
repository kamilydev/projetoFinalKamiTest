package org.example.View;
import org.example.Controllers.CarrinhoController;
import org.example.Controllers.ProdutoController;
import org.example.Model.CarrinhoDeCompras;
import org.example.Model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<CarrinhoDeCompras> listaCarrinhos = new ArrayList<>();
    private static final CarrinhoController carrinhoController;
    private static final ProdutoController produtoController;

    static {
        listaCarrinhos.add(new CarrinhoDeCompras());
        listaCarrinhos.add(new CarrinhoDeCompras());
        carrinhoController = new CarrinhoController(listaCarrinhos);
        produtoController = new ProdutoController(scanner);
    }

    public static void main(String[] args) {
        while (true) {
            exibirMenuPrincipal();

            int opcao = obterOpcao();
            if (opcao == 0) {
                System.out.println("Programa encerrado.");
                break;
            }

            switch (opcao) {
                case 1:
                    adicionarProdutoAoCarrinho();
                    break;
                case 2:
                    listarProdutosDoCarrinho();
                    break;
                case 3:
                    gerarArquivoDeTexto();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n### SISTEMA DE VENDAS DE PRODUTOS ###");
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println("## O que deseja executar? ##");
        System.out.println("Opção 1 - Adicionar produto ao carrinho");
        System.out.println("Opção 2 - Listar produtos do carrinho");
        System.out.println("Opção 3 - Gerar arquivo de texto do carrinho");
        System.out.println("Opção 0 - Encerrar programa");
        System.out.println("_____________________________________________________________________________________________________");
        System.out.print("Escolha uma opção: ");
    }

    private static int obterOpcao() {
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        return opcao;
    }

    private static int escolherCarrinho() {
        System.out.println("Escolha o carrinho (1 ou 2): ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (escolha < 1 || escolha > 2) {
            System.out.println("Carrinho inválido. Tente novamente.");
            return -1;
        }

        return escolha - 1;
    }

    private static void adicionarProdutoAoCarrinho() {
        System.out.println("Escolha o tipo de produto a adicionar: ");
        System.out.println("1. Eletrônico");
        System.out.println("2. Roupa");
        System.out.println("3. Alimento");

        int tipoProduto = scanner.nextInt();
        Produto produto = produtoController.criarProduto(tipoProduto);
        if (produto == null) return;

        int carrinhoEscolhido = escolherCarrinho();
        if (carrinhoEscolhido == -1) return;

        carrinhoController.adicionarProdutoAoCarrinho(carrinhoEscolhido, produto);
    }

    private static void listarProdutosDoCarrinho() {
        int carrinhoEscolhido = escolherCarrinho();
        if (carrinhoEscolhido == -1) return;

        carrinhoController.listarProdutosDoCarrinho(carrinhoEscolhido);
    }

    private static void gerarArquivoDeTexto() {
        int carrinhoEscolhido = escolherCarrinho();
        if (carrinhoEscolhido == -1) return;

        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String nomeArquivo = scanner.nextLine();

        carrinhoController.gerarArquivoDeTexto(carrinhoEscolhido, nomeArquivo);
    }
}
