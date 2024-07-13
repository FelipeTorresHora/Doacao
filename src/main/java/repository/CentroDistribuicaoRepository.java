package repository;

import model.CentroDistribuicao;
import java.util.ArrayList;
import java.util.List;

public class CentroDistribuicaoRepository {
    private List<CentroDistribuicao> centros = new ArrayList<>();

    public CentroDistribuicaoRepository() {
        centros.add(new CentroDistribuicao("Centro de Distribuição Esperança", "Av. Boqueirão, 2450 - Igara, Canoas - RS, 92032-420"));
        centros.add(new CentroDistribuicao("Centro de Distribuição Prosperidade", "Av. Borges de Medeiros, 1501 – Cidade Baixa, Porto Alegre - RS, 90119-900"));
        centros.add(new CentroDistribuicao("Centro de Distribuição Reconstrução", "R. Dr. Décio Martins Costa, 312 - Vila Eunice Nova, Cachoeirinha - RS, 94920-170"));
    }

    public List<CentroDistribuicao> findAll() {
        return centros;
    }
}
