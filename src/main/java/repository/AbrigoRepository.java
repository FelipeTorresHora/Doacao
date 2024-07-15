package repository;

import model.Abrigo;
import model.OrdemPedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbrigoRepository {
    private Map<Integer, Abrigo> abrigos = new HashMap<>();
    private int currentId = 1;

    public void save(Abrigo abrigo) {
        abrigo.setId(currentId++);
        abrigos.put(abrigo.getId(), abrigo);
    }

    public List<Abrigo> findAll() {
        return new ArrayList<>(abrigos.values());
    }

    public Abrigo findById(int id) {
        return abrigos.get(id);
    }

    public void delete(int id) {
        abrigos.remove(id);
    }

    public void adicionarOrdemPedido(Abrigo abrigo, OrdemPedido ordemPedido) {
        abrigo.adicionarOrdemPedido(ordemPedido);
    }
}
