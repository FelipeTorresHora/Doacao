package repository;

import model.Abrigo;
import model.Doacao;

import java.util.ArrayList;
import java.util.List;

public class AbrigoRepository {

    private List<Abrigo> abrigos = new ArrayList<>();

    public void save(Abrigo abrigo) {
        abrigos.add(abrigo);
    }

    public List<Abrigo> findAll() {
        return abrigos;
    }

    public void delete(int id) {
        abrigos.removeIf(a -> a.getId() == id);
    }

    public boolean podeAdicionarDoacao(Abrigo abrigo, Doacao doacao) {
        switch (doacao.getTipo()) {
            case ROUPA:
                return abrigo.getCapacidadeRoupa() + doacao.getQuantidade() <= 200;
            case PRODUTO_HIGIENE:
                return abrigo.getCapacidadeHigiene() + doacao.getQuantidade() <= 200;
            case ALIMENTO:
                return abrigo.getCapacidadeAlimento() + doacao.getQuantidade() <= 200;
            default:
                return false;
        }
    }
}
