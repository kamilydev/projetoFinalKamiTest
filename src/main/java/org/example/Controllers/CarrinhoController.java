package org.example.Controllers;

import org.example.Model.CarrinhoDeCompras;
import org.example.Model.Produto;

import java.util.List;

public class CarrinhoController {
    private List<CarrinhoDeCompras> listaCarrinhos;

    public CarrinhoController(List<CarrinhoDeCompras> listaCarrinhos) {
        this.listaCarrinhos = listaCarrinhos;
    }

    public void adicionarProdutoAoCarrinho(int carrinhoEscolhido, Produto produto) {
        CarrinhoDeCompras carrinho = listaCarrinhos.get(carrinhoEscolhido);
        carrinho.adicionarItem(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    public void listarProdutosDoCarrinho(int carrinhoEscolhido) {
        CarrinhoDeCompras carrinho = listaCarrinhos.get(carrinhoEscolhido);
        carrinho.listarItens();
        System.out.printf("Total: %.2f\n", carrinho.calcularTotal());
    }

    public void gerarArquivoDeTexto(int carrinhoEscolhido, String nomeArquivo) {
        CarrinhoDeCompras carrinho = listaCarrinhos.get(carrinhoEscolhido);
        carrinho.gerarArquivoTexto(nomeArquivo);
        System.out.println("Arquivo gerado com sucesso!");
    }
}
