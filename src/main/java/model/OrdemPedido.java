package model;

import java.util.List;

public class OrdemPedido {

    private int id;
    private List<String> itensNecessarios;

    public OrdemPedido() {
    }

    public OrdemPedido(int id, List<String> itensNecessarios) {
        this.id = id;
        this.itensNecessarios = itensNecessarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getItensNecessarios() {
        return itensNecessarios;
    }

    public void setItensNecessarios(List<String> itensNecessarios) {
        this.itensNecessarios = itensNecessarios;
    }

    @Override
    public String toString() {
        return "OrdemPedido{" +
                "id=" + id +
                ", itensNecessarios=" + itensNecessarios +
                '}';
    }
}
