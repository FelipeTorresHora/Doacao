package model;

import Enums.Tipo;

import java.util.List;

public class Transferencia {
    private Tipo tipo;
    private int quantidade;
    private int centroOrigemId;
    private int centroDestinoId;

    public Transferencia(Tipo tipo, int quantidade, int centroOrigemId, int centroDestinoId) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.centroOrigemId = centroOrigemId;
        this.centroDestinoId = centroDestinoId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCentroOrigemId() {
        return centroOrigemId;
    }

    public void setCentroOrigemId(int centroOrigemId) {
        this.centroOrigemId = centroOrigemId;
    }

    public int getCentroDestinoId() {
        return centroDestinoId;
    }

    public void setCentroDestinoId(int centroDestinoId) {
        this.centroDestinoId = centroDestinoId;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "tipo=" + tipo +
                ", quantidade=" + quantidade +
                ", centroOrigemId=" + centroOrigemId +
                ", centroDestinoId=" + centroDestinoId +
                '}';
    }
}
