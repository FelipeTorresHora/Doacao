package repository;

import model.CentroDistribuicao;
import model.Doacao;

import java.util.ArrayList;
import java.util.List;

public class CentroDistribuicaoRepository {
    private List<CentroDistribuicao> centros = new ArrayList<>();

    public CentroDistribuicaoRepository() {
        centros.add(new CentroDistribuicao(1, "Centro de Distribuição Esperança", "Av. Boqueirão, 2450 - Igara, Canoas - RS, 92032-420"));
        centros.add(new CentroDistribuicao(2, "Centro de Distribuição Prosperidade", "Av. Borges de Medeiros, 1501 – Cidade Baixa, Porto Alegre - RS, 90119-900"));
        centros.add(new CentroDistribuicao(3, "Centro de Distribuição Reconstrução", "R. Dr. Décio Martins Costa, 312 - Vila Eunice Nova, Cachoeirinha - RS, 94920-170"));
    }

    public List<CentroDistribuicao> findAll() {
        return centros;
    }

    public CentroDistribuicao findById(int id) {
        return centros.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public boolean podeAdicionarDoacao(CentroDistribuicao centro, Doacao doacao) {
        switch (doacao.getTipo()) {
            case ROUPA:
                return centro.getCapacidadeRoupa() + doacao.getQuantidade() <= 1000;
            case PRODUTO_HIGIENE:
                return centro.getCapacidadeHigiene() + doacao.getQuantidade() <= 1000;
            case ALIMENTO:
                return centro.getCapacidadeAlimento() + doacao.getQuantidade() <= 1000;
            default:
                return false;
        }
    }

    public void adicionarDoacao(CentroDistribuicao centro, Doacao doacao) {
        switch (doacao.getTipo()) {
            case ROUPA:
                centro.setCapacidadeRoupa(centro.getCapacidadeRoupa() + doacao.getQuantidade());
                break;
            case PRODUTO_HIGIENE:
                centro.setCapacidadeHigiene(centro.getCapacidadeHigiene() + doacao.getQuantidade());
                break;
            case ALIMENTO:
                centro.setCapacidadeAlimento(centro.getCapacidadeAlimento() + doacao.getQuantidade());
                break;
        }
    }
}
