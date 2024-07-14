package model;

import java.util.ArrayList;
import java.util.List;


public class Abrigo {
    private int id;
    private String nome;
    private String endereco;
    private String responsavel;
    private String telefone;
    private String email;
    private List<OrdemPedido> ordensPedido;
    private int capacidadeRoupa = 200;
    private int capacidadeProdutoHigiene = 200;
    private int capacidadeAlimento = 200;

    public Abrigo(String nome, String endereco, String responsavel, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.responsavel = responsavel;
        this.telefone = telefone;
        this.email = email;
        this.ordensPedido = new ArrayList<>();
    }

    // Getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public List<OrdemPedido> getOrdensPedido() {
        return ordensPedido;
    }

    public void adicionarOrdemPedido(OrdemPedido ordemPedido) {
        this.ordensPedido.add(ordemPedido);
    }

    public boolean podeAdicionarDoacao(Doacao doacao) {
        switch (doacao.getTipo()) {
            case ROUPA:
                return capacidadeRoupa >= doacao.getQuantidade();
            case PRODUTO_HIGIENE:
                return capacidadeProdutoHigiene >= doacao.getQuantidade();
            case ALIMENTO:
                return capacidadeAlimento >= doacao.getQuantidade();
            default:
                return false;
        }
    }

    public void adicionarDoacao(Doacao doacao) {
        switch (doacao.getTipo()) {
            case ROUPA:
                capacidadeRoupa -= doacao.getQuantidade();
                break;
            case PRODUTO_HIGIENE:
                capacidadeProdutoHigiene -= doacao.getQuantidade();
                break;
            case ALIMENTO:
                capacidadeAlimento -= doacao.getQuantidade();
                break;
        }
    }

    public boolean podeAdicionarPedido(OrdemPedido ordemPedido) {
        switch (ordemPedido.getTipo()) {
            case ROUPA:
                return capacidadeRoupa >= ordemPedido.getQuantidade();
            case PRODUTO_HIGIENE:
                return capacidadeProdutoHigiene >= ordemPedido.getQuantidade();
            case ALIMENTO:
                return capacidadeAlimento >= ordemPedido.getQuantidade();
            default:
                return false;
        }
    }

    public void adicionarPedido(OrdemPedido ordemPedido) {
        switch (ordemPedido.getTipo()) {
            case ROUPA:
                capacidadeRoupa -= ordemPedido.getQuantidade();
                break;
            case PRODUTO_HIGIENE:
                capacidadeProdutoHigiene -= ordemPedido.getQuantidade();
                break;
            case ALIMENTO:
                capacidadeAlimento -= ordemPedido.getQuantidade();
                break;
        }
    }

    @Override
    public String toString() {
        return "Abrigo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", ordensPedido=" + ordensPedido +
                ", capacidadeRoupa=" + capacidadeRoupa +
                ", capacidadeProdutoHigiene=" + capacidadeProdutoHigiene +
                ", capacidadeAlimento=" + capacidadeAlimento +
                '}';
    }
}
