package model;

import Enums.Tipo;

import java.util.Date;
import java.util.List;

public class OrdemPedido {
    private int id;
    private Tipo tipo;
    private String descricao;
    private int quantidade;
    private int abrigoId;
    private Date dataPedido;

    public OrdemPedido(Tipo tipo, String descricao, int quantidade) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.dataPedido = new Date();
    }

    // Getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getAbrigoId() {
        return abrigoId;
    }

    public void setAbrigoId(int abrigoId) {
        this.abrigoId = abrigoId;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    @Override
    public String toString() {
        return "OrdemPedido{" +
                "id=" + id +
                ", tipo=" + tipo +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", abrigoId=" + abrigoId +
                ", dataPedido=" + dataPedido +
                '}';
    }
}
