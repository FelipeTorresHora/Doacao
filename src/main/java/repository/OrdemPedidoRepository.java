package repository;

import model.OrdemPedido;

import java.util.ArrayList;
import java.util.List;

public class OrdemPedidoRepository {
    private List<OrdemPedido> ordens = new ArrayList<>();

    public void save(OrdemPedido ordemPedido) {
        ordens.add(ordemPedido);
    }

    public List<OrdemPedido> findAll() {
        return ordens;
    }
}
