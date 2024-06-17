package org.example.Model;

public abstract class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double calcularPrecoTotal() {
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, Preço: %.2f, Quantidade: %d, Total: %.2f",
                nome, preco, quantidade, calcularPrecoTotal());
    }
}
