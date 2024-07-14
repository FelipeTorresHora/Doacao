package repository;

import Enums.Tipo;
import model.Abrigo;
import model.CentroDistribuicao;
import model.Doacao;
import model.OrdemPedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CentroDistribuicaoRepository {
    private Map<Integer, CentroDistribuicao> centrosDistribuicao = new HashMap<>();

    public CentroDistribuicaoRepository() {
        // Inicializa os centros de distribuição fixos
        centrosDistribuicao.put(1, new CentroDistribuicao(1, "Centro de Distribuição Esperança", "Av. Boqueirão, 2450 - Igara, Canoas - RS, 92032-420"));
        centrosDistribuicao.put(2, new CentroDistribuicao(2, "Centro de Distribuição Prosperidade", "Av. Borges de Medeiros, 1501 – Cidade Baixa, Porto Alegre - RS, 90119-900"));
        centrosDistribuicao.put(3, new CentroDistribuicao(3, "Centro de Distribuição Reconstrução", "R. Dr. Décio Martins Costa, 312 - Vila Eunice Nova, Cachoeirinha - RS, 94920-170"));
    }

    public CentroDistribuicao findById(int id) {
        return centrosDistribuicao.get(id);
    }

    public List<CentroDistribuicao> findAll() {
        return new ArrayList<>(centrosDistribuicao.values());
    }

    public CentroDistribuicao findCentroComMaiorValor(Tipo tipo) {
        CentroDistribuicao centroMaiorValor = null;
        int maiorValor = 0;

        for (CentroDistribuicao centro : centrosDistribuicao.values()) {
            int quantidadeDisponivel = centro.getQuantidadeDisponivel(tipo);
            if (quantidadeDisponivel > maiorValor) {
                maiorValor = quantidadeDisponivel;
                centroMaiorValor = centro;
            }
        }

        return centroMaiorValor;
    }

    public boolean podeAdicionarDoacao(CentroDistribuicao centro, Doacao doacao) {
        // Verificar capacidade do centro de distribuição
        return centro.podeAdicionarDoacao(doacao);
    }

    public void adicionarDoacao(CentroDistribuicao centro, Doacao doacao) {
        // Adicionar doação ao centro de distribuição
        centro.adicionarDoacao(doacao);
    }

    public boolean podeTransferirParaAbrigo(CentroDistribuicao centro, Abrigo abrigo, OrdemPedido ordemPedido) {
        // Verificar se a quantidade pode ser transferida para o abrigo
        return centro.podeTransferirParaAbrigo(abrigo, ordemPedido);
    }

    public void transferirParaAbrigo(CentroDistribuicao centro, Abrigo abrigo, OrdemPedido ordemPedido) {
        // Transferir quantidade do centro de distribuição para o abrigo
        centro.transferirParaAbrigo(abrigo, ordemPedido);
    }
}
