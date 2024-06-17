package org.example.Model;

public class Eletronico extends Produto {
    private int garantiaMeses;

    public Eletronico(String nome, double preco, int garantiaMeses, int quantidade) {
        super(nome, preco, quantidade);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Garantia: %d meses", garantiaMeses);
    }
}
