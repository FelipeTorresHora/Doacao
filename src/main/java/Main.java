import model.*;
import repository.*;
import Enums.*;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AbrigoRepository abrigoRepository = new AbrigoRepository();
    private static CentroDistribuicaoRepository centroDistribuicaoRepository = new CentroDistribuicaoRepository();
    private static DoacaoRepository doacaoRepository = new DoacaoRepository();
    private static OrdemPedidoRepository ordemPedidoRepository = new OrdemPedidoRepository();
    private static TransferenciaRepository transferenciaRepository = new TransferenciaRepository();
    private static CsvImporter csvImporter = new CsvImporter(doacaoRepository, centroDistribuicaoRepository);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Criar Abrigo");
            System.out.println("2. Listar Abrigos");
            System.out.println("3. Deletar Abrigo");
            System.out.println("4. Listar Centros de Distribuição");
            System.out.println("5. Criar Doação");
            System.out.println("6. Listar Doações");
            System.out.println("7. Deletar Doações");
            System.out.println("8. Adicionar Ordem de Pedido");
            System.out.println("9. Listar Ordens de Pedido");
            System.out.println("10. Adicionar Transferência");
            System.out.println("11. Listar Transferências");
            System.out.println("12. Importar Dados CSV");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcao) {
                case 1:
                    criarAbrigo();
                    break;
                case 2:
                    listarAbrigos();
                    break;
                case 3:
                    deletarAbrigo();
                    break;
                case 4:
                    listarCentrosDistribuicao();
                    break;
                case 5:
                    criarDoacao();
                    break;
                case 6:
                    listarDoacoes();
                    break;
                case 7:
                    deletarDoacoes();
                    break;
                case 8:
                    adicionarOrdemPedido();
                    break;
                case 9:
                    listarOrdemPedidos();
                    break;
                case 10:
                    adicionarTransferencia();
                    break;
                case 11:
                    listarTransferencias();
                    break;
                case 12:
                    importarCsv();
                    break;
                case 0:
                    System.out.println("Finalizando a aplicação!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void criarAbrigo() {
        System.out.println("\n--- Criar Abrigo ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Responsável: ");
        String responsavel = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Abrigo abrigo = new Abrigo(nome, endereco, responsavel, telefone, email);
        abrigoRepository.save(abrigo);
        System.out.println("Abrigo criado com sucesso!");
    }

    private static void listarAbrigos() {
        System.out.println("\n--- Listar Abrigos ---");
        List<Abrigo> abrigos = abrigoRepository.findAll();
        for (Abrigo abrigo : abrigos) {
            System.out.println(abrigo);
        }
    }

    private static void deletarAbrigo() {
        System.out.println("\n--- Deletar Abrigo ---");
        System.out.print("ID do Abrigo: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        abrigoRepository.delete(id);
        System.out.println("Abrigo deletado com sucesso!");
    }

    private static void listarCentrosDistribuicao() {
        System.out.println("\n--- Listar Centros de Distribuição ---");
        List<CentroDistribuicao> centros = centroDistribuicaoRepository.findAll();
        for (CentroDistribuicao centro : centros) {
            System.out.println(centro);
        }
    }

    private static void criarDoacao() {
        System.out.println("Digite o tipo de doação (ROUPA, PRODUTO_HIGIENE, ALIMENTO): ");
        String tipoStr = scanner.nextLine();
        Tipo tipo = Tipo.valueOf(tipoStr.toUpperCase());

        System.out.println("Digite a descrição: ");
        String descricao = scanner.nextLine();

        System.out.println("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a unidade de medida (QUILO, GRAMAS, LITRO) ou deixe em branco: ");
        String unidadeStr = scanner.nextLine();
        UnidadeMedida unidadeMedida = unidadeStr.isEmpty() ? null : UnidadeMedida.valueOf(unidadeStr.toUpperCase());

        System.out.println("Digite a validade (yyyy-MM-dd) ou deixe em branco: ");
        String validadeStr = scanner.nextLine();
        String validade = validadeStr.isEmpty() ? null : String.valueOf(LocalDate.parse(validadeStr));

        System.out.println("Digite o gênero (MASCULINO, FEMININO) ou deixe em branco: ");
        String generoStr = scanner.nextLine();
        Genero genero = generoStr.isEmpty() ? null : Genero.valueOf(generoStr.toUpperCase());

        System.out.println("Digite o tamanho (INFANTIL, PP, P, M, G, GG) ou deixe em branco: ");
        String tamanhoStr = scanner.nextLine();
        Tamanho tamanho = tamanhoStr.isEmpty() ? null : Tamanho.valueOf(tamanhoStr.toUpperCase());

        System.out.println("Digite o ID do centro de distribuição: ");
        int centroDistribuicaoId = scanner.nextInt();
        scanner.nextLine();
        CentroDistribuicao centro = centroDistribuicaoRepository.findById(centroDistribuicaoId);

        System.out.print("IdDoacao: ");
        int idDoacao = scanner.nextInt();
        scanner.nextLine();

        Doacao doacao = new Doacao(tipo, descricao, genero, tamanho, unidadeMedida, quantidade, validade,centroDistribuicaoId,idDoacao);
        doacao.setCentroDistribuicaoId(centroDistribuicaoId);

        if (!centroDistribuicaoRepository.podeAdicionarDoacao(centro, doacao)) {
            System.out.println("Capacidade do centro de distribuição excedida para este tipo de item.");
            return;
        }


        centroDistribuicaoRepository.adicionarDoacao(centro, doacao);
        doacaoRepository.save(doacao);
        doacaoRepository.adicionarDoacao(doacao);
        System.out.println("Doação criada com sucesso!");
    }

    private static void listarDoacoes() {
        List<Doacao> doacoes = doacaoRepository.listarDoacoes();
        for (Doacao doacao : doacoes) {
            System.out.println(doacao);
        }
    }

    private static void deletarDoacoes() {
        System.out.println("Digite o ID da doação a ser deletada: ");
        int idDoacao = scanner.nextInt();
        scanner.nextLine();
        doacaoRepository.deletarDoacao(idDoacao);
        System.out.println("Doação deletada com sucesso!");
    }
    private static void adicionarOrdemPedido() {
        System.out.println("\n--- Adicionar Ordem de Pedido ---");
        System.out.print("ID do Abrigo: ");
        int abrigoId = scanner.nextInt();
        scanner.nextLine();

        Abrigo abrigo = abrigoRepository.findById(abrigoId);
        if (abrigo == null) {
            System.out.println("Abrigo não encontrado.");
            return;
        }

        System.out.print("Tipo (ROUPA, PRODUTO_HIGIENE, ALIMENTO): ");
        Tipo tipo = Tipo.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        OrdemPedido ordemPedido = new OrdemPedido(tipo, descricao, quantidade);
        abrigoRepository.adicionarOrdemPedido(abrigo, ordemPedido);
        ordemPedidoRepository.save(ordemPedido);

        CentroDistribuicao centroSelecionado = centroDistribuicaoRepository.findCentroComMaiorValor(tipo);
        if (centroSelecionado == null) {
            System.out.println("Nenhum centro de distribuição possui o tipo de item solicitado.");
            return;
        }

        System.out.println("Centro de Distribuição selecionado: " + centroSelecionado.getNome() + " com " + centroSelecionado.getQuantidadeDisponivel(tipo) + " unidades disponíveis.");
        System.out.print("Deseja confirmar o envio? (SIM/NAO): ");
        String confirmacao = scanner.nextLine().toUpperCase();

        if (confirmacao.equals("SIM")) {
            if (!centroDistribuicaoRepository.podeTransferirParaAbrigo(centroSelecionado, abrigo, ordemPedido)) {
                System.out.println("Capacidade do abrigo excedida para este tipo de item.");
                return;
            }

            centroDistribuicaoRepository.transferirParaAbrigo(centroSelecionado, abrigo, ordemPedido);
            System.out.println("Pedido enviado com sucesso!");
        } else {
            System.out.print("Digite o motivo da recusa: ");
            String motivop = scanner.nextLine();
            System.out.println("Envio cancelado por " +motivop);
        }
    }

    private static void listarOrdemPedidos() {
        List<OrdemPedido> ordensPedido = ordemPedidoRepository.findAll();
        for (OrdemPedido ordemPedido : ordensPedido) {
            System.out.println(ordemPedido);
        }
    }

    private static void adicionarTransferencia() {
        System.out.print("Tipo de item (ROUPA, PRODUTO_HIGIENE, ALIMENTO): ");
        Tipo tipo = Tipo.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        CentroDistribuicao centroOrigem = centroDistribuicaoRepository.findCentroComMaiorValor(tipo);
        if (centroOrigem == null || centroOrigem.getQuantidadeDisponivel(tipo) < quantidade) {
            System.out.println("Transferência não pode ser realizada. Quantidade insuficiente no centro de origem.");
            return;
        }

        System.out.println("Centro de Origem: " + centroOrigem.getNome());
        System.out.print("Confirmar transferência? (SIM/NAO): ");
        String confirmacao = scanner.nextLine().toUpperCase();
        if (!confirmacao.equalsIgnoreCase("SIM")) {
            System.out.println("Transferência cancelada.");
            return;
        } else {
            System.out.print("Digite o motivo da recusa: ");
            String motivot = scanner.nextLine();
            System.out.println("Transferencia cancelado por: " +motivot);
        }

        System.out.print("ID do Centro de Destino: ");
        int centroDestinoId = scanner.nextInt();
        scanner.nextLine();

        CentroDistribuicao centroDestino = centroDistribuicaoRepository.findById(centroDestinoId);
        if (centroDestino == null) {
            System.out.println("Centro de destino não encontrado.");
            return;
        }

        if (centroDestino.getQuantidadeDisponivel(tipo) + quantidade > 1000) {
            System.out.println("Transferência não pode ser realizada. Quantidade excede a capacidade do centro de destino.");
            return;
        }

        centroOrigem.removerItens(tipo, quantidade);
        centroDestino.adicionarItens(tipo, quantidade);
        Transferencia transferencia = new Transferencia(tipo, quantidade, centroOrigem.getId(), centroDestinoId);
        transferenciaRepository.save(transferencia);

        System.out.println("Transferência realizada com sucesso.");
    }


    private static void listarTransferencias() {
        for (Transferencia transferencia : transferenciaRepository.findAll()) {
            System.out.println(transferencia);
        }
    }

    private static void importarCsv() {
        String filePath = "C:\\Users\\Felipe\\Downloads\\doacoes.xlsx";
        csvImporter.importarCsv(filePath);
        System.out.println("Importação de doações concluída com sucesso.");
    }
}