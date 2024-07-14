package model;

import Enums.Tipo;

import java.util.HashMap;
import java.util.Map;

public class CentroDistribuicao {
    private int id;
    private String nome;
    private String endereco;
    private Map<Tipo, Integer> capacidade;
    private Map<Tipo, Integer> quantidadeDisponivel;

    public CentroDistribuicao(int id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.capacidade = new HashMap<>();
        this.quantidadeDisponivel = new HashMap<>();
        this.capacidade.put(Tipo.ROUPA, 1000);
        this.capacidade.put(Tipo.PRODUTO_HIGIENE, 1000);
        this.capacidade.put(Tipo.ALIMENTO, 1000);
        this.quantidadeDisponivel.put(Tipo.ROUPA, 0);
        this.quantidadeDisponivel.put(Tipo.PRODUTO_HIGIENE, 0);
        this.quantidadeDisponivel.put(Tipo.ALIMENTO, 0);
    }

    // Getters e setters

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getQuantidadeDisponivel(Tipo tipo) {
        return quantidadeDisponivel.get(tipo);
    }

    public boolean podeAdicionarDoacao(Doacao doacao) {
        int quantidadeAtual = quantidadeDisponivel.get(doacao.getTipo());
        int novaQuantidade = quantidadeAtual + doacao.getQuantidade();
        return novaQuantidade <= capacidade.get(doacao.getTipo());
    }

    public void adicionarDoacao(Doacao doacao) {
        int quantidadeAtual = quantidadeDisponivel.get(doacao.getTipo());
        quantidadeDisponivel.put(doacao.getTipo(), quantidadeAtual + doacao.getQuantidade());
    }

    public boolean podeTransferirParaAbrigo(Abrigo abrigo, OrdemPedido ordemPedido) {
        int quantidadeAtual = quantidadeDisponivel.get(ordemPedido.getTipo());
        return quantidadeAtual >= ordemPedido.getQuantidade() && abrigo.podeAdicionarPedido(ordemPedido);
    }

    public void transferirParaAbrigo(Abrigo abrigo, OrdemPedido ordemPedido) {
        int quantidadeAtual = quantidadeDisponivel.get(ordemPedido.getTipo());
        quantidadeDisponivel.put(ordemPedido.getTipo(), quantidadeAtual - ordemPedido.getQuantidade());
        abrigo.adicionarPedido(ordemPedido);
    }

    @Override
    public String toString() {
        return "CentroDistribuicao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", capacidade=" + capacidade +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                '}';
    }
}