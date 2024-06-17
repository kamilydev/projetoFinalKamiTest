package org.example.Model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Produto> produtos;

    public CarrinhoDeCompras() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarItem(Produto produto) {
        produtos.add(produto);
    }

    public void listarItens() {
        if (produtos.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.calcularPrecoTotal();
        }
        return total;
    }

    public void gerarArquivoTexto(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Produto produto : produtos) {
                writer.println(produto);
            }
            writer.printf("Total: %.2f%n", calcularTotal());
        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo: " + e.getMessage());
        }
    }
}
