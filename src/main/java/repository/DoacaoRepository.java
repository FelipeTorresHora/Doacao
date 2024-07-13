package repository;

import model.Doacao;

import java.util.ArrayList;
import java.util.List;

public class DoacaoRepository {
    private List<Doacao> doacoes = new ArrayList<>();

    public void save(Doacao doacao) {
        doacoes.add(doacao);
    }

    public List<Doacao> findAll() {
        return doacoes;
    }

    public void delete(int id) {
        doacoes.removeIf(d -> d.getId() == id);
    }

    public void importFromCsv(String filePath) {
        // Implementar a lógica para importar doações de um arquivo CSV
    }
}
