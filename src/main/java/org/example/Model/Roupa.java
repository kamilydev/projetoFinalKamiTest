package org.example.Model;

public class Roupa extends Produto {
    private String tamanho;
    private String cor;

    public Roupa(String nome, double preco, String tamanho, String cor, int quantidade) {
        super(nome, preco, quantidade);
        this.tamanho = tamanho;
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Tamanho: %s, Cor: %s", tamanho, cor);
    }
}
