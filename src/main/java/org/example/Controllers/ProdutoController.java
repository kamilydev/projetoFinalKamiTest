package org.example.Controllers;

import org.example.Model.Alimento;
import org.example.Model.Eletronico;
import org.example.Model.Produto;
import org.example.Model.Roupa;

import java.util.Scanner;

public class ProdutoController {
    private Scanner scanner;

    public ProdutoController(Scanner scanner) {
        this.scanner = scanner;
    }

    public Produto criarProduto(int tipoProduto) {
        scanner.nextLine(); // Consumir a nova linha
        switch (tipoProduto) {
            case 1:
                return criarEletronico();
            case 2:
                return criarRoupa();
            case 3:
                return criarAlimento();
            default:
                System.out.println("Tipo de produto inválido. Tente novamente.");
                return null;
        }
    }

    private Eletronico criarEletronico() {
        System.out.print("Digite o nome do eletrônico: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do eletrônico: ");
        double preco = scanner.nextDouble();

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite a garantia em meses: ");
        int garantiaMeses = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        return new Eletronico(nome, preco, garantiaMeses, quantidade);
    }

    private Roupa criarRoupa() {
        System.out.print("Digite o nome da roupa: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço da roupa: ");
        double preco = scanner.nextDouble();

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Digite o tamanho da roupa: ");
        String tamanho = scanner.nextLine();

        System.out.print("Digite a cor da roupa: ");
        String cor = scanner.nextLine();

        return new Roupa(nome, preco, tamanho, cor, quantidade);
    }

    private Alimento criarAlimento() {
        System.out.print("Digite o nome do alimento: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do alimento: ");
        double preco = scanner.nextDouble();

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Digite a data de validade do alimento: ");
        String dataValidade = scanner.nextLine();

        return new Alimento(nome, preco, dataValidade, quantidade);
    }
}
