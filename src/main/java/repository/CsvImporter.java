package repository;

import Enums.*;

import model.CentroDistribuicao;
import model.Doacao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CsvImporter {
    private DoacaoRepository doacaoRepository;
    private CentroDistribuicaoRepository centroDistribuicaoRepository;

    public CsvImporter(DoacaoRepository doacaoRepository, CentroDistribuicaoRepository centroDistribuicaoRepository) {
        this.doacaoRepository = doacaoRepository;
        this.centroDistribuicaoRepository = centroDistribuicaoRepository;
    }

    public void importarCsv(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine && line.startsWith("tipo")) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(",");

                Tipo tipo = Tipo.valueOf(values[0].toUpperCase());
                String descricao = values[1];
                int quantidade = Integer.parseInt(values[2]);
                UnidadeMedida unidadeMedida = values[3].isEmpty() ? null : UnidadeMedida.valueOf(values[3].toUpperCase());
                String validadeStr = values[4];
                String validade = validadeStr.isEmpty() ? null : String.valueOf(new SimpleDateFormat("yyyy-MM-dd").parse(validadeStr));
                Genero genero = values[5].isEmpty() ? null : Genero.valueOf(values[5].toUpperCase());
                Tamanho tamanho = values[6].isEmpty() ? null : Tamanho.valueOf(values[6].toUpperCase());
                int centroDistribuicaoId = Integer.parseInt(values[7]);
                int idDoacao = Integer.parseInt(values[8]);

                CentroDistribuicao centro = centroDistribuicaoRepository.findById(centroDistribuicaoId);

                if (centro == null) {
                    System.out.println("Centro de distribuição não encontrado.");
                    continue;
                }

                Doacao doacao = new Doacao(tipo, descricao, genero, tamanho, unidadeMedida, quantidade, validade, centroDistribuicaoId, idDoacao);
                doacao.setCentroDistribuicaoId(centroDistribuicaoId);

                if (!centroDistribuicaoRepository.podeAdicionarDoacao(centro, doacao)) {
                    System.out.println("Capacidade do centro de distribuição excedida para este tipo de item.");
                    continue;
                }

                centroDistribuicaoRepository.adicionarDoacao(centro, doacao);
                doacaoRepository.save(doacao);
                doacaoRepository.adicionarDoacao(doacao);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
