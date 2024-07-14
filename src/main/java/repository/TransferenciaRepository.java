package repository;

import model.Transferencia;

import java.util.ArrayList;
import java.util.List;

public class TransferenciaRepository {
    private List<Transferencia> transferencias;

    public TransferenciaRepository() {
        this.transferencias = new ArrayList<>();
    }

    public void save(Transferencia transferencia) {
        transferencias.add(transferencia);
    }

    public List<Transferencia> findAll() {
        return new ArrayList<>(transferencias);
    }
}
