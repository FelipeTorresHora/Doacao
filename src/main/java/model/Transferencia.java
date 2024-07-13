package model;

import java.util.List;

public class Transferencia {

    private int id;
    private CentroDistribuicao centroOrigem;
    private CentroDistribuicao centroDestino;
    private List<Doacao> itensTransferidos;

    public Transferencia(int id, CentroDistribuicao centroOrigem, CentroDistribuicao centroDestino, List<Doacao> itensTransferidos) {
        this.id = id;
        this.centroOrigem = centroOrigem;
        this.centroDestino = centroDestino;
        this.itensTransferidos = itensTransferidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CentroDistribuicao getCentroOrigem() {
        return centroOrigem;
    }

    public void setCentroOrigem(CentroDistribuicao centroOrigem) {
        this.centroOrigem = centroOrigem;
    }

    public CentroDistribuicao getCentroDestino() {
        return centroDestino;
    }

    public void setCentroDestino(CentroDistribuicao centroDestino) {
        this.centroDestino = centroDestino;
    }

    public List<Doacao> getItensTransferidos() {
        return itensTransferidos;
    }

    public void setItensTransferidos(List<Doacao> itensTransferidos) {
        this.itensTransferidos = itensTransferidos;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "id=" + id +
                ", centroOrigem=" + centroOrigem +
                ", centroDestino=" + centroDestino +
                ", itensTransferidos=" + itensTransferidos +
                '}';
    }
}
