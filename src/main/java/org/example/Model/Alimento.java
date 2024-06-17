package org.example.Model;

public class Alimento extends Produto {
    private String dataValidade;

    public Alimento(String nome, double preco, String dataValidade, int quantidade) {
        super(nome, preco, quantidade);
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Validade: %s", dataValidade);
    }
}
