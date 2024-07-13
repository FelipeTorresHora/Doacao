package repository;

import model.Transferencia;

import java.util.ArrayList;
import java.util.List;

public class TransferenciaRepository {
    private List<Transferencia> transferencias = new ArrayList<>();

    public void save(Transferencia transferencia) {
        transferencias.add(transferencia);
    }

    public List<Transferencia> findAll() {
        return transferencias;
    }
}
