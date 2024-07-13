package model;

import java.util.List;

public class OrdemPedido {

    private int id;
    private int origemId;
    private int destinoId;
    private String descricaoItens;

    public OrdemPedido() {
    }

    public OrdemPedido(int id, int origemId, int destinoId, String descricaoItens) {
        this.id = id;
        this.origemId = origemId;
        this.destinoId = destinoId;
        this.descricaoItens = descricaoItens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrigemId() {
        return origemId;
    }

    public void setOrigemId(int origemId) {
        this.origemId = origemId;
    }

    public int getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(int destinoId) {
        this.destinoId = destinoId;
    }

    public String getDescricaoItens() {
        return descricaoItens;
    }

    public void setDescricaoItens(String descricaoItens) {
        this.descricaoItens = descricaoItens;
    }

    @Override
    public String toString() {
        return "OrdemPedido{" +
                "id=" + id +
                ", origemId=" + origemId +
                ", destinoId=" + destinoId +
                ", descricaoItens='" + descricaoItens + '\'' +
                '}';
    }
}
